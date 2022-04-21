package com.example.shinypools.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.example.shinypools.database.dao.UserDAO;
import com.example.shinypools.database.entity.User;

import java.io.File;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        // this little block of code can grab the logged in user and look it up in the
        // database to get the user object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User loggedInUser = userDao.findByEmail(currentPrincipalName);

        if (loggedInUser == null) {
            log.debug("Not logged in");
        } else {
            log.debug("User logged in " + loggedInUser);
        }

        response.setViewName("index");

        return response;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView upload() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("upload");

        return response;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadPost(@RequestParam("file") MultipartFile file) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("upload");

        log.debug("uploaded file = " + file.getOriginalFilename() + " size = " + file.getSize());

        File targetFile = new File("d:/" + file.getOriginalFilename());

        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);

        return response;
    }



}
