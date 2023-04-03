package com.abhi.filegenerator.entity;

import com.abhi.filegenerator.common.Daily;
import com.abhi.filegenerator.common.Monthly;
import com.abhi.filegenerator.common.Weekly;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FileGenerator")
@Data public class File {
        @Id
        private String fileName;
        private Boolean isHourly;
        private Boolean isMonthly;
        private Boolean isWeekly;
        private  Boolean isDaily;
        private Monthly monthly;
        private Weekly weekly;
        private Daily daily;

}
