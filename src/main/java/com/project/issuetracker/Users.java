package com.project.issuetracker;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user_name;
    private String user_mail;
    public Users(int id, String name, String mail){
        this.id=id;
        this.user_name=name;
        this.user_mail=mail;
    }
    public Users(){
        super();
    }
    public int getid() {
        return id;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getUser_mail() {
        return user_mail;
    }
    public void setid(int id) {
        this.id = id;
    }
    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
