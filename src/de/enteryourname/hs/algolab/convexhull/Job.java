package de.enteryourname.hs.algolab.convexhull;

import java.util.ArrayList;
import java.util.List;

public class Job {

	private List<Point2D> points = new ArrayList<Point2D>();
	private Point2D lineStart;
	private Point2D lineEnd;
	private String type;
	
	public List<Point2D> getPoints() {
		return points;
	}
	public void setPoints(List<Point2D> points) {
		this.points = points;
	}
	public Point2D getLineStart() {
		return lineStart;
	}
	public void setLineStart(Point2D lineStart) {
		this.lineStart = lineStart;
	}
	public Point2D getLineEnd() {
		return lineEnd;
	}
	public void setLineEnd(Point2D lineEnd) {
		this.lineEnd = lineEnd;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Job(List<Point2D> points, Point2D lineStart, Point2D lineEnd, String type) {
		this.setLineEnd(lineEnd);
		this.setLineStart(lineStart);
		this.setPoints(points);
		this.setType(type);
	}
	
	public String toString() {
		return this.getType();
	}
	
}
