package com.university.forum.usermanagement.AdminManagement.Controllers;


import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Request.SpecialityRequestDto;
import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Response.SpecialityResponseDto;
import com.university.forum.usermanagement.ClassGroupManagement.Models.Speciality;
import com.university.forum.usermanagement.ClassGroupManagement.Services.SpecialityService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usermanagement/admin/speciality/")
public class SpecialityControlller {

    private final SpecialityService specialityService;

    public SpecialityControlller(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Operation(description = "create speciality")
    @PostMapping("createSpeciality")
    public ResponseEntity<?> createSpeciality(@Valid @RequestBody SpecialityRequestDto specialityRequestDto) {

        SpecialityResponseDto specialityResponseDto=specialityService.createSpeciality(specialityRequestDto);
        Map<String,Object> response=new HashMap<>();
        response.put("speciality",specialityResponseDto);
        response.put("message","Speciality created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(description = "get all specialities")
    @GetMapping("specialities")
    public ResponseEntity<?> getAllSpecialities() {
        List<SpecialityResponseDto> specialityResponseDtos=specialityService.getAllSpecialities();
        Map<String,Object> response=new HashMap<>();
        response.put("specialities",specialityResponseDtos);
        response.put("message","Specialities returned successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(description = "get speciality by id")
    @GetMapping("specialities/{id}")
    public ResponseEntity<?> getSpecialityById(@PathVariable int id) {
        SpecialityResponseDto specialityResponseDto=specialityService.getSpecialityById(id);
        Map<String,Object> response=new HashMap<>();
        response.put("speciality",specialityResponseDto);
        response.put("message","Speciality returned successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
