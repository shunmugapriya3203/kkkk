package com.example.demo.service;

import com.example.demo.entity.SampleEntity;
import com.example.demo.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Service

public class SampleService {
    @Autowired
    private SampleRepository repo;

    public ResponseEntity<?> serviceData(SampleEntity sampleEntity)
    {
        log.info(sampleEntity.getFirstName());
        log.info(sampleEntity.getLastName());
        repo.save(sampleEntity);

        JSONObject jobj=new JSONObject();
        jobj.put("Status","User Details inserted successfully");
        log.info(jobj.toString());
        return new ResponseEntity<>(jobj, HttpStatus.OK);
    }

    public ResponseEntity<?> readData()
    {
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> readIdData(int id)
    {
        return new ResponseEntity<>(repo.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<?> readNameData(String fname)
    {
        return new ResponseEntity<>(repo.demo(fname),HttpStatus.OK);
    }

    public ResponseEntity<?> countData()
    {
        return new ResponseEntity<>(repo.count(),HttpStatus.OK);
    }

    public ResponseEntity<?> deleteData()
    {
        repo.deleteAll();
        JSONObject jobj1=new JSONObject();
        jobj1.put("Status","All data are deleted successfully");
        return new ResponseEntity<>(jobj1,HttpStatus.OK);
    }

    public ResponseEntity<?> deleteIdData(int id)
    {
        repo.deleteById(id);
        JSONObject jobj2=new JSONObject();
        jobj2.put("Status","The given ID data are deleted successfully");
        return new ResponseEntity<>(jobj2,HttpStatus.OK);
    }

    public ResponseEntity<?> deleteNameData(String firstname)
    {
        repo.deleteByName(firstname);
        JSONObject jobj3=new JSONObject();
        jobj3.put("Status","The given ID data are deleted successfully");
        return new ResponseEntity<>(jobj3,HttpStatus.OK);
    }

    public ResponseEntity<?> countByQuery()
    {
        int count=repo.countdata();
        JSONObject jobj4=new JSONObject();
        jobj4.put("Count",count);
        return new ResponseEntity<>(jobj4,HttpStatus.OK);
    }

    public ResponseEntity<?> likeOp(String name)
    {
        //return repo.listQuery(name);
        return new ResponseEntity<>(repo.listQuery(name),HttpStatus.OK);
    }

    public List paging1(int searchScope, int page)
    {
        return repo.findAll(PageRequest.of(page-1,searchScope)).getContent();
    }

    public ResponseEntity<?> paging2(int searchScope, int page, String field, String type)
    {
        if(type.equalsIgnoreCase("asc"))
        {
            Pageable pageable=PageRequest.of(page-1,searchScope, Sort.Direction.ASC,field);
            log.info(pageable.toString());
            return new ResponseEntity<>(repo.findAll(pageable).toList(),HttpStatus.OK);
        }
        else{
            Pageable pageable=PageRequest.of(page-1,searchScope, Sort.Direction.DESC,field);
            log.info(pageable.toString());
            return new ResponseEntity<>(repo.findAll(pageable).toList(),HttpStatus.OK);
        }
    }
}
