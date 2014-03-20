package de.enteryourname.hs.algolab.convexhull.test;



import org.junit.Assert;
import org.junit.Test;

import de.enteryourname.hs.algolab.dataset.CircleDataset;

public class CircleDatasetTest {

	@Test
	public void testAll() {
		CircleDataset circleData = new CircleDataset(10);
		Assert.assertEquals(10, circleData.getPoints().size());
		
		Assert.assertEquals("circle", circleData.toString());
		
	}

}
