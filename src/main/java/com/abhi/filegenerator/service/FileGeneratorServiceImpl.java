package com.abhi.filegenerator.service;

import com.abhi.filegenerator.dto.FileDTO;
import com.abhi.filegenerator.entity.File;
import com.abhi.filegenerator.externalsvc.accountrefsvc.AccountRefSvc;
import com.abhi.filegenerator.externalsvc.accountrefsvc.dto.AccountDTO;
import com.abhi.filegenerator.mapper.FileMapper;
import com.abhi.filegenerator.repo.FileRepo;
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
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private FileRepo fileRepo;
    @Value("${file-report-url}")
    private String file_report_url;

    @Override
    public String createAcFile(FileDTO fileDTO) throws IOException {
        List<AccountDTO> accountDTOList = accountRefSvc.getAccounts();
        String filePath = file_report_url +fileDTO.getFileName() ;
        Path path = Paths.get(URI.create(filePath));
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE_NEW)) {
            for (AccountDTO accountDTO : accountDTOList) {
                bufferedWriter.write(accountDTO.toString());
            }

        }
        return filePath;

    }

    @Override
    public FileDTO add(FileDTO fileDTO) throws IOException {
        File file=fileMapper.convertFiledtoToFile(fileDTO);
        File file1=fileRepo.save(file);
        return  fileMapper.convertFileToFileDTO(file1);
    }
}
