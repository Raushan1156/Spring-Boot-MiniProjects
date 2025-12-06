package com.codingshuttle.week2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private int age;
    private LocalDate dateOfJoining;
    @JsonProperty ("isActive")
    private boolean isActive;

//    public Employee() {
//    }
//
//    public Employee(Long id, String name, int age, LocalDate dateOfJoining, boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }

//    public boolean getisActive() {
//        return isActive;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setisActive(boolean active) {
//        isActive = active;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
