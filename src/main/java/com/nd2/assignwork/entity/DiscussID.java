package com.nd2.assignwork.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class DiscussID implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Task_ID")
	private TaskEntity discussTask;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_ID")
	private UserAccountEntity discussUser;
	@Id
	private Date discussTime;

	public DiscussID(Date discussTime) {
		this.discussTime = discussTime;
	}
}
