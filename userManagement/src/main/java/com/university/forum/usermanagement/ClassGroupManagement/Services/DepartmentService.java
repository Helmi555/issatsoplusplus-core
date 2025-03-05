package com.university.forum.usermanagement.ClassGroupManagement.Services;

import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Request.DepartmentRequestDto;
import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Response.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    List<DepartmentResponseDto> getAllDepartments();

    DepartmentResponseDto getDepartmentById(int id);
}
