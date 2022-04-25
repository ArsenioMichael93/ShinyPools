package com.example.shinypools.controller;

import com.example.shinypools.database.dao.UserDAO;
import com.example.shinypools.database.dao.UserRoleDAO;
import com.example.shinypools.database.entity.User;
import com.example.shinypools.database.entity.UserRole;
import com.example.shinypools.formbean.RegisterFormBean;
import com.example.shinypools.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }


    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());

        if (bindingResult.hasErrors()) {

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form", form);


            response.addObject("bindingResult", bindingResult);

            response.setViewName("user/register");
            return response;
        }


        User user = userDao.findById(form.getId());


        if (user == null) {

            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setCreateDate(new Date());

        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDao.save(user);


        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");

        userRoleDao.save(userRole);

        log.info(form.toString());

        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }


    @GetMapping("/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setPhone(user.getPhone());
        form.setAddress(user.getAddress());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());


        response.addObject("form", form);

        return response;
    }

    @GetMapping("/user/delete/{userId}")
    public ModelAndView deleteUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        User user = userDao.findById(userId);
        if(user == null){
            // Error message
        } else {
            userDao.delete(user);
        }

        return response;
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "firstName", required = false) String firstName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<User> users = new ArrayList<>();

        // very basic example of error checking
        if (!StringUtils.isEmpty(firstName)) {
            users = userDao.findByFirstNameIgnoreCaseContaining(firstName);
        }

        response.addObject("usersModelKey", users);
        response.addObject("firstName", firstName);

        return response;
    }


    @RequestMapping(value = "/profile/{email}", method = RequestMethod.GET)
    public ModelAndView profile(@PathVariable("email") String email)throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/profile");

        RegisterFormBean form = new RegisterFormBean();


        User user = userDao.findByEmail(email);

        response.addObject("firstName", user.getFirstName());
        response.addObject("lastName", user.getLastName());
        response.addObject("phone", user.getPhone());
        response.addObject("address", user.getAddress());
        response.addObject("email", user.getEmail());
        /*        response.addObject("role", UserRole.getuserRole());*/
        return response;
    }


}
