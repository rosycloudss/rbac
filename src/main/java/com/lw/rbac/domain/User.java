package com.lw.rbac.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * @ClassName User
 * @Descriptio TODO
 * @Author liwei
 * @Date 2019/5/21 13:37
 * @Version 1.0
 */
@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", length = 10)
    @GeneratedValue
    private int userId;//用户编号

    @Column(name = "pwd", length = 200, nullable = false)
    private String password; //密码

    @Column(name = "salt", length = 50, nullable = false)
    private String salt; //盐值

    @Column(name = "head", length = 100)
    private String head;//用户头像

    @Column(name = "name", length = 20, nullable = false)
    private String name;//用户姓名

    @Column(name = "phone", length = 11, unique = true, nullable = false)
    private String phone;//电话号码

    @Column(name = "email", length = 50)
    private String email;//邮箱

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false)
    private Date createTime;//创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "login_time")
    private Date loginTime;//登录时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login_time")
    private Date lastLoginTime;//上次登录时间

    @Column(name = "count", length = 10, nullable = false)
    private int count;//登录次数

    @OneToMany
    @JoinTable(name = "tb_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @NotFound(action = NotFoundAction.IGNORE)
    List<Role> role;//用户的角色信息

    @OneToMany
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "tb_user_permission", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    List<Permission> permission;//用户的权限信息

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", head='" + head + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                ", lastLoginTime=" + lastLoginTime +
                ", count=" + count +
                ", role=" + role +
                ", permission=" + permission +
                '}';
    }
}
