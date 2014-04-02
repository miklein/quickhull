package de.enteryourname.hs.algolab.convexhull;

import de.enteryourname.hs.algolab.convexhull.algorithm.Algorithm;
import de.enteryourname.hs.algolab.convexhull.algorithm.QuickHullAlgorithm;
import de.enteryourname.hs.algolab.dataset.Dataset;
import de.enteryourname.hs.algolab.dataset.RectangleDataset;
import de.enteryourname.hs.algolab.dataset.TestDataset;

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
	//	Dataset dataset = new WorstCaseDataset(45);
		
//		ArrayList<Point2D> points = new ArrayList<Point2D>();
//		points.add(new Point2D(1,1));
//		points.add(new Point2D(2,6));
//		points.add(new Point2D(3,4));
//		points.add(new Point2D(9,4));
//		points.add(new Point2D(7,5));
//		points.add(new Point2D(7,3));
//		points.add(new Point2D(6,8));
//		
//		DefinedDataset dataset = new DefinedDataset(points);
//		
//		
//		List<Point2D> result = algo.calculate(dataset);
//		
//		
//		System.out.println(result);
//		
		
		Dataset dataset = new TestDataset();
		
		
		Export plot = new Export("/home/michi/pplot.dat");
		plot.addDataset(dataset);
		plot.addHull(algo.calculate(dataset));
		plot.store();
		
		//
			

//		
//		Point2D point = new Point2D(4,4);
//		Point2D start = new Point2D(2,2);
//		Point2D end = new Point2D(6,2);
//		
//		System.out.println(point.distanceToLine(start, end));
//		
//		
		
		int rounds = 20;
		int initialAmount = 500;
		int meanRounds = 10;
		
		Benchmark benchmark = new Benchmark(false);
		//benchmark.runtimeBenchmark(algo, new RandomDataset(1), rounds, initialAmount, meanRounds);
		//benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1), rounds, initialAmount, meanRounds);
		//benchmark.runtimeBenchmark(algo, new RectangleDataset(1), rounds, initialAmount, meanRounds);
		//benchmark.runtimeBenchmark(algo, new WorstCaseDataset(1), rounds, initialAmount, meanRounds);
//		
		 
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
