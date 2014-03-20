package src.de.enteryourname.hs.algolab.convexhull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.QuickHullAlgorithm;
import de.kellertobias.hs.algolab.dataset.CircleDataset;
import de.kellertobias.hs.algolab.dataset.Dataset;
import de.kellertobias.hs.algolab.dataset.InnerRectangleDataset;
import de.kellertobias.hs.algolab.dataset.RandomDataset;
import de.kellertobias.hs.algolab.dataset.RectangleDataset;
import de.kellertobias.hs.algolab.dataset.TestDataset;

/**
 * 
 * @author Tobias Keller
 *
 */
public class ConvexHull {

	public static void main(String[] args) {
		
		// run benchmark
		//Benchmark benchmark = new Benchmark();
		Algorithm algo = new QuickHullAlgorithm();
		
		Dataset dataset = new RectangleDataset(100);
		List<Point2D> result = algo.calculate(dataset);
		
		
//		Export plot = new Export("D:\\pplot.dat");
//		plot.addDataset(dataset);
//		plot.addHull(result);
//		plot.store();
		
		//
			

//		
//		Point2D point = new Point2D(4,4);
//		Point2D start = new Point2D(2,2);
//		Point2D end = new Point2D(6,2);
//		
//		System.out.println(point.distanceToLine(start, end));
//		
//		
		
		int rounds = 12;
		Benchmark benchmark = new Benchmark();
		//benchmark.runtimeBenchmark(algo, new CircleDataset(1), rounds, 500);
		//benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1), rounds, 500);
		//benchmark.runtimeBenchmark(algo, new RectangleDataset(1), rounds, 500);
		benchmark.runtimeBenchmark(algo, new RandomDataset(1), rounds, 500);
		
		 
//		Dataset dataset = new CircleDataset(50);
//		ChanAlgorithm algo = new ChanAlgorithm();
//		System.out.println(algo.createSubsets(dataset.getPoints(), 2));
//		
		
//		Dataset dataset = new CircleDataset(50);
//		List<Point> result = algo.calculate(dataset.getPoints());
//	
//		Export plot = new Export("D:\\pplot.dat");
//		plot.addBenchmark(amount, runtime);
//		plot.addHull(result);
//		plot.store();
		
	}
	
}
