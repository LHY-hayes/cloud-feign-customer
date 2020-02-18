package com.hayes.code.cloudfeigncustomer.controller;

import com.hayes.code.cloudfeigncustomer.entity.User;
import com.hayes.code.cloudfeigncustomer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService ;

    @RequestMapping("/feign-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping("/feign-consumer2")
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI",25)).append("\n");
        sb.append(helloService.hello(new User("DIDI",25))).append("\n");
        return sb.toString();
    }


}
