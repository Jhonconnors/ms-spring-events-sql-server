package com.example.demo.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class SpOperation {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpOperation(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertEvents(String events) {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = conn.prepareCall("{call InsertEventsFromXml(?, ?, ?, ?)}")) {

            cstmt.setString(1, events);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            cstmt.registerOutParameter(4, java.sql.Types.INTEGER);

            cstmt.execute();

            int status = cstmt.getInt(2);
            String message = cstmt.getString(3);
            int firstID = cstmt.getInt(4);

            System.out.println("Status: " + status);
            System.out.println("Message: " + message);
            System.out.println("First ID: " + firstID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}