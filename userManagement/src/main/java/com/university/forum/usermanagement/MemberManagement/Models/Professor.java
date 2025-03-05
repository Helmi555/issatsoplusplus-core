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

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Professor extends Personnel {


    @ManyToMany
    @JoinTable(
            name = "professor_group",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "class_group_id")
    )
    private List<ClassGroup> classGroups;

}
