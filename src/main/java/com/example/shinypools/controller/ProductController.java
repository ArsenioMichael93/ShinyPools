package com.example.shinypools.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.shinypools.database.dao.ProductDAO;
import com.example.shinypools.database.entity.Product;
import com.example.shinypools.formbean.ProductFormBean;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDao;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product() throws Exception {
        ModelAndView response= new ModelAndView();

        List<Product> products = productDao.findAll();

        Comparator<Product> compareByName = (Product p1, Product p2) -> p1.getName().compareTo(p2.getName());
        Collections.sort(products, compareByName);

        response.addObject("products", products);

        response.setViewName("product");
        return response;
    }


    @RequestMapping(value = "/product/productSubmit", method = RequestMethod.GET)
    public ModelAndView submit(@Valid ProductFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response= new ModelAndView();
        response.setViewName("redirect:/product");

        log.debug(form.toString());

        if (bindingResult.hasErrors())  {
            // this is the error case
            for ( FieldError error : bindingResult.getFieldErrors()) {
                log.debug(error.toString());
            }

            // add the errors to the model to be displayed on the page
            response.addObject("bindingResult", bindingResult);

            // add the form bean back to the model so I can fill the form with the user input
            response.addObject("form", form);
        } else {
            // this is the success case
            // we are going to save the product to the database

            Product product = new Product();

            product.setName(form.getProductName());
            product.setDescription(form.getDescription());
            product.setPrice(form.getPrice());
            product.setImageUrl(form.getImageURL());

            productDao.save(product);

        }


        return response;
    }


    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(name = "productId") Integer id) throws Exception {
        log.info(product().toString());
        ModelAndView response= new ModelAndView();
        log.info(product().toString());
        response.setViewName("redirect:/product");
        log.info(product().toString());

        Product p = productDao.findById(id);
        if ( p == null ) {
            log.info(product().toString());
            // this is an error
        } else {
            log.info(product().toString());
            productDao.delete(p);
        }
        log.info(product().toString());
        return response;
    }


    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public ModelAndView showAll() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("viewproducts");

        List<Product> productsKey = productDao.findAll();

        response.addObject("productsKey", productsKey);
        return response;
    }

}
