package cz.cuni.mff.d3s.jdeeco.cloudsimulator.test1;

import cz.cuni.mff.d3s.deeco.annotations.Component;
import cz.cuni.mff.d3s.deeco.annotations.In;
import cz.cuni.mff.d3s.deeco.annotations.InOut;
import cz.cuni.mff.d3s.deeco.annotations.PeriodicScheduling;
import cz.cuni.mff.d3s.deeco.annotations.Process;
import cz.cuni.mff.d3s.deeco.task.ParamHolder;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.statistics.Statistics;

@Component
public class HelloWorld {

	/**
	 * Id of the vehicle component.
	 */
	public String id;

	/**
	 * Output of count process
	 */
	public Integer counter;

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
//		Statistics.Write("hello");
//		Assert.assertEquals("For testing", id, "HELLO");

//		Timer.stop("sayHello");
	}

	/**
	 * Periodically increments the counter.
	 */
	@Process
	@PeriodicScheduling(period = 500)
	public static void updateCounter(@InOut("counter") ParamHolder<Integer> counter) {
		Statistics.Write("counter", 1);
		counter.value++;
		System.out.println("... counter incremented to " + counter.value);
	}
}
