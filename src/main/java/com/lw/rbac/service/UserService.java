package com.lw.rbac.service;

import com.lw.rbac.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Date;

/**
 * @ClassName UserService
 * @Descriptio TODO
 * @Author liwei
 * @Date 2019/5/21 15:42
 * @Version 1.0
 */
public interface UserService {

    /**
     * @Author liwei
     * @Description TODO 添加用户
     * @Date 2019/5/25 0:11
     * @Param [user]
     * @Return com.lw.rbac.domain.User
     */
    User save(User user);

    /**
     * @Author liwei
     * @Description TODO 编辑用户
     * @Date 2019/5/25 0:12
     * @Param [user]
     * @Return com.lw.rbac.domain.User
     */
    User edit(User user);

    /**
     * @Author liwei
     * @Description TODO 修改密码
     * @Date 2019/5/25 0:13
     * @Param [newPassword, oldPassword]
     * @Return com.lw.rbac.domain.User
     */
    User changePassword(String newPassword, String oldPassword);


    /**
     * @Author liwei
     * @Description TODO 通过Id查询用户信息
     * @Date 2019/5/25 0:13
     * @Param [id]
     * @Return com.lw.rbac.domain.User
     */
    User findUserById(int id);

    /**
     * @Author liwei
     * @Description TODO 用户登录 account 可以是邮箱或者电话号码
     * @Date 2019/5/25 0:14
     * @Param [account, password]
     * @Return com.lw.rbac.domain.User
     */
    User login(String account, String password);

    /**
     * @Author liwei
     * @Description TODO 分页查询用户信息
     * @Date 2019/5/25 0:14
     * @Param [pageNo, pageSize, dir]
     * @Return org.springframework.data.domain.Page<com.lw.rbac.domain.User>
     */
    Page<User> findAll(int pageNo, int pageSize, Sort.Direction dir);

}
