package com.university.forum.usermanagement.MemberManagement.Services;

import com.university.forum.usermanagement.MemberManagement.Dtos.Request.StudentRequestDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.StudentResponseDto;

public interface StudentService {
    StudentResponseDto createStudent(StudentRequestDto studentRequestDto);
}
