package com.codingShuttle.raushan.Introweek1.week1;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty (name="deploy.env", havingValue="prod")
public class prodDB implements DB{
    public String getData(){
        return "Production data";
    }
}
