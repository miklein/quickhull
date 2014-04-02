package de.enteryourname.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.kellertobias.hs.algolab.convexhull.Point2D;

/**
 * Testdataset in which all Points are inside of a rectangle but NOT on its edges
 * @author Tobias Keller
 *
 */
public class FlippedRectangleDataset implements Dataset {

	private List<Point2D> points = new ArrayList<Point2D>();
	
	public FlippedRectangleDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	
	public String toString() {
		return "rectangle-flipped";
	}
	
	@Override
	public List<Point2D> getPoints() {
		return this.points;
	}


	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		
		Point2D topLeft = new Point2D(0,10);
		Point2D bottomRight = new Point2D(10,0);
		
		
		Random random = new Random(System.nanoTime());
		
		for (int i=0; i < amount; i++) {
			double x = 0;
			double y = 0;
			do {
				x = random.nextDouble() * ((bottomRight.getX() - topLeft.getX())) + topLeft.getX();
				y = random.nextDouble() * ((topLeft.getY() - bottomRight.getY())) + bottomRight.getY();
			} while(x > bottomRight.getX() &&
					x < topLeft.getX() &&
					y > topLeft.getY() &&
					y < bottomRight.getY());
			
			this.points.add(new Point2D(x,y));
		}
		

		this.points.add(new Point2D(5,5));
		// add the corner-points
		this.points.add(topLeft);
		this.points.add(bottomRight);
		this.points.add(new Point2D(bottomRight.getX(), topLeft.getY()));
		this.points.add(new Point2D(topLeft.getX(), bottomRight.getY()));
		
		// rotate around center
		Point2D center = new Point2D(5,5);
		float angle = 90;
		for (Point2D point : this.points) {
			double x = center.getX() + (point.getX() - center.getX()) * Math.cos(angle) - (point.getY() - center.getY()) * Math.sin(angle);
			double y = center.getY() + (point.getX() - center.getX()) * Math.sin(angle) - (point.getY() - center.getY()) * Math.cos(angle);
			point.setX(x);
			point.setY(y);
		}


		
	}

}
