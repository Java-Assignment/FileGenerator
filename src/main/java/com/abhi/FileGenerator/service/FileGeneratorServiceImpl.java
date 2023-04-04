package com.abhi.FileGenerator.service;

import com.abhi.FileGenerator.dto.FileDTO;
import com.abhi.FileGenerator.externalsvc.AccountSvc;
import com.abhi.FileGenerator.externalsvc.dto.AccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
@Slf4j
public class FileGeneratorServiceImpl implements FileGeneratorService {
    @Autowired
    private AccountSvc accountsvc;

    @Value("${file-report-url}")
    private String file_report_url;

    @Override
    public void generateFile(FileDTO fileDTO) throws IOException {
        List<AccountDTO> accountDTOList = accountsvc.getAccounts();
        System.out.println("Got accountDTOList size: " + accountDTOList.size());
        String filePath = file_report_url + fileDTO.getFileName();
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            Files.delete(path);
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE_NEW)) {
            for (AccountDTO accountDTO : accountDTOList) {
                log.info("the information of the accounts is");
                bufferedWriter.write(accountDTO.toString());
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.flush();
            }
        }
    }

}
