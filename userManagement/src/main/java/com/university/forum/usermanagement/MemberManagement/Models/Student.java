package com.university.forum.usermanagement.MemberManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.university.forum.usermanagement.ClassGroupManagement.Models.ClassGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity


public class Student extends Member {
    private String studentNumber;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private ClassGroup classGroup;
    public Student() {}

    public Student(String studentNumber, ClassGroup classGroup) {
        this.studentNumber = studentNumber;
        this.classGroup = classGroup;
    }

    public Student(UUID id, String firstName, String lastName, String addressEmail, String phoneNumber, String address, String password, String linkedInProfileUrl, String profileImageUrl, String cin, Boolean sex, LocalDate dob, Timestamp createdAt, Timestamp updatedAt, Set<Role> roles, String studentNumber, ClassGroup classGroup) {
        super(id, firstName, lastName, addressEmail, phoneNumber, address, password, linkedInProfileUrl, profileImageUrl, cin, sex, dob, createdAt, updatedAt, roles);
        this.studentNumber = studentNumber;
        this.classGroup = classGroup;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public ClassGroup getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(ClassGroup classGroup) {
        this.classGroup = classGroup;
    }
}
