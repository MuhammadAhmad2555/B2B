package com.ark_i.b2b.Models;

public class NotificationAmModel {
    String JobId,JobStatus,JobDescription;

    public NotificationAmModel(String jobId, String jobStatus, String jobDescription) {
        JobId = jobId;
        JobStatus = jobStatus;
        JobDescription = jobDescription;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getJobStatus() {
        return JobStatus;
    }

    public void setJobStatus(String jobStatus) {
        JobStatus = jobStatus;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }
}
