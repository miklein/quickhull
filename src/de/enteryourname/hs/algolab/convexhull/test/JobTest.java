package de.enteryourname.hs.algolab.convexhull.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import de.enteryourname.hs.algolab.convexhull.Job;
import de.enteryourname.hs.algolab.convexhull.Point2D;

public class JobTest {

	
	@Test
	public void testJob() {
		
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D(1,1));
		points.add(new Point2D(2,6));
		points.add(new Point2D(3,4));
		points.add(new Point2D(9,4));
		
		Point2D lineStart = new Point2D(2,7);
		Point2D lineEnd = new Point2D(3,6);
		
		Job job = new Job(points, lineStart, lineEnd);
		
		int i = 0;
		for (Point2D point : job.getPoints()) {
			Assert.assertEquals(points.get(i).getX(), point.getX(), 0.0);
			Assert.assertEquals(points.get(i).getY(), point.getY(), 0.0);
			i++;
		}
		
		Assert.assertEquals(lineStart.getX(), job.getLineStart().getX(), 0.0);
		Assert.assertEquals(lineStart.getY(), job.getLineStart().getY(), 0.0);

		Assert.assertEquals(lineEnd.getX(), job.getLineEnd().getX(), 0.0);
		Assert.assertEquals(lineEnd.getY(), job.getLineEnd().getY(), 0.0);
	}
		
	
}
