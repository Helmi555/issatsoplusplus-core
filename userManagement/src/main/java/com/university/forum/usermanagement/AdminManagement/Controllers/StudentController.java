package com.university.forum.usermanagement.AdminManagement.Controllers;


import com.university.forum.usermanagement.MemberManagement.Dtos.Request.StudentRequestDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.StudentResponseDto;
import com.university.forum.usermanagement.MemberManagement.Services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usermanagement/admin/student/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Create Student", description = "Create a new student")
    @PostMapping("createStudent")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequestDto studentRequestDto) {

        StudentResponseDto studentResponseDto=studentService.createStudent(studentRequestDto);
        Map<String,Object> response=new HashMap<>();
        response.put("student",studentResponseDto);
        response.put("message","Student created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}

