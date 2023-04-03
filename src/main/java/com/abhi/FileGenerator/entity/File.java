package com.abhi.FileGenerator.entity;

import com.abhi.FileGenerator.vo.Daily;
import com.abhi.FileGenerator.vo.Monthly;
import com.abhi.FileGenerator.vo.Weekly;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FileGenerator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    @Id
    private String fileName;
    private Boolean isHourly;
    private Boolean isMonthly;
    private Boolean isWeekly;
    private Boolean isDaily;
    private Monthly monthly;
    private Weekly weekly;
    private Daily daily;

}
