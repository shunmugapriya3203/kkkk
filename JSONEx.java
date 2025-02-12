package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/JSONEx")
public class JSONEx {

    @Autowired
    private Environment environ;

    @GetMapping("/json1")
    public ResponseEntity<?> Json()
    {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("username","priya");
        jsonObject.put("password","priya");
        jsonObject.put("age",21);
        log.info(jsonObject.toString());
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }
    
    @GetMapping("/json2")
    public ResponseEntity<?> Json2()
    {
        JSONObject json2=new JSONObject();
        String username=environ.getProperty("username");
        String password=environ.getProperty("password");

        JSONObject json3=new JSONObject();
        String mail=environ.getProperty("mail_id");
        String port=environ.getProperty("server.port");

        json2.put("username",username);
        json2.put("password",password);

        json3.put("mail",mail);
        json3.put("port",port);

        //JSON Array
        JSONArray array=new JSONArray();
        array.add(json2);
        array.add(json3);

        JSONObject json4 = new JSONObject();
        json4.put("details",array);
        
        return new ResponseEntity<>(json4,HttpStatus.OK);
    }


    ///
    @GetMapping("/json3")
    public ResponseEntity<?> json3()
    {
        JSONObject jsonObj1=new JSONObject();
        String username=environ.getProperty("username");
        String password=environ.getProperty("password");
        jsonObj1.put("username",username);
        jsonObj1.put("password",password);

        JSONObject jsonObj2=new JSONObject();
        String mail=environ.getProperty("mail");
        String port=environ.getProperty("server.port");
        jsonObj2.put("mail",mail);
        jsonObj2.put("port",port);

        JSONArray jarray1=new JSONArray();
        jarray1.add(jsonObj1);

        JSONArray jarray2=new JSONArray();
        jarray2.add(jsonObj2);

        JSONObject jsonObj3=new JSONObject();
        jsonObj3.put("my_details",jarray1);
        jsonObj3.put("my_db_info",jarray2);

        return new ResponseEntity<>(jsonObj3,HttpStatus.OK);
    }


    @RequestMapping("/list")
    public ResponseEntity<?> ListEx()
    {
        List list= Collections.singletonList(environ.getProperty("course"));
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping("/Array")
    public ResponseEntity<?> ArrayEx()
    {
        String array[] = environ.getProperty("course").split(",");
        return new ResponseEntity<>(array,HttpStatus.OK);
    }

    @RequestMapping("/jsonHW_1")
    public ResponseEntity<?> jsonHW_1()
    {
        String username_2=environ.getProperty("username_2");
        String email_2=environ.getProperty("email_2");

        String username_3=environ.getProperty("username_3");
        String email_3=environ.getProperty("email_3");

        JSONObject json1=new JSONObject();
        json1.put("Name",username_2);
        json1.put("email",email_2);

        JSONObject json2=new JSONObject();
        json2.put("Name",username_3);
        json2.put("email",email_3);

        JSONArray jarray=new JSONArray();
        jarray.add(json1);
        jarray.add(json2);

        return new ResponseEntity<>(jarray,HttpStatus.OK);
    }

    @RequestMapping("/jsonHW_2")
    public ResponseEntity<?> jsonHW_2() {

        String username_1=environ.getProperty("username_1");
        String email_1=environ.getProperty("email_1");

        String username_2=environ.getProperty("username_2");
        String email_2=environ.getProperty("email_2");

        String username_3=environ.getProperty("username_3");
        String email_3=environ.getProperty("email_3");

        JSONObject json1 = new JSONObject();
        json1.put("Name",username_1);
        json1.put("email",email_1);

        JSONObject json2 = new JSONObject();
        json2.put("Name",username_2);
        json2.put("email",email_2);

        JSONObject json3 = new JSONObject();
        json3.put("Name",username_3);
        json3.put("email",email_3);

        JSONArray jarray=new JSONArray();
        jarray.add(json1);
        jarray.add(json2);
        jarray.add(json3);

        JSONObject json4=new JSONObject();
        json4.put("employees",jarray);

        return new ResponseEntity<>(json4,HttpStatus.OK);
    }

    @GetMapping("/jsonHW_3")
    public ResponseEntity<?> jsonHW_3()
    {
        String value_1=environ.getProperty("value_1");
        String onclick_1=environ.getProperty("onclick_1");

        String value_2=environ.getProperty("value_2");
        String onclick_2=environ.getProperty("onclick_2");

        String value_3=environ.getProperty("value_3");
        String onclick_3=environ.getProperty("onclick_3");

        JSONObject json1=new JSONObject();
        json1.put("Value",value_1);
        json1.put("Onclick",onclick_1);

        JSONObject json2=new JSONObject();
        json2.put("Value",value_2);
        json2.put("Onclick",onclick_2);

        JSONObject json3=new JSONObject();
        json3.put("Value",value_3);
        json3.put("Onclick",onclick_3);

        JSONArray jarray_1=new JSONArray();
        jarray_1.add(json1);
        jarray_1.add(json2);
        jarray_1.add(json3);

        JSONObject json4=new JSONObject();
        json4.put("menuitem",jarray_1);

        JSONObject json5=new JSONObject();
        String id=environ.getProperty("id");
        String value=environ.getProperty("value");
        json5.put("id",id);
        json5.put("value",value);
        json5.put("popup",json4);

        JSONObject json6=new JSONObject();
        json6.put("menu",json5);

        return new ResponseEntity<>(json6,HttpStatus.OK);
    }

    @GetMapping("/jsonHW_4")
    public ResponseEntity<?> jsonHW_4()
    {
        String username_1=environ.getProperty("username_1");
        String email_1=environ.getProperty("email_1");

        String username_2=environ.getProperty("username_2");
        String email_2=environ.getProperty("email_2");

        String username_3=environ.getProperty("username_3");
        String email_3=environ.getProperty("email_3");

        JSONObject json1=new JSONObject();
        json1.put("science","pass");
        json1.put("grade","O");

        JSONArray jarray1=new JSONArray();
        jarray1.add(json1);

        JSONObject json_1=new JSONObject();
        json_1.put("name",username_1);
        json_1.put("email",email_1);
        json_1.put("marks",jarray1);

        JSONObject json2=new JSONObject();
        json2.put("maths","pass");
        json2.put("grade","C");

        JSONArray jarray2=new JSONArray();
        jarray2.add(json2);

        JSONObject json_2=new JSONObject();
        json_2.put("name",username_2);
        json_2.put("email",email_2);
        json_2.put("marks",jarray2);

        JSONObject json3=new JSONObject();
        json3.put("english","fail");
        json3.put("grade","A");

        JSONArray jarray3=new JSONArray();
        jarray3.add(json3);

        JSONObject json_3=new JSONObject();
        json_3.put("name",username_3);
        json_3.put("email",email_3);
        json_3.put("marks",jarray3);

        JSONArray array=new JSONArray();
        array.add(json_1);
        array.add(json_2);
        array.add(json_3);

        JSONObject json=new JSONObject();
        json.put("employees",array);

        return new ResponseEntity<>(json,HttpStatus.OK);
    }
}
