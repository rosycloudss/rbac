package com.lw.rbac.repository;

import com.lw.rbac.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName MenuRepository
 * @Descriptio TODO 
 * @Author liwei
 * @Date 2019/5/25 20:52
 * @Version 1.0
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>, JpaSpecificationExecutor<Menu> {

    List<Menu> findAllByParentIdEquals(int parentId);

    List<Menu> findAllByMenuNameLike(String menuName);
}
