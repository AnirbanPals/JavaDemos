package org.anirban.java8.demo.schedule;

@Schedule(dayOfMonth="last")
@Schedule(dayOfWeek="Fri", hour=23)	
public class PeriodicJob implements Runnable {
	public void run() {
		// some work to do
	}
}