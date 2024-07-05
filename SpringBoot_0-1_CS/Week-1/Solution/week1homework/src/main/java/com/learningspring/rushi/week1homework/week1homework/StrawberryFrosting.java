package com.learningspring.rushi.week1homework.week1homework;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "flavour.env", havingValue = "strawberry")
public class StrawberryFrosting implements Frosting{

    @Override
    public String getFrostingType() {
        return "{ Strawberry Frosting }";
    }
}
