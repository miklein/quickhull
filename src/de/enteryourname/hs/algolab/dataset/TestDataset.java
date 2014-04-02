package de.enteryourname.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;

import de.enteryourname.hs.algolab.convexhull.Point2D;

/**
 * Just a Testdataset that was used while implementing the algorithms
 * @author Tobias Keller
 *
 */
public class TestDataset implements Dataset {

	@Override
	public List<Point2D> getPoints() {
		
		List<Point2D> points = new ArrayList<>();


		points.add(new Point2D(1,1));
		points.add(new Point2D(2,6));
		points.add(new Point2D(3,4));
		points.add(new Point2D(9,4));
		points.add(new Point2D(7,5));
		points.add(new Point2D(7,3));
		points.add(new Point2D(6,8));
		points.add(new Point2D(6,8));
		points.add(new Point2D(1,0));
		
		
		
//		pointList.add(new Point2D(0,0));
//		pointList.add(new Point2D(0,1));
//		pointList.add(new Point2D(5,0));
//		pointList.add(new Point2D(1.5,1.5));
//		pointList.add(new Point2D(1,1.5));
//		pointList.add(new Point2D(3,3));
//		pointList.add(new Point2D(2,2.5));
//		pointList.add(new Point2D(1,2));
//		pointList.add(new Point2D(0.5,1.75));
//		
//
//		pointList.add(new Point2D(3,-3));
//		pointList.add(new Point2D(3,-2));
//		pointList.add(new Point2D(1.5,-1.5));
//		pointList.add(new Point2D(4.5,2));
//		pointList.add(new Point2D(4.5,-2.5));
//		pointList.add(new Point2D(3,-4.5));
//		pointList.add(new Point2D(1,-3.5));
//		pointList.add(new Point2D(0.25,-1.5));
		
		
//		pointList.add(new Point2D(1,1));
//		pointList.add(new Point2D(2,6));
//		pointList.add(new Point2D(3,4));
//		pointList.add(new Point2D(9,4));
//		pointList.add(new Point2D(7,5));
//		pointList.add(new Point2D(7,3));
//		pointList.add(new Point2D(6,8));
//		pointList.add(new Point2D(6,8));
		
		
//		pointList.add(new Point(1,1));
//		pointList.add(new Point(2,6));
//		pointList.add(new Point(3,4));
//		pointList.add(new Point(6,8));
//		pointList.add(new Point(7,1.5));
				
		return points;
	}
	

	public String toString() {
		return "test";
	}


	@Override
	public void regeneratePoints(int amount) {
		// TODO Auto-generated method stub
		
	}
}
