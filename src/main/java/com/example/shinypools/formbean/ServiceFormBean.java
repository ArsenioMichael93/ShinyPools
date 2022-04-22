package com.example.shinypools.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
public class ServiceFormBean {


        private Integer id;


        @NotBlank(message = "Name is required")
        private String name;

        @NotBlank(message = "Description is required")
        private String description;


    }

