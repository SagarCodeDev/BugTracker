package com.project.issuetracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class IssueLogRowMapper implements  RowMapper<IssueLog>{
    @Override
  public IssueLog mapRow(ResultSet rs, int rowNum) throws SQLException {
    IssueLog s = new IssueLog();
    int id = rs.getInt("id");
    int changes = rs.getInt("issue_changes");
    String old = rs.getString("issue_old");
    String time = rs.getString("issue_time");
    String newt=rs.getString("issue_new");
    s.setIssue_changes(changes);
    s.setId(id);
    s.setIssue_time(time);
    s.setIssue_old(old);
    s.setIssue_new(newt);
    return s;
  }

}
