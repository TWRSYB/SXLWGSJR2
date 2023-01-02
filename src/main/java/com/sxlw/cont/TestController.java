package com.sxlw.cont;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get1")
    public String get1(){
        System.out.println("测试get1");
        return "测试get1";
    }

    @PostMapping("/post1")
    public String post1(){
        System.out.println("测试post1");
        return "测试post1";
    }

    @PostMapping("/post2")
    public String post2(@RequestBody Map map){
        System.out.println("map = " + map);
        System.out.println("测试post2");
        return "测试post2";
    }

}
