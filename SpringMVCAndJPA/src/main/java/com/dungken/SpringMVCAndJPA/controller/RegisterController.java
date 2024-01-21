package com.dungken.SpringMVCAndJPA.controller;

import com.dungken.SpringMVCAndJPA.RegisterUser.RegisterUser;
import com.dungken.SpringMVCAndJPA.dao.RoleRepository;
import com.dungken.SpringMVCAndJPA.entity.Role;
import com.dungken.SpringMVCAndJPA.entity.User;
import com.dungken.SpringMVCAndJPA.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;
    private RoleRepository roleRepository;

    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/showPageRegister")
    public String showPageRegister(Model model) {
        RegisterUser ru = new RegisterUser();
        model.addAttribute("registerUser", ru);
        return "register/form";
    }

    @InitBinder
    public void initBinder(WebDataBinder data) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute RegisterUser ru,
                          BindingResult result,
                          Model model,
                          HttpSession session
                          ) {
        String username = ru.getUsername();
        // Form validate
        if(result.hasErrors()) {
            return "register/form";
        }

        // Check user exist
        User userExisting = userService.findByUsername(username);
        if(userExisting != null) {
            model.addAttribute("registerUser", new RegisterUser());
            model.addAttribute("my_error", "Tài khoản đã tồn tại!");
            return "register/form";
        }

        // User not exist
        User user = new User();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setUsername(ru.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(ru.getPassword()));
        user.setFirstName(ru.getFirstName());
        user.setLastName(ru.getLastName());
        user.setEmail(ru.getEmail());

        Role defaultRole = roleRepository.findByName("ROLE_USER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(defaultRole);
        user.setRoles(roles);

        userService.save(user);

        // Notify success
        session.setAttribute("my_user", user);
        return "register/confirmation";
    }
}
