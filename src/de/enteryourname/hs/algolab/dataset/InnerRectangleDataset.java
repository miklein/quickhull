package src.de.enteryourname.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.kellertobias.hs.algolab.convexhull.Point2D;

/**
 * Testdataset in which all Points are inside of a rectangle but NOT on its edges
 * @author Tobias Keller
 *
 */
public class InnerRectangleDataset implements Dataset {

	private List<Point2D> points = new ArrayList<Point2D>();
	
	public InnerRectangleDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	
	public String toString() {
		return "rectangle-inner";
	}
	
	@Override
	public List<Point2D> getPoints() {
		return this.points;
	}


	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		
		Point2D topLeft = new Point2D(0,10);
		Point2D bottomRight = new Point2D(10,0);
		
		Random random = new Random(System.nanoTime());
		
		for (int i=0; i < amount; i++) {
			double x = 0;
			double y = 0;
			do {
				x = random.nextDouble() * ((bottomRight.getX() - topLeft.getX())) + topLeft.getX();
				y = random.nextDouble() * ((topLeft.getY() - bottomRight.getY())) + bottomRight.getY();
			} while(x > bottomRight.getX() &&
					x < topLeft.getX() &&
					y > topLeft.getY() &&
					y < bottomRight.getY());
			
			this.points.add(new Point2D(x,y));
		}
		
		// do NOT add the corner-points
//		this.points.add(topLeft);
//		this.points.add(bottomRight);
//		this.points.add(new Point(bottomRight.getX(), topLeft.getY()));
//		this.points.add(new Point(topLeft.getX(), bottomRight.getY()));
	}

}
