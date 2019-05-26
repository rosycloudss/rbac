package com.lw.rbac.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName Menu
 * @Descriptio TODO 菜单
 * @Author liwei
 * @Date 2019/5/21 14:06
 * @Version 1.0
 */
@Entity
@Table(name = "tb_menu")
@Getter
@Setter
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "menu_id", length = 4)
    @GeneratedValue
    private int menuId;

    @Column(name = "name", length = 100)
    private String menuName;//菜单名称

    @Column(name = "parent_id", length = 4)
    private int parentId; //上级菜单Id

    @Column(name = "icon", length = 100)
    private String menuIcon;//菜单图标

    @Column(name = "url", length = 100)
    private String url;//菜单连接

    @Column(name = "type", length = 2)
    private int type;//菜单类型

    @Column(name = "menu_order", length = 2)
    private int order;//菜单排序

    @Column(name = "status", length = 2)
    private int status;//菜单状态

    @OneToMany
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    protected List<Menu> subMenu;

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", menuIcon='" + menuIcon + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", order=" + order +
                ", status=" + status +
                ", subMenu=" + subMenu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return menuId == menu.menuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId);
    }
}
