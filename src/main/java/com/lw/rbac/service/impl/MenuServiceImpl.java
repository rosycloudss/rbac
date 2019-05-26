package com.lw.rbac.service.impl;

import com.lw.rbac.domain.Menu;
import com.lw.rbac.domain.Permission;
import com.lw.rbac.domain.Role;
import com.lw.rbac.domain.User;
import com.lw.rbac.repository.MenuRepository;
import com.lw.rbac.repository.UserRepository;
import com.lw.rbac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MenuServiceImpl
 * @Description: TODO
 * @Author liwei
 * @Date 2019/5/25 21:01
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu edit(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void delete(int menuId) {
        menuRepository.deleteById(menuId);
    }

    @Override
    public List<Menu> getAllParentMenu(int userId) {
        User user = userRepository.findFirstByUserId(userId);
        List<Menu> menuList = new ArrayList<>();
        Set<Menu> menuSet = new HashSet<>();
        for (Permission permission : user.getPermission()) {
            if (permission.getMenu().getParentId() == 0) {
                menuSet.add(permission.getMenu());
            }
        }
        for (Role role : user.getRole()) {
            for (Permission permission : role.getPermission()) {
                if (permission.getMenu().getParentId() == 0) {
                    menuSet.add(permission.getMenu());
                }
            }
        }
        menuList.addAll(menuSet);
        return menuList;
    }

    @Override
    public List<Menu> getAllParentMenu() {
        List<Menu> menuList = menuRepository.findAllByParentIdEquals(0);
        return menuList;
    }

    @Override
    public List<Menu> getAllSubMenu(int parentId) {
        return menuRepository.findAllByParentIdEquals(parentId);
    }

    @Override
    public List<Menu> getAllMenuByMenuName(String menuName) {
        return menuRepository.findAllByMenuNameLike(menuName);
    }

    @Override
    public Menu getMenuByMenuId(int menuId) {
        return menuRepository.getOne(menuId);
    }
}
