package com.capella.flickr.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class FlickrDownloadLauncher {

  private JobLauncher jobLauncher;

  private Job job;

  public void launch() {
    JobParameters jobParameters = new JobParametersBuilder().addLong("time",
        System.currentTimeMillis()).toJobParameters();
    try {
      JobExecution execution = jobLauncher.run(job, jobParameters);
      System.out.println("Exit Status : " + execution.getStatus());
    } catch (Exception e) {
      System.out.println("Unable to execute job");
      e.printStackTrace();
    }
  }

  public JobLauncher getJobLauncher() {
    return jobLauncher;
  }

  public void setJobLauncher(JobLauncher jobLauncher) {
    this.jobLauncher = jobLauncher;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }
}