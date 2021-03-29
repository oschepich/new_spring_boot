package com.oschepich.spring_boot.new_spring_boot.controler;


import com.oschepich.spring_boot.new_spring_boot.model.Role;
import com.oschepich.spring_boot.new_spring_boot.model.User;
import com.oschepich.spring_boot.new_spring_boot.repository.UserDaoImpl;
import com.oschepich.spring_boot.new_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private final UserService userService;
    @Autowired
    private final UserDaoImpl userDao;

    public AdminController(UserService userService, UserDaoImpl userDao) {
        this.userService = userService;
        this.userDao = userDao;
    }

    //вывожу всех пользователей
    @GetMapping
    public ModelAndView getAllUsers(ModelAndView modelAndView, Principal principal) {
        modelAndView.addObject( "tecUser", this.userDao.getUserByUsername(principal.getName()));
        modelAndView.addObject("allUser", userService.getAllUser());
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("admin");
        return modelAndView;
    }
    //создаю нового пользователя
    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "admin";
    }
    //создаю нового пользователя
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam(value = "roleSet", required = false) String[] roleSet) {
//        @RequestParam(name = "roleSet", required = false) String[] roleSet) {
        user.setRole(getAddRole(roleSet));
        userService.saveUser(user);
        return "redirect:/admin";
    }
    //редактирую пользователя
    @GetMapping("/edit/{id}")
    public ModelAndView getUserToEdit(@PathVariable Long id) {
        User user = (User) userService.show(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    //редактирую пользователя
    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "roleSet", required = false) String[] roleSet) {
//        @RequestParam(name = "roleSet", required = false) String[] roleSet) {

            user.setRole(getAddRole(roleSet));
            userService.saveUser(user);
        return "redirect:/admin";
    }
    //удаляю пользователя
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    private Set<Role> getAddRole(String[] roles) {
        if (roles == null){
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(userService.getRoleByName("ROLE_USER"));
            return roleSet;
        }
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            roleSet.add(userService.getRoleByName(role));
        }
        return roleSet;
    }

}

