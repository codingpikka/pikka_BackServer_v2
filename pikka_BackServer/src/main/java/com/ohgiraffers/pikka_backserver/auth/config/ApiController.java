package com.ohgiraffers.pikka_backserver.auth.config;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    public Map<String, String> hello(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");

        return map;
    }
}
