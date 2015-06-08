package cz.cuni.mff.d3s.jdeeco.cloudsimulator.test1;

import cz.cuni.mff.d3s.jdeeco.cloudsimulator.simulation.startup.SimulationBootstrapper;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.simulation.startup.SimulationBootstrapperImpl;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.simulation.startup.SimulationStartParameters;
import cz.cuni.mff.d3s.jdeeco.cloudsimulator.simulation.startup.SimulationStartParametersImpl;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) throws Exception
    {
    	SimulationBootstrapper bootstrapper = new SimulationBootstrapperImpl();
    	bootstrapper.initializeLogging();
    	
    	// TODO replace with your component
		Object rootComponent = new HelloWorld("HELLO");
		
		SimulationStartParameters startParameters = new SimulationStartParametersImpl(rootComponent);
		bootstrapper.startSimulation(startParameters);
		
		bootstrapper.dispose();
    }
}
