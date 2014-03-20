package de.enteryourname.hs.algolab.convexhull.test;

import org.junit.Assert;
import org.junit.Test;

import de.enteryourname.hs.algolab.dataset.InnerRectangleDataset;

public class InnerRectangleDatasetTest {


	@Test
	public void testAll() {
		InnerRectangleDataset innerRectangleDataset = new InnerRectangleDataset(15);
		Assert.assertEquals(15, innerRectangleDataset.getPoints().size());			// 4 corner points
		
		Assert.assertEquals("rectangle-inner", innerRectangleDataset.toString());
		
	
	}

}
