package de.enteryourname.hs.algolab.convexhull;

/**
 * Timer
 * @author Tobias Keller
 *
 */
public class Timer {
	
	private long startTime = 0;
	private long runTime = 0;
	
	/**
	 * reset the timer
	 */
	public void reset() {
		this.startTime = 0;
		this.runTime = 0;
	}
	
	/**
	 * start the timer
	 */
	public void start() {
		this.reset();
		this.startTime = System.nanoTime();
	}

	/**
	 * stop the timer
	 */
	public void stop() {
		this.runTime = System.nanoTime() - this.startTime;
	}
	
	/**
	 * get the runtime
	 * @return runtime
	 */
	public long getRuntime() {
		return this.runTime;
	}
	
	
}
