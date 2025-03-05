package com.university.forum.usermanagement.MemberManagement.Dtos.Response;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public class StudentResponseDto {

    private UUID Id;
    private String firstName;
    private String lastName;
    private String addressEmail;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressEmail() {
        return addressEmail;
    }

    public void setAddressEmail(String addressEmail) {
        this.addressEmail = addressEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkedInProfileUrl() {
        return linkedInProfileUrl;
    }

    public void setLinkedInProfileUrl(String linkedInProfileUrl) {
        this.linkedInProfileUrl = linkedInProfileUrl;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getClassGroupId() {
        return classGroupId;
    }

    public void setClassGroupId(Integer classGroupId) {
        this.classGroupId = classGroupId;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public StudentResponseDto() {
    }

    public StudentResponseDto(UUID id, String firstName, String lastName, String addressEmail, String phoneNumber, String address, String linkedInProfileUrl, String cin, LocalDate dob, String studentNumber, Integer classGroupId, Boolean sex) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressEmail = addressEmail;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.linkedInProfileUrl = linkedInProfileUrl;
        this.cin = cin;
        this.dob = dob;
        this.studentNumber = studentNumber;
        this.classGroupId = classGroupId;
        this.sex = sex;
    }

    private String phoneNumber;
    private String address;
    private String linkedInProfileUrl;
    private String cin;
    private LocalDate dob;
    private String studentNumber;
    private Integer classGroupId;
    private Boolean sex;


}
