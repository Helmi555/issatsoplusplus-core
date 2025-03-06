package com.university.forum.usermanagement.MemberManagement.Services.Impl;

import com.university.forum.usermanagement.AdminManagement.ExceptionHandler.ElementNotFoundException;
import com.university.forum.usermanagement.ClassGroupManagement.Models.ClassGroup;
import com.university.forum.usermanagement.ClassGroupManagement.Repositories.ClassGroupRepository;
import com.university.forum.usermanagement.MemberManagement.Dtos.Request.ProfessorRequestDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.ProfessorResponseDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.StudentResponseDto;
import com.university.forum.usermanagement.MemberManagement.Models.Professor;
import com.university.forum.usermanagement.MemberManagement.Models.Role;
import com.university.forum.usermanagement.MemberManagement.Models.Student;
import com.university.forum.usermanagement.MemberManagement.Repositories.ProfessorRepository;
import com.university.forum.usermanagement.MemberManagement.Repositories.RoleRepository;
import com.university.forum.usermanagement.MemberManagement.Services.ProfessorService;
import com.university.forum.usermanagement.Shared.Services.PasswordService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final RoleRepository roleRepository;
    private final ClassGroupRepository classGroupRepository;
    private final PasswordService passwordService;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, RoleRepository roleRepository, ClassGroupRepository classGroupRepository, PasswordService passwordService) {
        this.professorRepository = professorRepository;
        this.roleRepository = roleRepository;
        this.classGroupRepository = classGroupRepository;
        this.passwordService = passwordService;
    }

    @Override
    public ProfessorResponseDto createProfessor(ProfessorRequestDto professorRequestDto) {
       Set<Role> roles = getRolesByIds(professorRequestDto.getRolesIds());
       Set<ClassGroup> classGroups=getClassGroupsByIds(professorRequestDto.getClassGroupIds());

       Professor professor= new Professor();
       professor.setFirstName(professorRequestDto.getFirstName());
       professor.setLastName(professorRequestDto.getLastName());
       professor.setRoles(roles);
       professor.setClassGroups(classGroups);
       professor.setAddress(professorRequestDto.getAddress());
       professor.setCin(professorRequestDto.getCin());
       professor.setAddressEmail(professorRequestDto.getAddressEmail());
       professor.setDob(professorRequestDto.getDob());
       professor.setLinkedInProfileUrl(professorRequestDto.getLinkedInProfileUrl());
       professor.setProfileImageUrl(professorRequestDto.getProfileImageUrl());
       professor.setPhoneNumber(professorRequestDto.getPhoneNumber());
       professor.setSex(professorRequestDto.getSex());
       professor.setPassword(passwordService.hashPassword(professorRequestDto.getPassword()));

       professor=professorRepository.save(professor);

       return convertToProfessorResponseDto(professor);
    }


    private Set<Role> getRolesByIds(Set<Integer> roleIds) {
        Set<Role> roles = new HashSet<>();
        for (Integer roleId : roleIds) {
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new ElementNotFoundException("Role not found"));
            roles.add(role);
        }
        if (roles.isEmpty()) {
            throw new ElementNotFoundException("There are no existing roles associated with this professor");
        }
        return roles;
    }

    private Set<ClassGroup> getClassGroupsByIds(Set<Integer> classGroupIds) {
        Set<ClassGroup> classGroups = new HashSet<>();
        for (Integer classGroupId : classGroupIds) {
            ClassGroup classGroup = classGroupRepository.findById(classGroupId)
                    .orElseThrow(() -> new ElementNotFoundException("ClassGroup not found with id : "+classGroupId));
            classGroups.add(classGroup);
        }
        if (classGroups.isEmpty()) {
            throw new ElementNotFoundException("There are no existing classGroups associated with this professor");
        }
        return classGroups;
    }
    public ProfessorResponseDto convertToProfessorResponseDto(Professor professor) {
        ProfessorResponseDto responseDto = new ProfessorResponseDto();
        responseDto.setId(professor.getId());
        responseDto.setFirstName(professor.getFirstName());
        responseDto.setLastName(professor.getLastName());
        responseDto.setAddressEmail(professor.getAddressEmail());
        responseDto.setPhoneNumber(professor.getPhoneNumber());
        responseDto.setAddress(professor.getAddress());
        responseDto.setLinkedInProfileUrl(professor.getLinkedInProfileUrl());
        responseDto.setCin(professor.getCin());
        responseDto.setDob(professor.getDob());
        responseDto.setSex(professor.getSex());
        responseDto.setProfileImageUrl(professor.getProfileImageUrl());
        for(ClassGroup classGroup : professor.getClassGroups()) {
            responseDto.getClassGroupIds().add(classGroup.getId());
        }

        return responseDto;
    }
}
