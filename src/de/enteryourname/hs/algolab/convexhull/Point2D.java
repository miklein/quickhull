package de.enteryourname.hs.algolab.convexhull;

/**
 * Class for representation of a point in an 2D-System
 * @author Tobias Keller
 *
 */
public class Point2D implements Comparable<Point2D> {
	
	private double x;
	private double y;
	
	/** 
	 * create a new Point at position x,y
	 * @param x
	 * @param y
	 */
	public Point2D(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * get the x-value of the point
	 * @return
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * get the y-value of the point
	 * @return
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * set the x-value of the point
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * set the y-value of the point
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * check if this point is above the line between the points, defined by the params
	 * returns 1 if the point is above the line, -1 if it is below and 0 if it is on the line
	 * @param start Startpoint of the line
	 * @param end Endpoint of the line
	 * @return
	 */
	public int isAboveLine(Point2D start, Point2D end) {
		
		// System.out.println("Pr�fe ob "+this+" �ber Linie ("+start+" -> "+end+")");
		
		// vector from start to end
		double v1x = end.getX() - start.getX();
		double v1y = end.getY() - start.getY();
		
		// vector from start to this point
		double v2x = this.getX() - start.getX();
		double v2y = this.getY() - start.getY();
		
		// crossproduct
		double cp = (v1x * v2y) - (v1y * v2x);
		if (cp > 0) return 1;	// point is above (left) the line
		if (cp < 0) return -1;	// point is below (right) the line
		return 0;					// point is on the line		
	}
	
	
	
	public double getAbsValue() {
		return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
	}
	
	
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
	 * returns the x and y-value as a string
	 */
	public String toString() {
       return "["+x+","+y+"]";
		// return getClass().getName() + "[x=" + x + ",y=" + y + "]";
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
