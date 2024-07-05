package com.learningspring.rushi.week1homework.week1homework;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "flavour.env", havingValue = "strawberry")
public class StrawberrySyrup implements Syrup{

    @Override
    public String getSyrupType() {
        return "{ Strawberry Syrup }";
    }
}
