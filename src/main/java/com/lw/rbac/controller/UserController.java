package com.lw.rbac.controller;

import com.lw.rbac.domain.Menu;
import com.lw.rbac.domain.User;
import com.lw.rbac.service.MenuService;
import com.lw.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String account, @RequestParam(required = true) String password, HttpSession session, Model model) {
        System.out.println(account + "===" + password);
        User user = userService.login(account, password);
        if (user != null) {
            session.setAttribute("user", user);
            List<Menu> menuList = menuService.getAllParentMenu(user.getUserId());
            session.setAttribute("menuList",menuList);
            System.out.println(menuList);
            System.out.println(user);
            return "redirect:/main";
        } else {
            model.addAttribute("msg", "账号或密码错误");
            return "/login";
        }
    }

}
