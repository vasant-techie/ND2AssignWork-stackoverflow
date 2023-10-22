package com.nd2.assignwork.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "DEPARTMENT_USER_MAPPING")
public class DepartmentUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IS_DEPARTMENT_HEAD")
    private Integer isDepartmentHead;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserAccountEntity user;
}
