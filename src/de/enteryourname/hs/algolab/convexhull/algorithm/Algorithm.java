package de.enteryourname.hs.algolab.convexhull.algorithm;


import java.util.List;

import de.enteryourname.hs.algolab.convexhull.Point2D;
import de.enteryourname.hs.algolab.dataset.Dataset;

/**
 * All Algorithms that implement an Convex-Hull Solution implement this class
 * @author Tobias Keller
 *
 */
public interface Algorithm {
	
	/**
	 * Calculates the convex-hull of all Points in the dataset
	 * @param dataset List of all Points
	 * @return Points of the convex-hull
	 */
	 public List<Point2D> calculate(Dataset dataset);
	
}
