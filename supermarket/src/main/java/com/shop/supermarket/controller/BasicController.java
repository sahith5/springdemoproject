package com.shop.supermarket.controller;


import com.shop.supermarket.entity.Customer;
import com.shop.supermarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
public class BasicController {
    @Autowired
    private UserService usersService;

    @Autowired
    private bookservice itemsService;


    @Autowired
    private RolesService rolesService;
    @Autowired
    private bookservice bookService;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;





    @GetMapping("/loginPage")
    public String login()
    {
        return "login-page";
    }

    @GetMapping("/successHandler")
    public String successHandler(Principal loggedUser, Model theModel)
    {
        theModel.addAttribute("loggedUser",loggedUser.getName());
        theModel.addAttribute("items",bookService.getbooks());
        return "home";
    }

    @GetMapping("/access-denied")
    public String failHandler()
    {
        return "denied";
    }

    @GetMapping("/registerPage")
    public String registerPage()
    {
        return "register";
    }

    @PostMapping("/saveNewUser")
    public String registerPage(@ModelAttribute("user") Customer user, Model model)
    {
        if (usersService.findByUsername(user.getUsername())!=null)
        {
            return "duplicate-user";
        }
        user.setEnabled((short) 1);
        System.out.println(user);
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        usersService.saveCustomer(user);
        model.addAttribute("finalUser",user);
        return "redirect:/loginPage?user=True";
    }

    @GetMapping("/role")
    public String role()
    {
        return "role-page";
    }

//    @PostMapping("/saveRole")
//    public String saveRole(@RequestParam("authority") Roles role, @RequestParam("username") String username, Model model, Principal loggedUser)
//    {
//        if(!usersService.findByUsername(username).getRoles().isEmpty())
//        {
//            return "prompt-page";
//        }
//
//        Users tempUser = usersService.findByUsername(username);
//        Roles tempRole = rolesService.getRolesById(role.getAuthority());
//        tempUser.addRole(tempRole);
//        tempRole.addUser(tempUser);
//        usersService.saveUser(tempUser);
//        return "redirect:/loginPage";
//    }


//    @PostMapping("/deleteUser")
//    public String deleteUser(Principal loggedUser)
//    {
//        usersService.deleteUser(usersService.findByUsername(loggedUser.getName()));
//        return "redirect:/loginPage";
//    }

}
