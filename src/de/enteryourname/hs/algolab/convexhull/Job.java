package de.enteryourname.hs.algolab.convexhull;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a single task for the stack processing of the convex hull
 * @author Michael Klein
 *
 */
public class Job {

	private List<Point2D> pointsAboveLine = new ArrayList<Point2D>();
	private Point2D lineStart;
	private Point2D lineEnd;

	
	/**
	 * A single task for the convex hull calculation.
	 * @param pointsAboveLine	points which are above the line of this job
	 * @param lineStart			start point of the line
	 * @param lineEnd			end point of the line
	 */
	public Job(List<Point2D> pointsAboveLine, Point2D lineStart, Point2D lineEnd) {
		this.setLineEnd(lineEnd);
		this.setLineStart(lineStart);
		this.setPoints(pointsAboveLine);
	
	}
	
	/**
	 * Get the points 
	 * @return the points
	 */
	public List<Point2D> getPointsAboveLine() {
		return pointsAboveLine;
	}
	
	/**
	 * Set the point set
	 * @param pointsAboveLine	the points to be set
	 */
	public void setPoints(List<Point2D> pointsAboveLine) {
		this.pointsAboveLine = pointsAboveLine;
	}
	
	/**
	 * get the start point of the line
	 * @return the start point
	 */
	public Point2D getLineStart() {
		return lineStart;
	}
	
	/**
	 * Set the start point of the line
	 * @param lineStart	start point of the line
	 */
	public void setLineStart(Point2D lineStart) {
		this.lineStart = lineStart;
	}
	
	/**
	 * Get the end point of the line
	 * @return the end point
	 */
	public Point2D getLineEnd() {
		return lineEnd;
	}
	
	/**
	 * Set the end point of the line
	 * @param lineEnd	end point of the line
	 */
	public void setLineEnd(Point2D lineEnd) {
		this.lineEnd = lineEnd;
	}


}
