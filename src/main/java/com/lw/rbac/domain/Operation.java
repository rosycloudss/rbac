package com.lw.rbac.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Operation
 * @Descriptio TODO 操作
 * @Author liwei
 * @Date 2019/5/21 14:21
 * @Version 1.0
 */
@Entity
@Table(name = "tb_operation")
@Getter
@Setter
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "op_id", length = 5)
    @GeneratedValue
    private int id;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "operation", length = 100)
    private String operat;//操作标志

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", operat='" + operat + '\'' +
                '}';
    }
}
