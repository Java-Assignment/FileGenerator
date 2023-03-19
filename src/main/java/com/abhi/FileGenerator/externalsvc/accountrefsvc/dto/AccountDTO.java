package com.abhi.FileGenerator.externalsvc.accountrefsvc.dto;

import com.abhi.FileGenerator.common.vo.AccountStatus;
import com.abhi.FileGenerator.common.vo.AccountType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
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
