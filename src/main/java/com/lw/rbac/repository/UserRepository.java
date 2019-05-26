package com.lw.rbac.repository;

import com.lw.rbac.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @ClassName UserRepository
 * @Descriptio TODO
 * @Author liwei
 * @Date 2019/5/21 15:27
 * @Version 1.0
 */
@Repository
//
public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findAll(Pageable pageable);

    Page<User> findByPhoneLike(String phone, Pageable pageable);

    Page<User> findByNameLike(String name, Pageable pageable);

    User findFirstByUserId(int userId);

    User findFirstByPhoneEquals(String phone);

    User findFirstByEmailEquals(String email);

//    @Modifying
//    @Transactional
//    @Query("update User u set " +
//            "u.email = case when :#{#user.email} is null then u.email else :#{#user.email} end," +
//            "u.name = case when :#{#user.name} is null then u.name else :#{#user.name} end," +
//            "u.createTime = case when :#{#user.createTime} is null then u.createTime else :#{#user.createTime} end," +
//            "u.loginTime = case when :#{#user.loginTime} is null then u.loginTime else :#{#user.loginTime} end," +
//            "u.lastLoginTime = case when :#{#user.lastLoginTime} is null then u.lastLoginTime else :#{#user.lastLoginTime} end," +
//            "u.head = case when :#{#user.head} is null then u.head else :#{#user.head} end," +
//            "u.phone = case when :#{#user.phone} is null then u.phone else :#{#user.phone} end," +
//            "u.password = case when :#{#user.password} is null then u.password else :#{#user.password} end " +
//            "where u.userId=:#{#user.userId}")
//    int updateUserBySelective(User user);

    @Modifying
    @Transactional
    @Query("update User u set u.loginTime=?1,u.lastLoginTime=?2 where u.userId=?3")
    int updateUserLoginTime(Date loginTime, Date lastLoginTime, int userId);
}