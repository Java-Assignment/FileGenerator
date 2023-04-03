package com.abhi.FileGenerator.dto;


import com.abhi.FileGenerator.vo.Daily;
import com.abhi.FileGenerator.vo.Monthly;
import com.abhi.FileGenerator.vo.Weekly;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDTO {
    private String fileName;
    private Boolean isHourly;
    private Boolean isMonthly;
    private Boolean isWeekly;
    private  Boolean isDaily;
    private Monthly monthly;
    private Weekly weekly;
    private Daily daily;
}
