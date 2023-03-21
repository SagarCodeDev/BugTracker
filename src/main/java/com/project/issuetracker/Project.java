package com.project.issuetracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String project_description;
    private String project_name;
    private int project_lead;
    private String project_created;
    public Project(int id,String pd,String pn, int pl, String pc){
        this.id=id;
        this.project_created=pc;
        this.project_description=pd;
        this.project_lead=pl;
        this.project_name=pn;
    }
    public Project(){
        super();
    }
    public int getId() {
        return id;
    }
    public String getProject_created() {
        return project_created;
    }
    public String getProject_description() {
        return project_description;
    }
    public int getProject_lead() {
        return project_lead;
    }
    public String getProject_name() {
        return project_name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setProject_created(String project_created) {
        this.project_created = project_created;
    }
    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
    public void setProject_lead(int project_lead) {
        this.project_lead = project_lead;
    }
    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
