package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name="SB_Table1")
public class SampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer mark;
    private Double salary;
    private Long phn_no;
    private Date date;
    private Time time;

    @Email(message="Enter valid Mail ID")
    private String mail;
}
