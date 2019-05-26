package com.lw.rbac.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OperationLog
 * @Descriptio TODO 操作日志
 * @Author liwei
 * @Date 2019/5/21 14:57
 * @Version 1.0
 */
@Entity
@Table(name = "tb_op_log")
@Getter
@Setter
public class OperationLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "log_id", length = 11)
    @GeneratedValue
    private int logId;

    @OneToOne
    @JoinColumn(name = "op_id")
    @NotFound(action = NotFoundAction.IGNORE)
    protected Operation operation;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotFound(action=NotFoundAction.IGNORE)
    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "op_time")
    private Date opTime;//操作时间

    @Override
    public String toString() {
        return "OperationLog{" +
                "logId=" + logId +
                ", operation=" + operation +
                ", user=" + user +
                ", opTime=" + opTime +
                '}';
    }
}
