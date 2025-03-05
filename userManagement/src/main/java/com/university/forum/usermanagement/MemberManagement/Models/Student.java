package com.university.forum.usermanagement.MemberManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.university.forum.usermanagement.ClassGroupManagement.Models.ClassGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Student extends Member {
    private String studentNumber;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private ClassGroup classGroup;
}
