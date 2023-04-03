package com.abhi.filegenerator.dto;

import com.abhi.filegenerator.common.Daily;
import com.abhi.filegenerator.common.Monthly;
import com.abhi.filegenerator.common.Weekly;
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
