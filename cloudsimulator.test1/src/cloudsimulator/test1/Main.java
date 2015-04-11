package cloudsimulator.test1;

import java.io.IOException;

import cz.cuni.mff.d3s.deeco.annotations.processor.AnnotationProcessor;
import cz.cuni.mff.d3s.deeco.annotations.processor.AnnotationProcessorException;
import cz.cuni.mff.d3s.deeco.model.runtime.api.RuntimeMetadata;
import cz.cuni.mff.d3s.deeco.model.runtime.custom.RuntimeMetadataFactoryExt;
import cz.cuni.mff.d3s.deeco.runtime.RuntimeConfiguration;
import cz.cuni.mff.d3s.deeco.runtime.RuntimeConfiguration.Distribution;
import cz.cuni.mff.d3s.deeco.runtime.RuntimeConfiguration.Execution;
import cz.cuni.mff.d3s.deeco.runtime.RuntimeConfiguration.Scheduling;
import cz.cuni.mff.d3s.deeco.runtime.RuntimeFramework;
import cz.cuni.mff.d3s.deeco.runtime.RuntimeFrameworkBuilder;

public class Main {

	public static void main(String[] args) throws AnnotationProcessorException,
			IOException, InterruptedException {
		AnnotationProcessor processor = new AnnotationProcessor(
				RuntimeMetadataFactoryExt.eINSTANCE);
		RuntimeMetadata model = RuntimeMetadataFactoryExt.eINSTANCE
				.createRuntimeMetadata();

		processor.process(model, new HelloWorld("HELLO"));

		RuntimeFrameworkBuilder builder = new RuntimeFrameworkBuilder(
				new RuntimeConfiguration(Scheduling.WALL_TIME,
						Distribution.LOCAL, Execution.SINGLE_THREADED));
		RuntimeFramework runtime = builder.build(model);
		runtime.start();
	}
}
