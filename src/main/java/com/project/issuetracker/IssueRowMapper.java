package com.project.issuetracker;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class IssueRowMapper implements  RowMapper<Issue>{
    @Override
  public Issue mapRow(ResultSet rs, int rowNum) throws SQLException {
    Issue s = new Issue();
    int id = rs.getInt("id");
    int project = rs.getInt("issue_project");
    String desc = rs.getString("issue_description");
    String time = rs.getString("issue_created");
    int assignee =rs.getInt("issue_assignee");
    int reporter=rs.getInt("issue_reporter");
    String status=rs.getString("issue_status");
    s.setIssue_project(project);
    s.setId(id);
    s.setIssue_description(desc);
    s.setIssue_created(time);
    s.setIssue_assignee(assignee);
    s.setIssue_reporter(reporter);
    s.setIssue_status(status);
    return s;
  }

}

