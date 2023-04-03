package com.abhi.filegenerator.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weekly {
    private int DayOfWeek;
    private int minutes;

    private int hour;
}

