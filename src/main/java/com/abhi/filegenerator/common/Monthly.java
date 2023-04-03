package com.abhi.filegenerator.common;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Monthly {
    private int dayOfMonth;
    private int hour;
    private int minutes;
}
