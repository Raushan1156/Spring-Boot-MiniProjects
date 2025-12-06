package com.codingShuttle.raushan.Introweek1.week1;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@ConditionalOnProperty(name="deploy.env",havingValue = "dev")
public class devDB implements DB{
    public String getData(){
        return "Development data";
    }
}
