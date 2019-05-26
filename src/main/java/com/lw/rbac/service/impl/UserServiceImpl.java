package com.lw.rbac.service.impl;

import com.lw.rbac.domain.Menu;
import com.lw.rbac.domain.User;
import com.lw.rbac.repository.UserRepository;
import com.lw.rbac.service.UserService;
import com.lw.rbac.util.Md5Util;
import com.lw.rbac.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName UserServiceImpl
 * @Descriptio TODO
 * @Author liwei
 * @Date 2019/5/21 16:27
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        //生成盐值
        user.setSalt(StringUtil.getSalt());
        //将密码进行hash加密
        user.setPassword(StringUtil.sha256Digest(user.getPassword(), user.getSalt()));
        return userRepository.save(user);
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public User changePassword(String newPassword, String olePassword) {

        return null;
    }


    @Override
    public User findUserById(int id) {
        return null;
    }

    /**
     * @Author liwei
     * @Description TODO 用户登录
     * @Date 2019/5/25 10:08
     * @Param [account, password]
     * @Return com.lw.rbac.domain.User
     */
    @Override
    public User login(String account, String password) {
        User user = null;
        if (!StringUtil.isBlank(account) || !StringUtil.isBlank(password)) {
            if (StringUtil.isPhone(account)) {
                //账号是电话号码时，使用电话号码登录
                user = userRepository.findFirstByPhoneEquals(account);
            } else if (StringUtil.isEmail(account)) {
                //账号是邮箱时，使用邮箱登录
                user = userRepository.findFirstByEmailEquals(account);
            }
            //验证用户是否存在和验证用户密码是否输入真确
            if (user != null && Objects.equals(user.getPassword(), StringUtil.sha256Digest(password, user.getSalt()))) {
                //登录成功
                //设置登录时间
                user.setLastLoginTime(user.getLoginTime());
                user.setLoginTime(new Date());
                user.setCount(user.getCount() + 1);
                //更新用户信息
                user = userRepository.save(user);
            }else{
                user = null;
            }
        }
        return user;
    }

    @Override
    public Page<User> findAll(int pageNo, int pageSize, Sort.Direction dir) {
        return null;
    }
}
