package com.danone.bonafont.batch.launcher;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Eduardo Rodriguez
 * Job Launcher
 *
 */
public class JobLauncherDetails extends QuartzJobBean {

	private static final Logger LOG = Logger.getLogger(JobLauncherDetails.class);

	static final String JOB_NAME = "jobName" ;
	
	static final String PATH_BASE_OUT = "D:/interface_sap-qs3/data/out/new/" ;

	private JobLocator jobLocator;

	private JobLauncher jobLauncher;

	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	@SuppressWarnings("unchecked")
	protected void executeInternal(JobExecutionContext context) {

		Map<String, Object> jobDataMap = context.getMergedJobDataMap();

		String jobName = (String) jobDataMap.get(JOB_NAME);

		JobParameters jobParameters = getJobParametersFromJobMap(jobDataMap);
		
		try {
			jobLauncher.run(jobLocator.getJob(jobName), jobParameters);
		} catch (JobExecutionException e) {
			LOG.error(e.getMessage(), e);
		} catch (CannotGetJdbcConnectionException e){
			LOG.error(e.getMessage(), e);
		} catch (Exception e){
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	//get params from jobDataAsMap property, quartz-context.xml
	private JobParameters getJobParametersFromJobMap(Map<String, Object> jobDataMap) {

		JobParametersBuilder builder = new JobParametersBuilder();

		for (Entry<String, Object> entry : jobDataMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof String && !key.equals(JOB_NAME)) {
				 builder.addString(key, (String) value);
			} else if (value instanceof Float || value instanceof Double) {
				builder.addDouble(key, ((Number) value).doubleValue());
			} else if (value instanceof Integer || value instanceof Long) {
				builder.addLong(key, ((Number) value).longValue());
			} else if (value instanceof Date) {
				builder.addDate(key, (Date) value);
			}
		}
		
		builder.addString("pathout", PATH_BASE_OUT);
		builder.addDate("run date", new Date());
		
		return builder.toJobParameters();
	}

}
