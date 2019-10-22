package cn.tekin.security.controller;

import cn.tekin.security.entity.Role;
import cn.tekin.security.entity.User;
import cn.tekin.security.repository.RoleRepository;
import cn.tekin.security.repository.UserRepository;
import cn.tekin.security.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 20:32
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @RequestMapping("/")
    public String index(Model model) {

        return "/index";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
            return "/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(String name,String password,String role) {
        String encodePassword = MD5Util.encode(password);
        User user = new User(name,encodePassword);
        List<Role> roles = new ArrayList<>();
        Role role1 = roleRepository.findByRolename(role);
        roles.add(role1);
        user.setRoles(roles);
        userRepository.save(user);
            return "/index";
    }
}
