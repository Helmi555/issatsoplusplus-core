package com.university.forum.usermanagement.AdminManagement.Controllers;


import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Request.BranchRequestDto;
import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Response.BranchResponseDto;
import com.university.forum.usermanagement.ClassGroupManagement.Services.BranchService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usermanagement/admin/branch/")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @Operation(description = "create new branch")
    @PostMapping("createBranch")
    public ResponseEntity<?> createBranch(@Valid @RequestBody BranchRequestDto branchRequestDto) {

        Map<String,Object> response = new HashMap<>();
        if(branchRequestDto.getDepartmentId()<=0){
            response.put("message","Department id <=0");
            return ResponseEntity.badRequest().body(response);
        }

        BranchResponseDto branchResponseDto = branchService.createBranch(branchRequestDto);

        response.put("message", "Branch created successfully");
        response.put("branch",branchResponseDto);
        return ResponseEntity.ok(response);
    }

    @Operation(description = "get all branches")
    @GetMapping("branches")
    public ResponseEntity<?> getAllBranches() {

        Map<String,Object> response = new HashMap<>();
        List<BranchResponseDto> branchResponseDtoList=branchService.getAllBranches();
        response.put("branches",branchResponseDtoList);
        response.put("message","All branches retrieved successfully");
        return ResponseEntity.ok(response);
    }

    @Operation(description = "get branch by id")
    @GetMapping("branches/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable int id) {

        Map<String,Object> response = new HashMap<>();
        BranchResponseDto branchResponseDto=branchService.getBranchById(id);
        response.put("branch",branchResponseDto);
        response.put("message","Branch retrieved successfully");
        return ResponseEntity.ok(response);
    }

}
