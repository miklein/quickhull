package de.enteryourname.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.enteryourname.hs.algolab.convexhull.Point2D;

/**
 * Testdataset where all Points are defined on a circle
 * @author Tobias Keller
 *
 */
public class WorstCaseDataset implements Dataset {

	private List<Point2D> points = new ArrayList<Point2D>();
	
	public WorstCaseDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	
	public String toString() {
		return "worst_case";
	}
	
	@Override
	public List<Point2D> getPoints() {
		return this.points;
	}


	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		double radius = 10;		
		double currentAngle = 90;
		double xOffset = radius / 2;
		
		//add initial point
		this.points.add(new Point2D(-xOffset,0));
		
		for (int i=0; i < amount; i++) {
			
			double y = Math.sin(currentAngle * Math.PI/180.0) * radius;
			double x = (Math.cos(currentAngle * Math.PI/180.0) * radius);
			
			currentAngle/= 2;
			x+= xOffset;
			this.points.add(new Point2D(x,y));
		}
	}

}
