package com.abhi.FileGenerator.controller;

import com.abhi.FileGenerator.dto.FileDTO;
import com.abhi.FileGenerator.exception.AccountFileGenException;
import com.abhi.FileGenerator.service.FileGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileGeneratorControllerImpl implements FileGeneratorController {

    @Autowired
    FileGeneratorService fileGeneratorService;

    @Override
    public ResponseEntity<Void> generateFile(FileDTO fileDTO) throws IOException {
        fileGeneratorService.generateFile(fileDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
