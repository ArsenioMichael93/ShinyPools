package com.example.shinypools.service;


import com.example.shinypools.database.dao.ServicesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    @Autowired
    private ServicesDAO servicesDao;
}
