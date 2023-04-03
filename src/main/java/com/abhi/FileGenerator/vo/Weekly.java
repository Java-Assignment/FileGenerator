package com.abhi.FileGenerator.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weekly {
    private int dayOfWeek;
    private int hour;
    private int minutes;
}
