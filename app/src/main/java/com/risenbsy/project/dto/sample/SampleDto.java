package com.risenbsy.project.dto.sample;

/**
 * Created by Vone (codeofshield@gmail.com) on 2016/10/7.
 */

public class SampleDto {

    public SampleDto(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
