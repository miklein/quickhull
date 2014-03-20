package de.enteryourname.hs.algolab.convexhull.algorithm;

import java.util.ArrayList;
import java.util.List;

import de.enteryourname.hs.algolab.convexhull.Point2D;
import de.enteryourname.hs.algolab.dataset.Dataset;

/**
 * Implementation of Chans algorithm
 * @author Tobias Keller
 *
 */
public class QuickHullAlgorithm implements Algorithm {

	private List<Point2D> convexHull = new ArrayList<Point2D>();
	
	@Override
	public List<Point2D> calculate(Dataset object) {
		
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
		
		this.addHullPoint(mostLeftPoint);
		this.calcUpperHull(dataset, mostLeftPoint, mostRightPoint);
		this.addHullPoint(mostRightPoint);
		System.out.println("now the lower hull..");
		this.calcUpperHull(dataset, mostRightPoint, mostLeftPoint);
		
		return this.convexHull;
	}
	
	
	
	
	
	private void calcUpperHull(List<Point2D> points, Point2D lineStart, Point2D lineEnd) {

		
		
		List<Point2D> upperPoints = new ArrayList<Point2D>();
		List<Point2D> lowerPoints = new ArrayList<Point2D>();
		
		// divide
		for (Point2D point : points) {
			
			
			// alle punkte die oberhalb der linie liegen
			// if (point.isAboveLine(lineStart, lineEnd) == 1) {
			
			// alle punkte die oberhalb oder AUF der linie liegen
			if (point.isAboveLine(lineStart, lineEnd) != -1) {
				upperPoints.add(point);
			} else {
				lowerPoints.add(point);
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
		
		
		this.calcUpperHull(upperPoints, lineStart, hullPoint);
		this.addHullPoint(hullPoint);
		this.calcUpperHull(upperPoints, hullPoint, lineEnd);
		
		
		
	}
	
	
	private void calcLowerHull(List<Point2D> points, Point2D lineStart, Point2D lineEnd) {
		
		if (points.size() == 1) {
			System.out.println("Pool is empty!");
			this.addHullPoint(points.get(0));
			return;
		}
		
		List<Point2D> upperPoints = new ArrayList<Point2D>();
		List<Point2D> lowerPoints = new ArrayList<Point2D>();
		
		// divide
		for (Point2D point : points) {
			if (point.isAboveLine(lineStart, lineEnd) == 1) {
				upperPoints.add(point);
			} else {
				lowerPoints.add(point);
			}
		}
		
		double distance = 0;
		Point2D hullPoint = new Point2D(0, 0); 
		// find point with greatest distance
		for (Point2D point : lowerPoints) {
			double temp = point.distanceToLine(lineStart, lineEnd);
			if (temp >= distance) {
				distance = temp;
				hullPoint = point;
			}
		}
		
		lowerPoints.remove(lowerPoints.indexOf(hullPoint));
		
		this.calcUpperHull(lowerPoints, lineStart, hullPoint);
		
		this.addHullPoint(hullPoint);
		
	}
	
	
	
	
	
	private void addHullPoint(Point2D point) {
		this.convexHull.add(point);
		//System.out.println("addHullPoint: "+point);
	}
	
	
	
	
}
