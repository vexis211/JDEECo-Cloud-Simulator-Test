package cz.cuni.mff.d3s.jdeeco.cloudsimulator.test1;

import cz.cuni.mff.d3s.deeco.annotations.Component;
import cz.cuni.mff.d3s.deeco.annotations.In;
import cz.cuni.mff.d3s.deeco.annotations.InOut;
import cz.cuni.mff.d3s.deeco.annotations.PeriodicScheduling;
import cz.cuni.mff.d3s.deeco.annotations.Process;
import cz.cuni.mff.d3s.deeco.task.ParamHolder;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.asserts.Assert;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.statistics.Statistics;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.timers.Timer;

@Component
public class HelloWorld {

	/**
	 * Id of the vehicle component.
	 */
	public String id;

	/**
	 * Output of count process
	 */
	public int counter;

	public HelloWorld(String id) {
		this.id = id;
		this.counter = 1;
	}

	/**
	 * Periodically prints "Hello world!"
	 */
	@Process
	@PeriodicScheduling(period = 1000)
	public static void sayHello(@In("id") String id) {
//		Timer.start("sayHello");
//		
		System.out.println("Hello world!");
//		
//		Statistics.Write("sayHello");
//		Assert.assertEquals("For testing", id, "HELLO");

//		Timer.stop("sayHello");
	}

	/**
	 * Periodically increments the counter.
	 */
	@Process
	@PeriodicScheduling(period = 500)
	public static void updateCounter(@InOut("counter") ParamHolder<Integer> counter) {
		counter.value++;
		System.out.println("... counter incremented to " + counter.value);
	}
}
