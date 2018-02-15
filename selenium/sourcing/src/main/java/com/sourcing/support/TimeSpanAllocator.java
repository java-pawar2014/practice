package com.sourcing.support;

/**
 * Methods of this class stops the execution of invoking {@link Thread} for a
 * given time.
 * 
 * @author bpawar
 *
 */
public class TimeSpanAllocator {

	/**
	 * Puts current execution {@link Thread} to sleep state for <i>mills<i> time in
	 * milliseconds.
	 * 
	 * @param milis
	 *            sleeping time in milliseconds
	 */
	public static void waitTime(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException cause) {
			cause.printStackTrace();
		}

	}
}
