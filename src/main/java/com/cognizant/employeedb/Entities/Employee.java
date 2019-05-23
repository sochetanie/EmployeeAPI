package com.galvanize.employeedb.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@Entity
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ApiModel(description = "All details about the Employee. ")
public class Employee {

    @ApiModelProperty(notes = "The database generated employee ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empID;

    @ApiModelProperty(notes = "The employee name")
    private String name;

    @ApiModelProperty(notes = "The employee address")
    private String address;

    @ApiModelProperty(notes = "The employee address-city")
    private String city;

    @ApiModelProperty(notes = "The employee address-state")
    private String state;

    @ApiModelProperty(notes = "The employee address-zip")
    private String zip;

    @ApiModelProperty(notes = "The employee phone number")
    private String phoneNumber;

    @ApiModelProperty(notes = "The employee job title")
    private String jobTitle;

    @ApiModelProperty(notes = "The employee hire date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;


}
