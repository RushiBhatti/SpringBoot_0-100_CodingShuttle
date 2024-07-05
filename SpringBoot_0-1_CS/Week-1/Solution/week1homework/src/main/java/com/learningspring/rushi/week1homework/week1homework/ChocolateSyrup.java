package com.learningspring.rushi.week1homework.week1homework;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "flavour.env", havingValue = "chocolate")
public class ChocolateSyrup implements Syrup{

    @Override
    public String getSyrupType() {
        return "{ Chocolate Syrup }";
    }
}
