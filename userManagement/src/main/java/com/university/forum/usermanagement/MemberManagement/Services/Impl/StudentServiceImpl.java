package com.university.forum.usermanagement.MemberManagement.Services.Impl;


import com.university.forum.usermanagement.AdminManagement.ExceptionHandler.ElementNotFoundException;
import com.university.forum.usermanagement.ClassGroupManagement.Models.ClassGroup;
import com.university.forum.usermanagement.ClassGroupManagement.Repositories.ClassGroupRepository;
import com.university.forum.usermanagement.MemberManagement.Dtos.Request.StudentRequestDto;
import com.university.forum.usermanagement.MemberManagement.Dtos.Response.StudentResponseDto;
import com.university.forum.usermanagement.MemberManagement.Models.Role;
import com.university.forum.usermanagement.MemberManagement.Models.Student;
import com.university.forum.usermanagement.MemberManagement.Repositories.RoleRepository;
import com.university.forum.usermanagement.MemberManagement.Repositories.StudentRepository;
import com.university.forum.usermanagement.MemberManagement.Services.StudentService;
import com.university.forum.usermanagement.Shared.Services.PasswordService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final ClassGroupRepository classGroupRepository;
    private final PasswordService passwordService;


    public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository, ClassGroupRepository classGroupRepository, PasswordService passwordService) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.classGroupRepository = classGroupRepository;
        this.passwordService = passwordService;
    }

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {

        Set<Role> roles =getRolesByIds(studentRequestDto.getRolesIds());

        ClassGroup classGroup= classGroupRepository.findById(studentRequestDto.getClassGroupId()).orElseThrow(()->new ElementNotFoundException("ClassGroup not found"));

        Student student=new Student();
        student.setRoles(roles);
        student.setFirstName(studentRequestDto.getFirstName());
        student.setLastName(studentRequestDto.getLastName());
        student.setCin(studentRequestDto.getCin());
        student.setAddress(studentRequestDto.getAddress());
        student.setClassGroup(classGroup);
        student.setStudentNumber(studentRequestDto.getStudentNumber());
        student.setPassword(passwordService.hashPassword(studentRequestDto.getPassword()));
        student.setAddressEmail(studentRequestDto.getAddressEmail());
        student.setLinkedInProfileUrl(studentRequestDto.getLinkedInProfileUrl());
        student.setPhoneNumber(studentRequestDto.getPhoneNumber());
        student.setDob(studentRequestDto.getDob());
        student.setSex(studentRequestDto.getSex());
        student.setProfileImageUrl(studentRequestDto.getProfileImageUrl());

        classGroup.getStudents().add(student);

        studentRepository.save(student);

        return convertToStudentResponseDto(student);
    }

    private Set<Role> getRolesByIds(Set<Integer> roleIds) {
        Set<Role> roles = new HashSet<>();
        for (Integer roleId : roleIds) {
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new ElementNotFoundException("Role not found"));
            roles.add(role);
        }
        if (roles.isEmpty()) {
            throw new ElementNotFoundException("There are no existing roles associated with this student");
        }
        return roles;
    }
    public StudentResponseDto convertToStudentResponseDto(Student student) {
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setFirstName(student.getFirstName());
        responseDto.setLastName(student.getLastName());
        responseDto.setAddressEmail(student.getAddressEmail());
        responseDto.setPhoneNumber(student.getPhoneNumber());
        responseDto.setAddress(student.getAddress());
        responseDto.setLinkedInProfileUrl(student.getLinkedInProfileUrl());
        responseDto.setCin(student.getCin());
        responseDto.setDob(student.getDob());
        responseDto.setStudentNumber(student.getStudentNumber());
        responseDto.setClassGroupId(student.getClassGroup().getId());
        responseDto.setSex(student.getSex());
        responseDto.setProfileImageUrl(student.getProfileImageUrl());

        return responseDto;
    }

}
