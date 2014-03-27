package de.enteryourname.hs.algolab.convexhull;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.dataset.Dataset;

/**
 * Class for testing the Runtime of given Algorithms
 * @author Tobias Keller
 *
 */
public class Benchmark {
	
	private boolean verbose;
	
	public Benchmark(boolean verbose) {
		this.verbose = verbose;
	}
	
	/**
	 * Runs a benchmark for a given algorithm based on the dataset
	 * the tests will be performed <loop> times with a given <amount> of points
	 * in each loop the amount of points will be doubled.
	 * The results will be stored on the filesystem.
	 *  
	 * @param algo The algorithm, used for the benchmark
	 * @param dataset The dataset, that will be generating the points
	 * @param loops The times the benchmark will be runned
	 * @param amount The initial amount of Points that will be used
	 */
	public void runtimeBenchmark(Algorithm algo, Dataset dataset, int loops, int amount, int meanRounds) {
		
		Timer timer = new Timer();
		Export output = new Export("D:\\"+dataset.toString()+".benchmark.csv");
		
		System.out.println("running benchmark for "+dataset.toString());
		
		int n = amount;
		for (int i=0; i < loops; i++) {
			
			long totalTime = 0;
			for (int j=0; j < meanRounds; j++) {
				if (this.verbose) System.out.println("benchmark loop "+(i+1)+"/"+loops+" points="+n+" round "+(j+1)+"/"+meanRounds);
				if (this.verbose) System.out.print("running..");
				dataset.regeneratePoints(n);
				timer.start();
				algo.calculate(dataset);
				timer.stop();
				totalTime+= timer.getRuntime();
				
				double tmp = (double)(timer.getRuntime() * 0.000001);
				tmp = Math.round(tmp * Math.pow(10, 3)) / Math.pow(10, 3);
				if (this.verbose) System.out.println("finished after: "+tmp+"ms");
			}
			long avgTime = totalTime / (long)meanRounds;
			output.addBenchmark(n, avgTime);
			
			double tmp = (double)(avgTime * 0.000001);
			tmp = Math.round(tmp * Math.pow(10, 3)) / Math.pow(10, 3);
			System.out.println("average time for "+n+" points: "+tmp+"ms");
			n*=2;
			
//			System.out.println("round="+i+" n="+amount);
//			dataset.regeneratePoints(n);
//			timer.start();
//			algo.calculate(dataset);
//			timer.stop();
//			output.addBenchmark(n, timer.getRuntime());
//			
//			double tmp = (double)(timer.getRuntime() * 0.000001);
//			tmp = Math.round(tmp * Math.pow(10, 3)) / Math.pow(10, 3);
//			System.out.println("n=: "+n+" time="+((double)tmp)+"ms");
//			n*= 2;
			
		}
		output.store();
	}
	
}
