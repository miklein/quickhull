package de.enteryourname.hs.algolab.convexhull.algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import de.enteryourname.hs.algolab.convexhull.Job;
import de.enteryourname.hs.algolab.convexhull.Point2D;
import de.enteryourname.hs.algolab.dataset.Dataset;

/**
 * Implementation of QuickHull algorithm
 * @author Tobias Keller
 *
 */
public class QuickHullAlgorithm implements Algorithm {
	
	private boolean bUseOwnStack = true;

	private List<Point2D> convexHull = new ArrayList<Point2D>();
	
	
	public void useOwnStack(boolean useStack) {
		this.bUseOwnStack = useStack;
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
			
		
		// linie zwischen mostLeftPoint und mostRightPoint
		dataset.remove(dataset.indexOf(mostRightPoint));
		dataset.remove(dataset.indexOf(mostLeftPoint));
		
		if (bUseOwnStack) {
			this.addHullPoint(mostLeftPoint);
			this.calcHalfHullStackSupported(dataset, mostLeftPoint, mostRightPoint);
			this.addHullPoint(mostRightPoint);
			this.calcHalfHullStackSupported(dataset, mostRightPoint, mostLeftPoint);
		} else {
			this.addHullPoint(mostLeftPoint);
			this.calcHalfHull(dataset, mostLeftPoint, mostRightPoint);
			this.addHullPoint(mostRightPoint);
			this.calcHalfHull(dataset, mostRightPoint, mostLeftPoint);
		}
		
		return this.convexHull;
	}
	
	
	
	
	
	private void calcHalfHull(List<Point2D> points, Point2D lineStart, Point2D lineEnd) {
		
		List<Point2D> upperPoints = new ArrayList<Point2D>();
		
		// divide
		for (Point2D point : points) {
			if (point.isAboveLine(lineStart, lineEnd) == 1) {
				upperPoints.add(point);
			}
		}
		
		// break if no points exists..
		if (upperPoints.size() == 0) return;
		
		double distance = 0;
		Point2D hullPoint = null; 
		// find point with greatest distance
		for (Point2D point : upperPoints) {
			double temp = point.distanceToLine(lineStart, lineEnd);
			if (temp >= distance) {
				distance = temp;
				hullPoint = point;
			}
		}
		
		upperPoints.remove(upperPoints.indexOf(hullPoint));
		
		this.calcHalfHull(upperPoints, lineStart, hullPoint);
		this.addHullPoint(hullPoint);
		this.calcHalfHull(upperPoints, hullPoint, lineEnd);
	}
	
	
	
	private void calcHalfHullStackSupported(List<Point2D> points, Point2D lineStart, Point2D lineEnd) {
		
		System.out.println("=======================================0");
		System.out.println("points:"+points);
		System.out.println("Line: "+lineStart+" -> "+lineEnd);
		
		Stack<Job> stack = new Stack<Job>();
		Stack<Point2D> resultStack = new Stack<Point2D>();
		String lastJobType = "";
		
		resultStack.clear();
		stack.clear();
		
		stack.push(new Job(points, lineStart, lineEnd, "init"));
		System.out.println("Starte StackSupport..");
		while (!stack.empty()) {
			System.out.println(stack);
			Job job = stack.pop();
			
			System.out.println("=======================================");
			System.out.println("points:"+job.getPoints());
			System.out.println("Line: "+job.getLineStart()+" -> "+job.getLineEnd());
			System.out.println("---------------------------------------");
			
			
			if (lastJobType == "A" && job.getType() == "B") {
				while(!resultStack.empty()) this.addHullPoint(resultStack.pop());
			}
			lastJobType = job.getType();
			
			
			//System.out.println("punkte"+points);
			List<Point2D> upperPoints = new ArrayList<Point2D>();
			
			// divide
			for (Point2D point : job.getPoints()) {
				if (point.isAboveLine(job.getLineStart(), job.getLineEnd()) == 1) {
					upperPoints.add(point);
				}
			}
			
			// break if no points exists..
			if (upperPoints.size() == 0) continue;
			
			double distance = 0;
			Point2D hullPoint = null; 
			// find point with greatest distance
			for (Point2D point : upperPoints) {
				double temp = point.distanceToLine(job.getLineStart(), job.getLineEnd());
				if (temp >= distance) {
					distance = temp;
					hullPoint = point;
				}
			}
			
			upperPoints.remove(upperPoints.indexOf(hullPoint));

//			this.calcHalfHull(upperPoints, lineStart, hullPoint);
//			this.addHullPoint(hullPoint);
//			this.calcHalfHull(upperPoints, hullPoint, lineEnd);

			stack.push(new Job(upperPoints, hullPoint, job.getLineEnd(), "B"));
			stack.push(new Job(upperPoints, job.getLineStart(), hullPoint, "A"));
			resultStack.push(hullPoint);
			
		}

		//while(!resultStack.empty()) this.addHullPoint(resultStack.pop());

		
		
	}
	
	
	
	
	
	
	private void addHullPoint(Point2D point) {
		//System.out.println("add hull point: "+point);
		// check if point is already in the hull-list
		// this solves tripple-entries if a source-point exists twice
		if (this.convexHull.size() == 0 || point.compareTo(this.convexHull.get(this.convexHull.size()-1)) != 0) {
			this.convexHull.add(point);
		}
	}
	
	
	
	
}
