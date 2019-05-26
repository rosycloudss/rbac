package com.lw.rbac.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Permission
 * @Descriptio TODO 权限表
 * @Author liwei
 * @Date 2019/5/21 14:25
 * @Version 1.0
 */
@Entity
@Table(name = "tb_permission")
@Getter
@Setter
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", length = 11)
    @GeneratedValue
    private int id;//权限Id

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "name", length = 100)
    private String name;


    @OneToOne
    @JoinColumn(name = "menu_id")
    @NotFound(action = NotFoundAction.IGNORE)
    protected Menu menu;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                '}';
    }
}
