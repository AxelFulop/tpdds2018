package server;

import jobs.SensorJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import spark.Spark;
import spark.debug.DebugScreen;

	public class Server {
		public static void main(String[] args) {
			Bootstrap.main(null);
			Spark.port(getHerokuAssignedPort());
			DebugScreen.enableDebugScreen();
			Router.configure();

			try {
				// specify the job' s details..
				JobDetail job = JobBuilder.newJob(SensorJob.class)
						.withIdentity("sensorJob")
						.build();
				 //specify the running period of the job
				Trigger trigger = TriggerBuilder.newTrigger()
						.withSchedule(SimpleScheduleBuilder.simpleSchedule()
										.withIntervalInSeconds(30)
										.repeatForever())
						.build();

				SchedulerFactory schFactory = new StdSchedulerFactory();
				Scheduler sch = schFactory.getScheduler();
				sch.start();
				sch.scheduleJob(job, trigger);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
	}
		
		static int getHerokuAssignedPort() {
			ProcessBuilder processBuilder = new ProcessBuilder();
			if (processBuilder.environment().get("PORT") != null) {
				return Integer.parseInt(processBuilder.environment().get("PORT"));
			}
			return 8080;
		}

	
}
