package com.example.dogdemo.impl;

import com.example.dogdemo.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl {

    @Autowired
    public DogRepo dogRepo;

    
}
