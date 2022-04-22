package com.example.shinypools.controller;


import com.example.shinypools.database.dao.ServicesDAO;
import com.example.shinypools.database.entity.Services;
import com.example.shinypools.formbean.ServiceFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
@Slf4j
@Controller
public class ServiceController {

    @Autowired
    private ServicesDAO serviceDao;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public ModelAndView service() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("services");
        //Safety lines for JSP page substitution error
        ServiceFormBean form = new ServiceFormBean();
        response.addObject("formBean", form);
        return response;
    }


    @RequestMapping(value="/services", method = RequestMethod.GET)
    public ModelAndView showServices() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("services");
        List<Services> serviceKey = serviceDao.findAll();

        for (Services service: serviceKey) {
            log.info(service.toString());
        }

        response.addObject("serviceKey", serviceKey);
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/services/serviceSubmit", method ={ RequestMethod.POST, RequestMethod.GET })
    public ModelAndView submit(@Valid ServiceFormBean formBean, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();

        log.info(formBean.toString());
        if(bindingResult.hasErrors()){
            for(FieldError error : bindingResult.getFieldErrors()){
                log.info(error.toString());
            }
            response.addObject("bindingResult", bindingResult);
            response.addObject("formBean", formBean);
        }
        else{
            Services services = new Services();
            services.setName(formBean.getName());
            services.setDescription(formBean.getDescription());
            serviceDao.save(services);
        }
        response.setViewName("services");
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/services/delete{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathParam("id") Integer id) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("services");

        Services services = serviceDao.findById(id);
        if(services == null){
            // TODO
        }
        else{
            serviceDao.delete(services);
        }
        return response;
    }



}
