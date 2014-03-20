package de.enteryourname.hs.algolab.convexhull.test;

import org.junit.Assert;
import org.junit.Test;

import de.enteryourname.hs.algolab.dataset.RectangleDataset;

public class RectangleDatasetTest {

	@Test
	public void testAll() {
		RectangleDataset rectangleDataset = new RectangleDataset(21);
		Assert.assertEquals(21 + 4, rectangleDataset.getPoints().size());			// 4 corner points
		
		Assert.assertEquals("rectangle", rectangleDataset.toString());
		
	
	}

}
