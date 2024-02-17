package com.yashasvi.SpringJDBCDemo.Dao;

import com.yashasvi.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienDao {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){
        String sql = "insert into alien (id) values (?)";
  int rows =  template.update(sql,alien.getId());
        System.out.println("rows affected "+rows);
}

public List<Alien> findAll(){
    String sql = "select * from alien";

    RowMapper<Alien> mapper= new RowMapper<Alien>() {
        @Override
        public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {

            Alien a = new Alien();
            a.setId(rs.getInt(1));
            return a;
        }
    };

   List<Alien> aliens =template.query(sql,mapper);

return aliens;
}
}
