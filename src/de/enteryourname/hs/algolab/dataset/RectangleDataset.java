package de.enteryourname.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.enteryourname.hs.algolab.convexhull.Point2D;

/**
 * Testdataset in which all Points are inside of a rectangle and also on its edges
 * @author Tobias Keller
 *
 */
public class RectangleDataset implements Dataset {

	private List<Point2D> points = new ArrayList<Point2D>();
	
	public RectangleDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	public String toString() {
		return "rectangle";
	}
	
	@Override
	public List<Point2D> getPoints() {
		return this.points;
	}

	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		Point2D topLeft = new Point2D(0,(int)Math.sqrt(amount)*2);
		Point2D bottomRight = new Point2D((int)Math.sqrt(amount)*2,0);
		
		Random random = new Random(System.nanoTime());
		
		for (int i=0; i < amount; i++) {
			int x = (int)(Math.random() * ((bottomRight.getX()+1 - topLeft.getX())) + topLeft.getX());
			int y = (int) (Math.random() * ((topLeft.getY()+1 - bottomRight.getY())) + bottomRight.getY());
						
			if (x > bottomRight.getX()) x = (int)bottomRight.getX();
			if (y > topLeft.getY()) y = (int)topLeft.getY();
			
			this.points.add(new Point2D((double)x,(double)y));
		}
		
		// add the corner-points
		this.points.add(topLeft);
		this.points.add(bottomRight);
		this.points.add(new Point2D(bottomRight.getX(), topLeft.getY()));
		this.points.add(new Point2D(topLeft.getX(), bottomRight.getY()));
	}

}
