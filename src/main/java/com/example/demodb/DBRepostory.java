package com.example.demodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Map;

@Repository
public class DBRepostory {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public DBRepostory(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }


    public Map<String,Object> getStudent(int id) {
        String sql = "select * from STUDENT where id=?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public Map<String, Object> insert(int id) {
        jdbcTemplate.update("INSERT INTO STUDENT (id, name, passport_number) " +
                        "VALUES (?, ?, ?)",
                id,
                "Raymond"+id,
                "PassportNo-100"+id);

        return getStudent(id);
    }

}
