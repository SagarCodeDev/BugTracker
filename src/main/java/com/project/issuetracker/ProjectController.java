package com.project.issuetracker;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@RestController
public class ProjectController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JavaMailSender mailSender;
    @GetMapping(value = "/users")
    public List<Users> getuser(){
        return jdbcTemplate.query("select * from users",new UsersRowMapper());
    }
    @GetMapping(value = "/projects")
    public List<Project> getproject(){
        return jdbcTemplate.query("select * from project",new ProjectRowMapper());
    }
    @GetMapping(value = "/issue")
    public List<Issue> getissue(){
        return jdbcTemplate.query("select * from issue",new IssueRowMapper());
    }
    @GetMapping(value = "/issues/{id}")
    public Issue getissues(@PathVariable int id){
        List<Issue> x= jdbcTemplate.query("select * from issue",new IssueRowMapper());
        Issue ans=new Issue();
        for(Issue aa:x){
            if(aa.getId()==id){
                ans=aa;
                break;
            }
        }
        return ans;
    }
    @GetMapping(value = "/project/{id}")
    public Project getproject(@PathVariable int id){
        List<Project> x= jdbcTemplate.query("select * from project",new ProjectRowMapper());
        Project ans=new Project();
        for(Project aa:x){
            if(aa.getId()==id){
                ans=aa;
                break;
            }
        }
        return ans;
    }
    @GetMapping(value="/projects/{id}")
    public ProjectClass getprojectdetails(@PathVariable int id){
        List<Project> x=jdbcTemplate.query("select * from project",new ProjectRowMapper());
        Project y=new Project();
        for(Project aa:x){
            if(aa.getId()==id){
                y=aa;
                break;
            }
        }
        ProjectClass z=new ProjectClass();
        z.setDesc(y.getProject_description());
        List<Users> u=jdbcTemplate.query("select * from users",new UsersRowMapper());
        Users uv=new Users();
        for(Users xy:u){
            if(xy.getid()==y.getProject_lead()){
                uv=xy;
            }
        }
        z.setLead(uv.getUser_name());
        z.setDesc(y.getProject_description());
        z.setName(y.getProject_name());
        z.setTime(y.getProject_created());
        z.setId(id);
        return z;
    }
    @GetMapping(value="/issue/{id}")
    public IssueClass getissuedetails(@PathVariable int id){
        List<Issue> x=jdbcTemplate.query("select * from issue",new IssueRowMapper());
        Issue y=new Issue();
        for(Issue aa:x){
            if(aa.getId()==id){
                y=aa;
                break;
            }
        }
        IssueClass z=new IssueClass();
        z.setTime(y.getIssue_created());
        z.setDesc(y.getIssue_description());
        z.setStatus(y.getIssue_status());
        List<Users> u=jdbcTemplate.query("select * from users",new UsersRowMapper());
        Users uv1=new Users();
        Users uv2=new Users();
        for(Users aa:u){
            if(aa.getid()==y.getIssue_assignee()){
                uv1=aa;
            }
            if(aa.getid()==y.getIssue_reporter()){
                uv2=aa;
            }
        }
        List<Project> p=jdbcTemplate.query("select * from project",new ProjectRowMapper());
        Project p1=new Project();
        for(Project aa:p){
            if(aa.getId()==y.getIssue_project()){
                p1=aa;
                break;
            }
        }
        z.setAssignee(uv1.getUser_name());
        z.setReporter(uv2.getUser_name());
        z.setProject(p1.getProject_name());
        z.setId(id);
        return z;
    }
    @GetMapping(value = "/issuelog")
    public List<IssueLog> issuelog(){
        return jdbcTemplate.query("select * from issue_log",new IssueLogRowMapper());
    }
    @PostMapping(value = "/users")
    public Users postuser(@RequestBody Users user){
        String insertQuery = String.format("insert into users values(%d,'%s', '%s')", user.getid(), user.getUser_name(), user.getUser_mail());
        jdbcTemplate.execute(insertQuery);
        System.out.println("Recieved");
        return user;
    }
    @PostMapping(value="/projects")
    public Project postproject(@RequestBody Project project){
        String insertQuery = String.format("insert into project values(%d,'%s', '%s',%d,'%s')", project.getId(),project.getProject_name(), project.getProject_description(),project.getProject_lead(),project.getProject_created());
        jdbcTemplate.execute(insertQuery);
        System.out.println("recieved");
        return project;
    }
    @PostMapping(value="/issue")
    public Issue postissue(@RequestBody Issue issue){
        String insertQuery = String.format("insert into issue values(%d,'%s',%d,'%s',%d,%d,'%s')", issue.getId(),issue.getIssue_description(), issue.getIssue_project(),issue.getIssue_created(),issue.getIssue_assignee(),issue.getIssue_reporter(),issue.getIssue_status());
        jdbcTemplate.execute(insertQuery);
        System.out.println("recieved");
        return issue;
    }
    @PostMapping(value="/issuelog")
    public IssueLog postissuelog(@RequestBody IssueLog issuelog){
        String insertQuery = String.format("insert into issue_log values(%d,'%s','%s','%s','%s')", issuelog.getId(),issuelog.getIssue_changes(), issuelog.getIssue_time(),issuelog.getIssue_old(),issuelog.getIssue_new());
        jdbcTemplate.execute(insertQuery);
        System.out.println("recieved");
        return issuelog;
    }
    @PutMapping(value="/users/{id}")
    public Users putusers(@PathVariable int id, @RequestBody Users user){
        System.out.println("Recieved");
        String insertQuery = String.format("update users set id=%d,user_name='%s',user_mail='%s' where id=%d",user.getid(), user.getUser_name(), user.getUser_mail(),user.getid());
        jdbcTemplate.execute(insertQuery);
        return user;
    }
    @PutMapping(value="/projects/{id}")
    public Project putproject(@PathVariable Long id, @RequestBody Project project){
        System.out.println("Recieved");
        String insertQuery = String.format("update project set id=%d,project_description='%s',project_name='%s',project_lead=%d,project_created='%s' where id=%d",project.getId(),project.getProject_description(), project.getProject_name(),project.getProject_lead(),project.getProject_created(),project.getId());
        jdbcTemplate.execute(insertQuery);
        return project;
    }
    @PutMapping(value="/issue/{id}")
    public Issue putissue(@PathVariable Long id, @RequestBody Issue issue){
        System.out.println("Recieved");
        String insertQuery = String.format("update issue set id=%d,issue_description='%s',issue_project=%d,issue_created='%s',issue_assignee=%d,issue_reporter=%d,issue_status='%s' where id=%d",issue.getId(),issue.getIssue_description(), issue.getIssue_project(),issue.getIssue_created(),issue.getIssue_assignee(),issue.getIssue_reporter(),issue.getIssue_status(),issue.getId());
        jdbcTemplate.execute(insertQuery);
        return issue;
    }
    @PutMapping(value="/issuelog/{id}")
    public IssueLog puissuelog(@PathVariable Long id, @RequestBody IssueLog issuelog){
        System.out.println("Recieved");
        String insertQuery = String.format("update issue_log set id=%d,issue_changes=%d,issue_time='%s',issue_old='%s',issue_new='%s' where id=%d",issuelog.getId(),issuelog.getIssue_changes(), issuelog.getIssue_time(),issuelog.getIssue_old(),issuelog.getIssue_new(),issuelog.getId());
        jdbcTemplate.execute(insertQuery);
        return issuelog;
    }
}
