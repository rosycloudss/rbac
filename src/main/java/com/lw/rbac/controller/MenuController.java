package com.lw.rbac.controller;

import com.lw.rbac.domain.Menu;
import com.lw.rbac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MenuController
 * @Description: TODO
 * @Author liwei
 * @Date 2019/5/25 22:04
 * @Version 1.0
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * @Author liwei
     * @Description TODO 获取菜单信息 如果menuId不为空 则通过menuId查询菜单信息 并跳转到菜单编辑界面 如果为空则通过menuName查询菜单信息并跳转到菜单列表
     * @Date 2019/5/26 9:11
     * @Param [menuName, menuId, session, model]
     * @Return java.lang.String
     */
    @RequestMapping("/get-menu.do")
    public String getMenu(String menuName, Integer menuId, HttpSession session, Model model) {
        if (menuId != null) {
            Menu menu = menuService.getMenuByMenuId(menuId);
            System.out.println("menu=" + menu);
            model.addAttribute("menu", menu);
            return "/menu-edit";
        } else {
            List<Menu> menuList = new ArrayList<Menu>();
            if (menuName == null) {
                menuList = menuService.getAllParentMenu();
            } else {
                menuList = menuService.getAllMenuByMenuName(menuName);
            }
            model.addAttribute("parentMenuList", menuList);
            return "/menu-list";
        }
    }
}
