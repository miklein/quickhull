package src.de.enteryourname.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.kellertobias.hs.algolab.convexhull.Point2D;

/**
 * Testdataset that calculates random points
 * @author Tobias Keller
 *
 */
public class RandomDataset implements Dataset {

	private List<Point2D> points = new ArrayList<Point2D>();
	
	
	public RandomDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	public String toString() {
		return "random";
	}
	
	@Override
	public List<Point2D> getPoints() {
		return this.points;
	}

	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		Random random = new Random(System.nanoTime());
		for (int i=0; i < amount; i++) {
			this.points.add(new Point2D(random.nextDouble(), random.nextDouble()));
		}
	}

}
