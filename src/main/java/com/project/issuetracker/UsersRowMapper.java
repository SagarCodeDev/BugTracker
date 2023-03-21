package com.project.issuetracker;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users>{

  @Override
  public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
    Users s = new Users();
    int id = rs.getInt("id");
    String name = rs.getString("user_name");
    String mail = rs.getString("user_mail");
    s.setUser_name(name);
    s.setid(id);
    s.setUser_mail(mail);
    return s;
  }

}
