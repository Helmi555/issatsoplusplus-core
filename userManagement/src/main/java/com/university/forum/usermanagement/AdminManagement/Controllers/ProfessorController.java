package com.university.forum.usermanagement.AdminManagement.Controllers;

import com.university.forum.usermanagement.MemberManagement.Dtos.Request.ProfessorRequestDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Request.StudentRequestDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.ProfessorResponseDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.StudentResponseDto;
import com.university.forum.usermanagement.MemberManagement.Services.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usermanagement/admin/professor/")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @Operation(summary = "Create Professor", description = "Create a new professor")
    @PostMapping("createProfessor")
    public ResponseEntity<?> createProfessor(@Valid @RequestBody ProfessorRequestDto professorRequestDto ) {

        ProfessorResponseDto professorResponseDto=professorService.createProfessor(professorRequestDto);
        Map<String,Object> response=new HashMap<>();
        response.put("professor",professorResponseDto);
        response.put("message","Professor created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
