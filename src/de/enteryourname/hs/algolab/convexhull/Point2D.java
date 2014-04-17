package de.enteryourname.hs.algolab.convexhull;

/**
 * Class for the representation of a point in an 2D-System
 * @author Tobias Keller
 *
 */
public class Point2D implements Comparable<Point2D> {
	
	private double x;
	private double y;
	
	/** 
	 * Point at position x,y
	 * @param x the x-value of the point
	 * @param y the y-value of the point
	 */
	public Point2D(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * Get the x-value of the point
	 * @return the x-value
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Get the y-value of the point
	 * @return the y-value
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * Set the x-value of the point
	 * @param x	 the x-value of the point
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Set the y-value of the point
	 * @param y	the y-value of the point
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Check if this point is above the line between the two given points.
	 * @param start start point of the line
	 * @param end 	end point of the line
	 * @return		1 if the point is above the line, -1 if it is below and 0 if it is on the line	
	 */
	public int isAboveLine(Point2D start, Point2D end) {
		
		// System.out.println("Pr�fe ob "+this+" �ber Linie ("+start+" -> "+end+")");
		
		// vector from start to end
		double vector1x = end.getX() - start.getX();
		double vecotr1y = end.getY() - start.getY();
		
		// vector from start to this point
		double vecotr2x = this.getX() - start.getX();
		double vector2y = this.getY() - start.getY();
		
		// crossproduct
		double crossproduct = (vector1x * vector2y) - (vecotr1y * vecotr2x);
		if (crossproduct > 0) return 1;	// point is above (left) the line
		if (crossproduct < 0) return -1;	// point is below (right) the line
		return 0;					// point is on the line		
	}
	
	/**
	 * 	Calculates the distance from the point to the line between the two given points.
	 * @param start		start point of the line
	 * @param end		end point of the line
	 * @return			distance of the this point to the given line
	 */
	public double distanceToLine(Point2D start, Point2D end) {
		Point2D a = new Point2D(start.getX(), start.getY());
		Point2D u = new Point2D(end.getX() - start.getX(), end.getY() - start.getY());

		// calculate point - start
		double pma_x = this.getX() - a.getX();
		double pma_y = this.getY() - a.getY();
		double pma_z = 0;
		
		double u_x = u.getX();
		double u_y = u.getY();
		double u_z = 0;
		
		// crossproduct between pms and end
		double cp_x = (pma_y * u_z) - (pma_z * u_y);
		double cp_y = (pma_z * u_x) - (pma_x * u_z);
		double cp_z = (pma_x * u_y) - (pma_y * u_x);
		double cp_x2 = Math.pow(cp_x, 2);
		double cp_y2 = Math.pow(cp_y, 2);
		double cp_z2 = Math.pow(cp_z, 2);
		double cp_abs = Math.sqrt(cp_x2 + cp_y2 + cp_z2);
		
		double u_abs = Math.sqrt(Math.pow(u_x, 2) + Math.pow(u_y, 2) + Math.pow(u_z, 2));
		
		if (cp_abs == 0 || u_abs == 0) return 0.0;
		double distance = cp_abs / u_abs;

		return Math.abs(distance);
	}
	

	
	/**
	 * String representation of the point
	 * @return string representation of the point
	 */
	public String toString() {
       return "["+x+","+y+"]";
    }


	@Override
	public int compareTo(Point2D point) {
		if (this.getX() < point.getX()) return -1;
		if (this.getX() > point.getX()) return 1;
		
		// if x == x..
		if (this.getY() < point.getY()) return -1;
		if (this.getY() > point.getY()) return 1;
		return 0;
	}
}
