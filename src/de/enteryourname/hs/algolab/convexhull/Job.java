package de.enteryourname.hs.algolab.convexhull;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author michi
 *
 */
public class Job {

	private List<Point2D> points = new ArrayList<Point2D>();
	private Point2D lineStart;
	private Point2D lineEnd;
	private String type;
	
	/**
	 * 
	 * @param points
	 * @param lineStart
	 * @param lineEnd
	 * @param type
	 */
	public Job(List<Point2D> points, Point2D lineStart, Point2D lineEnd, String type) {
		this.setLineEnd(lineEnd);
		this.setLineStart(lineStart);
		this.setPoints(points);
		this.setType(type);
	}
	
	/**
	 * get the point list
	 * @return the point list
	 */
	public List<Point2D> getPoints() {
		return points;
	}
	
	/**
	 * set the point list
	 * @param points 
	 */
	public void setPoints(List<Point2D> points) {
		this.points = points;
	}
	
	/**
	 * get the start point of the line
	 * @return the start point
	 */
	public Point2D getLineStart() {
		return lineStart;
	}
	
	/**
	 * set the start point of the line
	 * @param lineStart
	 */
	public void setLineStart(Point2D lineStart) {
		this.lineStart = lineStart;
	}
	
	/**
	 * get the end point of the line
	 * @return the end point
	 */
	public Point2D getLineEnd() {
		return lineEnd;
	}
	
	/**
	 * set the end point of the line
	 * @param lineEnd
	 */
	public void setLineEnd(Point2D lineEnd) {
		this.lineEnd = lineEnd;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return this.getType();
	}
	
}
