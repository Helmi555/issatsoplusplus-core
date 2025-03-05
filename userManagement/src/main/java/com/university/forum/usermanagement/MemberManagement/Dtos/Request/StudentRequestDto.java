package com.university.forum.usermanagement.MemberManagement.Dtos.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

public class StudentRequestDto {
    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @NotBlank(message = "Email address must not be blank")
    @Email(message = "Email should be valid")
    private String addressEmail;

    @Size(min = 8, max = 8)
    private String phoneNumber;

    private String address;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @Size(min = 8, message = "Confirm Password must be at least 8 characters long")
    private String confirmPassword;
    private String linkedInProfileUrl;

    @NotBlank
    @Size(min = 8, max = 8, message = "CIN must be exactly 8 digits")
    @Pattern(regexp = "\\d{8}", message = "CIN must contain only digits")
    private String cin;

    private Boolean sex;

    public StudentRequestDto(String firstName, String lastName, String addressEmail, String phoneNumber, String address, String password, String confirmPassword, String linkedInProfileUrl, String cin, Boolean sex, LocalDate dob, String studentNumber, Integer classGroupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressEmail = addressEmail;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.linkedInProfileUrl = linkedInProfileUrl;
        this.cin = cin;
        this.sex = sex;
        this.dob = dob;
        this.studentNumber = studentNumber;
        this.classGroupId = classGroupId;
    }

    @Past
    private LocalDate dob;

    @NotBlank
    private String studentNumber;

    @Min(value = 1, message = "Class group ID must be greater than 0")
    private Integer classGroupId;


    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public StudentRequestDto() {
    }

    public @NotBlank(message = "First name must not be blank") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name must not be blank") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Last name must not be blank") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Last name must not be blank") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Email address must not be blank") @Email(message = "Email should be valid") String getAddressEmail() {
        return addressEmail;
    }

    public void setAddressEmail(@NotBlank(message = "Email address must not be blank") @Email(message = "Email should be valid") String addressEmail) {
        this.addressEmail = addressEmail;
    }

    public @Size(min = 8, max = 8) String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(min = 8, max = 8) String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public @Size(min = 8, message = "Password must be at least 8 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, message = "Password must be at least 8 characters long") String password) {
        this.password = password;
    }

    public @Size(min = 8, message = "Confirm Password must be at least 8 characters long") String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@Size(min = 8, message = "Confirm Password must be at least 8 characters long") String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLinkedInProfileUrl() {
        return linkedInProfileUrl;
    }

    public void setLinkedInProfileUrl(String linkedInProfileUrl) {
        this.linkedInProfileUrl = linkedInProfileUrl;
    }

    public @NotBlank @Size(min = 8, max = 8, message = "CIN must be exactly 8 digits") @Pattern(regexp = "\\d{8}", message = "CIN must contain only digits") String getCin() {
        return cin;
    }

    public void setCin(@NotBlank @Size(min = 8, max = 8, message = "CIN must be exactly 8 digits") @Pattern(regexp = "\\d{8}", message = "CIN must contain only digits") String cin) {
        this.cin = cin;
    }

    public @Past LocalDate getDob() {
        return dob;
    }

    public void setDob(@Past LocalDate dob) {
        this.dob = dob;
    }

    public @NotBlank String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(@NotBlank String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public @Min(value = 1, message = "Class group ID must be greater than 0") Integer getClassGroupId() {
        return classGroupId;
    }

    public void setClassGroupId(@Min(value = 1, message = "Class group ID must be greater than 0") Integer classGroupId) {
        this.classGroupId = classGroupId;
    }
}
