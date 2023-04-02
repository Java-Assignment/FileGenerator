package com.abhi.filegenerator.externalsvc.accountrefsvc.dto;

import com.abhi.filegenerator.common.vo.AccountStatus;
import com.abhi.filegenerator.common.vo.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class AccountDTO {
    private String accountId;
    private AccountType accountType;
    private String customerName;
    private List<String> notes;
    private AccountStatus accountStatus;
    private String region;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createDate;

}
