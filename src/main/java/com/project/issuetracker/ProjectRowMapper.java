package com.project.issuetracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class ProjectRowMapper implements RowMapper<Project>{
    @Override
  public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
    Project s = new Project();
    int id = rs.getInt("id");
    String name = rs.getString("project_name");
    String desc = rs.getString("project_description");
    String time = rs.getString("project_created");
    int lead =rs.getInt("project_lead");
    s.setProject_name(name);
    s.setId(id);
    s.setProject_description(desc);
    s.setProject_created(time);
    s.setProject_lead(lead);
    return s;
  }

}
