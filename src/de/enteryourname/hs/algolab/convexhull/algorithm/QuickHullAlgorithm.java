package de.enteryourname.hs.algolab.convexhull.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import de.enteryourname.hs.algolab.convexhull.Job;
import de.enteryourname.hs.algolab.convexhull.Point2D;
import de.enteryourname.hs.algolab.dataset.Dataset;

/**
 * Implementation of the QuickHull algorithm
 * @author Tobias Keller
 *
 */
public class QuickHullAlgorithm implements Algorithm {
	
	private boolean useStack = true;

	private List<Point2D> convexHull = new ArrayList<Point2D>();
	
	
	/**
	 * Define if the recursive or the stack-version of the algorithm 
	 * will be used. 
	 * @param useStack false = recursive, true = stack
	 */
	public void useOwnStack(boolean useStack) {
		this.useStack = useStack;
	}
	

	@Override
	public List<Point2D> calculate(Dataset object) {
		
		// reset result-list
		this.convexHull.clear();
		
		List<Point2D> dataset = object.getPoints();

		// find mostLeft and mostRight Point
		Point2D mostLeftPoint = dataset.get(0);
		Point2D mostRightPoint = dataset.get(0);
		for (Point2D point : dataset) {
			// most left
			if (point.getX() < mostLeftPoint.getX()) {
				mostLeftPoint = point;
			} else if (point.getX() == mostLeftPoint.getX() && point.getY() < mostLeftPoint.getY()) {
				mostLeftPoint = point;
			}
			
			// most right
			if (point.getX() > mostRightPoint.getX()) {
				mostRightPoint = point;
			} else if (point.getX() == mostRightPoint.getX() && point.getY() > mostRightPoint.getY()) {
				mostRightPoint = point;
			}
		}
						
		if (useStack) {
			this.addHullPoint(mostLeftPoint);
			this.calcHalfHullStackSupported(dataset, mostLeftPoint, mostRightPoint);
		} else {
			this.addHullPoint(mostLeftPoint);
			this.calcHalfHullRecursive(dataset, mostLeftPoint, mostRightPoint);
			this.addHullPoint(mostRightPoint);
			this.calcHalfHullRecursive(dataset, mostRightPoint, mostLeftPoint);
		}
		
		return this.convexHull;
	}
	
	
	/**
	 * Calculate the convex hull on the left side of the given line,
	 * using recursive calls.
	 * @param points	points to examine
	 * @param lineStart	start point of the line
	 * @param lineEnd	end point of the line
	 */
	private void calcHalfHullRecursive(List<Point2D> points, Point2D lineStart, Point2D lineEnd) {
		List<Point2D> pointsAbove = pointsAboveLine(points, lineStart, lineEnd);
		
		// break if no points exists..
		if (pointsAbove.size() == 0) return;
		
		double distance = 0;
		double lastDistance;
		Point2D hullPoint = null; 
		// find point with greatest distance
		for (Point2D point : pointsAbove) {
			lastDistance = point.distanceToLine(lineStart, lineEnd);
			if (lastDistance >= distance) {
				distance = lastDistance;
				hullPoint = point;
			}
		}
		
		this.calcHalfHullRecursive(pointsAbove, lineStart, hullPoint);
		this.addHullPoint(hullPoint);
		this.calcHalfHullRecursive(pointsAbove, hullPoint, lineEnd);
	}
	
	
	/**
	 * Calculate the convex hull using a stack.
	 * @param points	points to examine
	 * @param lineStart	start point of the line
	 * @param lineEnd	end point of the line
	 */
	private void calcHalfHullStackSupported(List<Point2D> points, Point2D lineStart, Point2D lineEnd) {
		Stack<Job> stack = new Stack<Job>();

		stack.push(new Job(pointsAboveLine(points, lineEnd, lineStart), lineEnd, lineStart)); // right 1
		stack.push(new Job(pointsAboveLine(points, lineStart, lineEnd), lineStart, lineEnd)); // left 2

		while (!stack.empty()) {
			Job job = stack.pop();
			
			if (job.getPointsAboveLine().size() == 0) {
				// no left points -> add end point to convex hull
				addHullPoint(job.getLineEnd());
			} else {
				double distance = 0;
				double lastDistance;
				Point2D hullPoint = null;
				// find point with greatest distance
				for (Point2D point : job.getPointsAboveLine()) {
					lastDistance = point.distanceToLine(job.getLineStart(),job.getLineEnd());
					if (lastDistance >= distance) {
						distance = lastDistance;
						hullPoint = point;
					}
				}

				stack.push(new Job(pointsAboveLine(job.getPointsAboveLine(), hullPoint, job.getLineEnd()), hullPoint, job.getLineEnd()));
				stack.push(new Job(pointsAboveLine(job.getPointsAboveLine(), job.getLineStart(), hullPoint), job.getLineStart(),hullPoint));
			}

		}
	}

	
	/**
	 * Calculates which points are above the given line.
	 * @param points	points to examine
	 * @param lineStart	start point of the line
	 * @param lineEnd	end point of the line
	 * @return the points which are above the given line
	 */
	public List<Point2D> pointsAboveLine(List<Point2D> points,Point2D lineStart, Point2D lineEnd) {
		List<Point2D> pointsAbove = new ArrayList<Point2D>();
		
		for (Point2D point : points) {
			if (point.isAboveLine(lineStart, lineEnd) == 1) {
				pointsAbove.add(point);
			}
		}
		return pointsAbove;
	}
	

	/**
	 * Add the given point to the convex hull, when the point is not already in it.
	 * @param point	to add to the convex hull
	 */
	private void addHullPoint(Point2D point) {
		if (this.convexHull.size() == 0 || point.compareTo(this.convexHull.get(this.convexHull.size()-1)) != 0) {
			this.convexHull.add(point);
		}
	}
	
	
}
