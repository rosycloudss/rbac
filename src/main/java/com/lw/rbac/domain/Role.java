package com.lw.rbac.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Role
 * @Descriptio TODO  角色类
 * @Author liwei
 * @Date 2019/5/21 13:53
 * @Version 1.0
 */
@Entity
@Table(name = "tb_role")
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "role_id", length = 3)
    private int roleId;//角色id

    @Column(name = "parent_role_id")
    private int  parentRoleId;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "description", length = 200)
    private String description;//角色描述

    @OneToMany
    @JoinTable(name = "tb_role_permission", joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Permission> permission;


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", parentRoleId=" + parentRoleId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                ", permission=" + permission +
                '}';
    }
}
