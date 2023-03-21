package com.project.issuetracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IssueLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int issue_changes;
    private String issue_time;
    private String issue_old;
    private String issue_new;
    public IssueLog(int id,int ic,String it,String io,String in){
        this.id=id;
        issue_changes=ic;
        issue_new=in;
        issue_old=io;
        issue_time=it;
    }
    public IssueLog(){
        super();
    }
    public int getId() {
        return id;
    }
    public int getIssue_changes() {
        return issue_changes;
    }
    public String getIssue_new() {
        return issue_new;
    }
    public String getIssue_old() {
        return issue_old;
    }
    public String getIssue_time() {
        return issue_time;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIssue_changes(int issue_changes) {
        this.issue_changes = issue_changes;
    }
    public void setIssue_new(String issue_new) {
        this.issue_new = issue_new;
    }
    public void setIssue_old(String issue_old) {
        this.issue_old = issue_old;
    }
    public void setIssue_time(String issue_time) {
        this.issue_time = issue_time;
    }
}
