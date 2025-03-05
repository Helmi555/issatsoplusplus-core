package com.university.forum.usermanagement.AdminManagement.Controllers;

import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Request.DepartmentRequestDto;
import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Response.DepartmentResponseDto;
import com.university.forum.usermanagement.ClassGroupManagement.Services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usermanagement/admin/department/")
public class DepartmentController {

    private final DepartmentService departementService;

    public DepartmentController(DepartmentService departementService) {
        this.departementService = departementService;
    }

    @Operation(description = "create a new department")
    @PostMapping("createDepartment")
    public ResponseEntity<?> createDepartement(@Valid @RequestBody DepartmentRequestDto departmentRequestDto) {

        System.out.println("dep received : "+departmentRequestDto.getReference());
        DepartmentResponseDto departmentResponseDto=departementService.createDepartment(departmentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentResponseDto);
    }

    @Operation(description = "get all departments")
    @GetMapping("departments")
    public ResponseEntity<?> getAllDepartments() {
        List<DepartmentResponseDto> departmentResponseDtos=departementService.getAllDepartments();
        Map<String,Object> message=new HashMap<>();
        message.put("departments",departmentResponseDtos);
        message.put("message","Departments list retrieved successfully");
        return ResponseEntity.ok(message);
    }

    @Operation(description = "get department by id")
    @GetMapping("departments/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable int id) {
        if(id<=0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id is invalid");
        }
        DepartmentResponseDto departmentResponseDto=departementService.getDepartmentById(id);
        Map<String,Object> message=new HashMap<>();
        message.put("department",departmentResponseDto);
        message.put("message","Department retrieved successfully");
        return ResponseEntity.ok(message);
    }

}
