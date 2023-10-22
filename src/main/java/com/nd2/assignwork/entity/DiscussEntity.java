package com.nd2.assignwork.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.domain.Persistable;

@Entity
@Getter
@Setter
@Table(name = "Discuss")
@IdClass(DiscussID.class)
public class DiscussEntity implements Serializable, Persistable<DiscussID> {

    private static final long serialVersionUID = 1L;

    @Transient
    private boolean isNew = true;

    // Foreign key Discuss_Task
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "taskID", referencedColumnName = "Task_ID", insertable = false, updatable = false))
    @NotNull
    private TaskEntity discussTask;

    // Foreign key Discuss_User
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "userID", referencedColumnName = "User_ID", insertable = false, updatable = false))
    @NotNull
    private UserAccountEntity discussUser;

    @Id
    @Column(name = "Discuss_Time", columnDefinition = "datetime")
    private Date discussTime;

    @Column(name = "Discuss_Content", columnDefinition = "nvarchar(255)")
    @NotBlank
    private String discussContent;

    @PrePersist
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public DiscussID getId() {
        return new DiscussID(discussTime);
    }

}
