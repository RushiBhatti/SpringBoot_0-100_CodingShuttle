package com.learningspring.rushi.week1homework.week1homework;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CakeBaker {

    @Autowired
    private Frosting frosting;

    @Autowired
    private Syrup syrup;

    public String bakeCake(){
        return "Baking Cake with " + frosting.getFrostingType() + " and " + syrup.getSyrupType() ;
    }

    @PostConstruct
    void callAfterCreatingCakeMaker(){
        System.out.println("Cake Maker object is created - PostConstruct()");
    }

    @PreDestroy
    void callBeforeDestroying(){
        System.out.println("Cake Maker object is being destroyed - PreDestroy()");
    }

}
