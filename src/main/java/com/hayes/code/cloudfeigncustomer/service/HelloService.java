package com.hayes.code.cloudfeigncustomer.service;

import com.hayes.code.cloudfeigncustomer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("hello-service")
//hello-service 大小写都可以
public interface HelloService {

    @RequestMapping("/hello")
    String hello() ;

    @RequestMapping(value= "/hello1", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name) ;

    @RequestMapping(value= "/hello2", method= RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") int age);
    // RequestParam  RequestHeader 参数绑定


    @RequestMapping(value = "/hello3", method= RequestMethod.POST)
    String hello(@RequestBody User user);

}
