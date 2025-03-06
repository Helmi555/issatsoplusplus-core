package com.university.forum.usermanagement.MemberManagement.Services;

import com.university.forum.usermanagement.MemberManagement.Dtos.Request.ProfessorRequestDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.ProfessorResponseDto;

public interface ProfessorService {
    ProfessorResponseDto createProfessor(ProfessorRequestDto professorRequestDto);
}
