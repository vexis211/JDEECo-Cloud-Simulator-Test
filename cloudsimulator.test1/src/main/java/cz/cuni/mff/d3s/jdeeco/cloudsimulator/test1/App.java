package cz.cuni.mff.d3s.jdeeco.cloudsimulator.test1;

import cz.cuni.mff.d3s.jdeeco.cloudsimulator.simulation.startup.LogInitializer;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.simulation.startup.SimulationBase;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) throws Exception
    {
		LogInitializer.initialize();

		SimulationBase simulation = new HelloWorldSimulation();
		simulation.start();
    }
}
