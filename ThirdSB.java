package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/Third")
public class ThirdSB {
    @GetMapping("/name")
    public String name()
    {
        String name1="Shunmuga";
        String name2="Priya";
        return name1+"\n"+name2;
    }

    @GetMapping("/number")
    public String number()
    {
        int num1=37;
        int num2=200;
        int ans=num1+num2;
        return num1+"\n"+num2+"\n"+ans;
    }

    @Value("${username}")
    private String username;

    @Value("${java.home}")          //get the value before hit the API
    private String javahome;

    @GetMapping("/uname")
    public String uname()
    {
        return username+"\n"+javahome;
    }

    @Autowired
    private Environment environ;

    @GetMapping("/method")
    public String method()
    {
        String port_num= environ.getProperty("server.port");
        String mail=environ.getProperty("mail_id");
        int reg_no= Integer.parseInt(environ.getProperty("reg_no"));

        log.info("Reg No= "+reg_no);
        log.info("PORT No: "+port_num+"\nMail ID: "+mail);
        return port_num+"\n"+mail+"\n"+reg_no;
    }

    @GetMapping("/display_1")
    public ResponseEntity<?> display1()
    {
        //return new ResponseEntity<>("OK", HttpStatus.OK);
        //return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
        //return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("GATEWAY_TIMEOUT", HttpStatus.GATEWAY_TIMEOUT);
     //   return new ResponseEntity<>("ACCEPTED", HttpStatus.ACCEPTED);
       // return new ResponseEntity<>("BAD_GATEWAY", HttpStatus.BAD_GATEWAY);
       // return new ResponseEntity<>("CONFLICT", HttpStatus.CONFLICT);
       // return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
       // return new ResponseEntity<>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
       // return new ResponseEntity<>("REQUEST_TIMEOUT", HttpStatus.REQUEST_TIMEOUT);
        // return new ResponseEntity<>("PROCESSSING", HttpStatus.PROCESSING);
        // return new ResponseEntity<>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/display_2")
    public ResponseEntity<?> display2(@RequestParam String name,
                                      @RequestParam String place)
    {
        String data=name+ place;
        log.info("Name "+name+" Place "+place+" Data "+data);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("/display_3/{name}/{place}")
    public ResponseEntity<?> display3(@PathVariable String name,
                                      @PathVariable String place) {
        String data = name + place;
        log.info("Name: " + name + " Place: " + place + " Data: " + data);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("/dispHW")
    public ResponseEntity<?> dispHW(@RequestParam String uname,
                                    @RequestParam String pword)
    {
        String user_name= environ.getProperty("username");
        String pass_word=environ.getProperty("password");

        if(uname.equalsIgnoreCase(user_name) && pword.equalsIgnoreCase(pass_word))
        {
            log.info("Login Successfully!! Valid Username and password");
            //return new ResponseEntity<>("Login Successfully!!",HttpStatus.OK);
        }
        else {
            log.info("Login Not Successfully!! Invalid Username or password");
            //return new ResponseEntity<>("Login Not Successfully!!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Null",HttpStatus.OK);
    }


//    @GetMapping("/dispHW_1/{uname}/{pword}")
//    public String dispHW_1(@PathVariable String uname,
//                                    @PathVariable String pword)
//    {
//        String user_name= environ.getProperty("username");
//        String pass_word=environ.getProperty("password");
//
//        if(uname.equalsIgnoreCase(user_name) && pword.equalsIgnoreCase(pass_word))
//        {
//            log.info("Login Successfully!! Valid Username and password");
//            //return new ResponseEntity<>("Login Successfully!!",HttpStatus.OK);
//        }
//        else {
//            log.info("Login Not Successfully!! Invalid Username or password");
//            //return new ResponseEntity<>("Login Not Successfully!!",HttpStatus.OK);
//        }
//        return null;
//    }

    @GetMapping("/dispHW_2/{uname}/{pword}")
    public String dispHW_2(@PathVariable String uname,
                           @PathVariable String pword)
    {
        String user_name= environ.getProperty("username");
        String pass_word=environ.getProperty("password");
        if (uname.equalsIgnoreCase(user_name) && pword.equalsIgnoreCase(pass_word)) {
            log.info("Login Successfully!! Valid Username and password");
            return "Login Successfully!!";
        } else {
            log.info("Login Not Successfully!! Invalid Username or password");
            return "Login Not Successfully!!";
        }
    }

}
