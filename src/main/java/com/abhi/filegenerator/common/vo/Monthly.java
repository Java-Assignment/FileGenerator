package com.abhi.filegenerator.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Monthly {
    private int dayOfMonth;
    private int hour;
    private int minutes;
}
