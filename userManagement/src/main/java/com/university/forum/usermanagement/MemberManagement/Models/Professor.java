package com.university.forum.usermanagement.MemberManagement.Models;

import com.university.forum.usermanagement.ClassGroupManagement.Models.ClassGroup;
import com.university.forum.usermanagement.MemberManagement.Models.Abstract_Classes.Personnel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity

public class Professor extends Personnel {


    @ManyToMany
    @JoinTable(
            name = "professor_group",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "class_group_id")
    )
    private Set<ClassGroup> classGroups=new HashSet<>();

    public Set<ClassGroup> getClassGroups() {
        return classGroups;
    }

    public void setClassGroups(Set<ClassGroup> classGroups) {
        this.classGroups = classGroups;
    }

    public Professor() {
    }

    public Professor(Set<ClassGroup> classGroups) {
        this.classGroups = classGroups;
    }
}
