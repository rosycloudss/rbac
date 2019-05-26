package com.lw.rbac.service;


import com.lw.rbac.domain.Menu;

import java.util.List;

/**
 * @ClassName MenuService
 * @Descriptio TODO
 * @Author liwei
 * @Date 2019/5/25 20:55
 * @Version 1.0
 */
public interface MenuService {


    /**
     * @Author liwei
     * @Description TODO 添加菜单
     * @Date 2019/5/25 20:58
     * @Param [menu]
     * @Return com.lw.rbac.domain.Menu
     */
    Menu save(Menu menu);

    /**
     * @Author liwei
     * @Description TODO 修改菜单信息
     * @Date 2019/5/25 20:59
     * @Param [menu]
     * @Return com.lw.rbac.domain.Menu
     */
    Menu edit(Menu menu);

    /**
     * @Author liwei
     * @Description TODO 根据菜单编号删除菜单信息
     * @Date 2019/5/25 21:01
     * @Param [menuId]
     * @Return com.lw.rbac.domain.Menu
     */
    void delete(int menuId);

    /**
     * @Author liwei
     * @Description TODO 根据用户Id查询该用户所有的顶级菜单
     * @Date 2019/5/25 20:57
     * @Param [userId]
     * @Return java.util.List<com.lw.rbac.domain.Menu>
     */
    List<Menu> getAllParentMenu(int userId);

    /**
     * @Author liwei
     * @Description TODO 查询所有的顶级菜单
     * @Date 2019/5/25 21:00
     * @Param []
     * @Return java.util.List<com.lw.rbac.domain.Menu>
     */
    List<Menu> getAllParentMenu();

    /**
     * @Author liwei
     * @Description TODO 通过上级菜单id 查询子菜单
     * @Date 2019/5/25 20:57
     * @Param [parentId]
     * @Return java.util.List<com.lw.rbac.domain.Menu>
     */
    List<Menu> getAllSubMenu(int parentId);

    /**
     * @Author liwei
     * @Description TODO 通过菜单名称查询菜单信息
     * @Date 2019/5/25 22:09
     * @Param [menuName]
     * @Return java.util.List<com.lw.rbac.domain.Menu>
     */
    List<Menu> getAllMenuByMenuName(String menuName);

    /**
     * @Author liwei
     * @Description TODO 通过菜单Id查询菜单信息
     * @Date 2019/5/26 9:04
     * @Param [menuId]
     * @Return com.lw.rbac.domain.Menu
     */
    Menu getMenuByMenuId(int menuId);

}
