package com.project.issuetracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String issue_description;
    private int issue_project;
    private String issue_created;
    private int issue_assignee;
    private int issue_reporter;
    private String issue_status;
    public Issue(int id,String issued,int ip,String ic,int ia,int ir,String is){
        this.id=id;
        this.issue_assignee=ia;
        this.issue_created=ic;
        this.issue_description=issued;
        this.issue_reporter=ir;
        this.issue_project=ip;
        this.issue_status=is;
    }
    public Issue(){
        super();
    }
    public int getId() {
        return id;
    }
    public int getIssue_assignee() {
        return issue_assignee;
    }
    public String getIssue_created() {
        return issue_created;
    }
    public String getIssue_description() {
        return issue_description;
    }
    public int getIssue_project() {
        return issue_project;
    }
    public int getIssue_reporter() {
        return issue_reporter;
    }
    public String getIssue_status() {
        return issue_status;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIssue_assignee(int issue_assignee) {
        this.issue_assignee = issue_assignee;
    }
    public void setIssue_created(String issue_created) {
        this.issue_created = issue_created;
    }
    public void setIssue_description(String issue_description) {
        this.issue_description = issue_description;
    }
    public void setIssue_project(int issue_project) {
        this.issue_project = issue_project;
    }
    public void setIssue_reporter(int issue_reporter) {
        this.issue_reporter = issue_reporter;
    }
    public void setIssue_status(String issue_status) {
        this.issue_status = issue_status;
    }
}
