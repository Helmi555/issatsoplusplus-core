package com.university.forum.usermanagement.AdminManagement.ExceptionHandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.regex.*;


@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private DataSource dataSource;

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleEmailAlreadyExistsException(ElementNotFoundException ex) {
        return new ResponseEntity<>(Map.of("message",ex.getMessage()), HttpStatus.NOT_FOUND); // 404
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = ex.getMostSpecificCause().getMessage();

        Pattern pattern = Pattern.compile("constraint \"(.*?)\"");
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String constraintName = matcher.group(1);

            String columnName = getColumnNameFromConstraint(constraintName);

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message",columnName + " already exists. Please use a different one."));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","Database error: " + message));
    }



    private String getColumnNameFromConstraint(String constraintName) {
        String sql = """
            SELECT a.attname AS column_name
            FROM pg_constraint c
            JOIN pg_class t ON c.conrelid = t.oid
            JOIN pg_attribute a ON a.attrelid = t.oid AND a.attnum = ANY(c.conkey)
            WHERE c.conname = ?
        """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, constraintName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("column_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Field";
    }
}
