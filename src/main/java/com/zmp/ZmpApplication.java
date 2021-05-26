package com.zmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class ZmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZmpApplication.class, args);
    }

    @RequestMapping("/action")
    public String action(){
        return "action";
    }

}
