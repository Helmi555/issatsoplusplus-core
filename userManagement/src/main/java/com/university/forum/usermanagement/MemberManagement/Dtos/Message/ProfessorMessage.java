package com.university.forum.usermanagement.MemberManagement.Dtos.Message;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProfessorMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID Id;
    private String firstName;
    private String lastName;
    private String addressEmail;

    private String phoneNumber;
    private String address;
    private String linkedInProfileUrl;
    private String profileImageUrl;
    private String cin;
    private LocalDate dob;
    //private Set<Integer> classGroupIds=new HashSet<>();
    private Set<Integer> roleIds=new HashSet<>();
    private Boolean sex;

    public ProfessorMessage(UUID id, String firstName, String lastName, String addressEmail, String phoneNumber, String address, String linkedInProfileUrl, String profileImageUrl, String cin, LocalDate dob, Set<Integer> roleIds, Boolean sex) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressEmail = addressEmail;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.linkedInProfileUrl = linkedInProfileUrl;
        this.profileImageUrl = profileImageUrl;
        this.cin = cin;
        this.dob = dob;
        this.roleIds = roleIds;
        this.sex = sex;
    }

    public ProfessorMessage(UUID id, String firstName, String lastName, String addressEmail, String phoneNumber, String address, String linkedInProfileUrl, String profileImageUrl, String cin, LocalDate dob, Boolean sex) {
    }

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

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
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



    public Set<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Set<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public ProfessorMessage() {
    }

    @Override
    public String toString() {
        return "ProfessorMessage{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressEmail='" + addressEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", linkedInProfileUrl='" + linkedInProfileUrl + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", cin='" + cin + '\'' +
                ", dob=" + dob +
                ", roleIds=" + roleIds +
                ", sex=" + sex +
                '}';
    }
}
