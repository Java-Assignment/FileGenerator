package com.abhi.filegenerator.dto;

import com.abhi.filegenerator.common.vo.Daily;
import com.abhi.filegenerator.common.vo.Monthly;
import com.abhi.filegenerator.common.vo.Weekly;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDTO {
    private String fileName;
    private Monthly monthly;
    private Weekly weekly;
    private Daily daily;
}
