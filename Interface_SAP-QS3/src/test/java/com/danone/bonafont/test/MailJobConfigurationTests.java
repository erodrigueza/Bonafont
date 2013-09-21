package com.danone.bonafont.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "/test-context.xml", "/META-INF/spring/mail-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MailJobConfigurationTests {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void launchJob() throws Exception {

		JobExecution jobExecution;

		// testing a job
		jobExecution = jobLauncherTestUtils.launchJob();

		// Testing a individual step
//		jobExecution = jobLauncherTestUtils.launchStep("sendMailStep");

		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

	}
}
