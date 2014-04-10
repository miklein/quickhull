package de.enteryourname.hs.algolab.convexhull.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.enteryourname.hs.algolab.convexhull.Point2D;
import de.enteryourname.hs.algolab.convexhull.algorithm.QuickHullAlgorithm;
import de.enteryourname.hs.algolab.dataset.DefinedDataset;

public class QuickHullAlgorithmTest {

	private QuickHullAlgorithm algorithm;
	

	 @Before
	    public void setUp() {
		 algorithm = new QuickHullAlgorithm();
		 algorithm.useOwnStack(true);
	    }
	
	
	 
	@Test
	public void testAlgorithm() {
		
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D(1,1));
		points.add(new Point2D(2,6));
		points.add(new Point2D(3,4));
		points.add(new Point2D(9,4));
		points.add(new Point2D(7,5));
		points.add(new Point2D(7,3));
		points.add(new Point2D(6,8));
		points.add(new Point2D(6,8));
		points.add(new Point2D(1,0));
		
		ArrayList<Point2D> convexHull = new ArrayList<Point2D>();
		convexHull.add(new Point2D(1,0));
		convexHull.add(new Point2D(1,1));
		convexHull.add(new Point2D(2,6));
		convexHull.add(new Point2D(6,8));
		convexHull.add(new Point2D(9,4));
		convexHull.add(new Point2D(7,3));
		
		DefinedDataset dataset = new DefinedDataset(points);
		
		int i = 0;
		for (Point2D point : algorithm.calculate(dataset)) {
			Assert.assertEquals(convexHull.get(i).getX(), point.getX(), 0.0);
			Assert.assertEquals(convexHull.get(i).getY(), point.getY(), 0.0);
			i++;
		}
	}
	
	@Test
	public void testAlgorithmNegativePoints() {
		
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D(-2,1));
		points.add(new Point2D(3,-2));
		points.add(new Point2D(-3,4));
		points.add(new Point2D(-2,4));
		points.add(new Point2D(3,1));
		points.add(new Point2D(-4,-2));
		points.add(new Point2D(2,3));
		points.add(new Point2D(4,2));	
		points.add(new Point2D(-2,-5));
		points.add(new Point2D(-5,4));
		points.add(new Point2D(-3,-1));
		points.add(new Point2D(-4,-2));
		points.add(new Point2D(-3,-3));
		points.add(new Point2D(1,-1));
		points.add(new Point2D(2,-4));
		
		ArrayList<Point2D> convexHull = new ArrayList<Point2D>();
		convexHull.add(new Point2D(-5,4));
		convexHull.add(new Point2D(-2,4));
		convexHull.add(new Point2D(2,3));
		convexHull.add(new Point2D(4,2));
		convexHull.add(new Point2D(3,-2));
		convexHull.add(new Point2D(2,-4));
		convexHull.add(new Point2D(-2,-5));
		convexHull.add(new Point2D(-4,-2));
		
		DefinedDataset dataset = new DefinedDataset(points);
		
		int i = 0;
		for (Point2D point : algorithm.calculate(dataset)) {
			Assert.assertEquals(convexHull.get(i).getX(), point.getX(), 0.0);
			Assert.assertEquals(convexHull.get(i).getY(), point.getY(), 0.0);
			i++;
		}
	}
	

	@Test
	public void testOnlyTwoPoints() {
		
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D(6,4));
		points.add(new Point2D(6,8));
		
		List<Point2D> calculatedHull = algorithm.calculate(new DefinedDataset(points));
		
		
		Assert.assertEquals(6.0, calculatedHull.get(0).getX(), 0.0);
		Assert.assertEquals(4.0, calculatedHull.get(0).getY(), 0.0);
		
		Assert.assertEquals(6.0, calculatedHull.get(1).getX(), 0.0);
		Assert.assertEquals(8.0, calculatedHull.get(1).getY(), 0.0);
	}
	
	
	// test with recursive methods
	
	 @Test
	 public void testAlgorithmRecursive() {
		 this.algorithm.useOwnStack(false);
		 this.testAlgorithm();
	 }
	 
	 @Test
	 public void testAlgorithmNegativePointsRecursive() {
		 this.algorithm.useOwnStack(false);
		 this.testAlgorithmNegativePoints();
	 }
	 
	
}
