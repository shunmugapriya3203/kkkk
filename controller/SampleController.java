package com.example.demo.controller;

import com.example.demo.entity.SampleEntity;
import com.example.demo.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/controller")
public class SampleController {
    @Autowired
    private SampleService service;

    @PostMapping("/insertData")
    public ResponseEntity<?> insertData(@RequestBody SampleEntity sampleEntity)
    {
        log.info(sampleEntity.getFirstName());
        log.info(sampleEntity.getLastName());
        return new ResponseEntity<>(service.serviceData(sampleEntity), HttpStatus.OK);
    }

    @GetMapping("/getData")
    public ResponseEntity<?> read()
    {
        return new ResponseEntity<>(service.readData(),HttpStatus.OK);
    }

    @GetMapping("/getId")
    public ResponseEntity<?> readID(@RequestParam Integer id)
    {
        return new ResponseEntity<>(service.readIdData(id),HttpStatus.OK);
    }

    @GetMapping("/getName")
    public ResponseEntity<?> readName(@RequestParam String fname)
    {
        return new ResponseEntity<>(service.readNameData(fname),HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> countData()
    {
        return new ResponseEntity<>(service.countData(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> delateAllData()
    {
        return new ResponseEntity<>(service.deleteData(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteId")
    public ResponseEntity<?> delateIdData(@RequestParam Integer id)
    {
        return new ResponseEntity<>(service.deleteIdData(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteName")
    public ResponseEntity<?> delateNameData(@RequestParam String firstname)
    {
        return new ResponseEntity<>(service.deleteNameData(firstname),HttpStatus.OK);
    }

    @GetMapping("/countByQuery")
    public ResponseEntity<?> countQuery()
    {
        return new ResponseEntity<>(service.countByQuery(),HttpStatus.OK);
    }

    @GetMapping("/likeOp")
    public ResponseEntity<?> like(@RequestParam String name)
    {
        return service.likeOp(name);
    }

    @GetMapping("/paging1")
    public ResponseEntity<?> paging_1(@RequestParam int searchScope,
                                      @RequestParam int page)
    {
        List status=service.paging1(searchScope,page);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @GetMapping("/paging2")
    public ResponseEntity<?> paging_2(@RequestParam int searchScope,
                                      @RequestParam int page,
                                      @RequestParam String field,
                                      @RequestParam String type)
    {
        log.info("Paging 2");
        return service.paging2(searchScope,page,field,type);
    }
}
