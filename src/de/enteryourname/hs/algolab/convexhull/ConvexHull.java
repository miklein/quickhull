package de.enteryourname.hs.algolab.convexhull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.enteryourname.hs.algolab.convexhull.Point2D;
import de.enteryourname.hs.algolab.dataset.DefinedDataset;
import de.enteryourname.hs.algolab.convexhull.algorithm.Algorithm;
import de.enteryourname.hs.algolab.convexhull.algorithm.QuickHullAlgorithm;
import de.enteryourname.hs.algolab.dataset.CircleDataset;
import de.enteryourname.hs.algolab.dataset.Dataset;
import de.enteryourname.hs.algolab.dataset.FlippedRectangleDataset;
import de.enteryourname.hs.algolab.dataset.InnerRectangleDataset;
import de.enteryourname.hs.algolab.dataset.RandomDataset;
import de.enteryourname.hs.algolab.dataset.RectangleDataset;
import de.enteryourname.hs.algolab.dataset.TestDataset;
import de.enteryourname.hs.algolab.dataset.WorstCaseDataset;

/**
 * 
 * @author Tobias Keller
 *
 */
public class ConvexHull {

	public static void main(String[] args) {
		
		// run benchmark
		//Benchmark benchmark = new Benchmark();
		QuickHullAlgorithm algo = new QuickHullAlgorithm();	
		algo.useOwnStack(true);
		
//		ArrayList<Point2D> points = new ArrayList<Point2D>();
//		points.add(new Point2D(1,1));
//		points.add(new Point2D(2,6));
//		points.add(new Point2D(3,4));
//		points.add(new Point2D(5,1));
//		points.add(new Point2D(9,4));
//		points.add(new Point2D(7,5));
//		points.add(new Point2D(7,3));
//		points.add(new Point2D(6,8));
//		
		
		
		Dataset dataset = new CircleDataset(50);
		List<Point2D> result = algo.calculate(dataset);
		
		Export plot = new Export("/home/michi/pplot.dat");
		//Export plot = new Export("d:\\pplot.dat");
		plot.addDataset(dataset);
		plot.addHull(result);
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
//		
		
		/**
		 * Run some Benchmarks..
		 */
		
		int rounds = 12;
		int initialAmount = 500;
		int meanRounds = 5;
		
//		Benchmark benchmark = new Benchmark(true);
//
//		algo.useOwnStack(true);
//		//benchmark.setPrefix("stack");
//		// do one benchmark for initialization
//		benchmark.runtimeBenchmark(algo, new FlippedRectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new FlippedRectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new CircleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new RandomDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new RectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new WorstCaseDataset(1), rounds, initialAmount, meanRounds);
		
//		algo.useOwnStack(false);
//		//benchmark.setPrefix("recursive");
//		// do one benchmark for initialization
//		benchmark.runtimeBenchmark(algo, new FlippedRectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new FlippedRectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new CircleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new RandomDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new RectangleDataset(1), rounds, initialAmount, meanRounds);
//		benchmark.runtimeBenchmark(algo, new WorstCaseDataset(1), rounds, initialAmount, meanRounds);
		
		
		
		 
//		Dataset dataset = new CircleDataset(50);
//		ChanAlgorithm algo = new ChanAlgorithm();
//		System.out.println(algo.createSubsets(dataset.getPoints(), 2));
//		
		
//		 Dataset dataset = new CircleDataset(50);
//		 List<Point> result = algo.calculate(dataset.getPoints());
//		
//		 Export plot = new Export("D:\\pplot.dat");
//		 plot.addBenchmark(amount, runtime);
//		 plot.addHull(result);
//		 plot.store();
		
	}
	
}
