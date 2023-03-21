package com.project.issuetracker;

public class IssueClass {
    int id;
    String desc;
    String project;
    String time;
    String assignee;
    String reporter;
    String status;
    public int getId() {
        return id;
    }
    public String getAssignee() {
        return assignee;
    }
    public String getDesc() {
        return desc;
    }
    public String getProject() {
        return project;
    }
    public String getReporter() {
        return reporter;
    }
    public String getStatus() {
        return status;
    }
    public String getTime() {
        return time;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
