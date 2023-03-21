package com.project.issuetracker;

public class ProjectClass {
    int id;
    String name;
    String desc;
    String lead;
    String time;
    public void setId(int id) {
        this.id = id;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setLead(String lead) {
        this.lead = lead;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
    public String getLead() {
        return lead;
    }
    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }
}
