package com.university.forum.usermanagement.AdminManagement.Controllers;


import com.university.forum.usermanagement.MemberManagement.Dtos.Request.StudentRequestDto;
import com.university.forum.usermanagement.MemberManagement.Services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usermanagement/admin/member/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Create Student", description = "Create a new student")
    @PostMapping("createStudent")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequestDto studentRequestDto) {

        System.out.println("First Name: " + studentRequestDto.getFirstName());
        System.out.println("Last Name: " + studentRequestDto.getLastName());
        System.out.println(studentRequestDto);
        return ResponseEntity.ok("Student created successfully");
    }


}

