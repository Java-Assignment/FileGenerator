package com.abhi.FileGenerator.service;

import com.abhi.FileGenerator.externalsvc.accountrefsvc.AccountRefSvc;
import com.abhi.FileGenerator.externalsvc.accountrefsvc.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class FileGeneratorServiceImpl implements FileGeneratorService {
    @Autowired
    private AccountRefSvc accountRefSvc;
    @Value("${file-report-url}")
    private String file_report_url;

    @Override
    public String createAcFile(String filename) throws IOException {
        List<AccountDTO> accountDTOList = accountRefSvc.getAccounts();
        String filePath = file_report_url + filename;
        Path path = Paths.get(URI.create(filePath));
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE_NEW)) {
            for (AccountDTO accountDTO : accountDTOList) {
                bufferedWriter.write(accountDTO.toString());
            }

        }
        return filePath;

    }
}
