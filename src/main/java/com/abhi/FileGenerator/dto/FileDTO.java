package com.abhi.FileGenerator.dto;


import lombok.Data;

@Data
public class FileDTO {
    private String fileName;
    private Monthly monthly;
    private Weekly weekly;
    private Daily daily;
    private Hourly hourly;

}
