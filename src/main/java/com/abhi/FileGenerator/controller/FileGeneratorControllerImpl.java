package com.abhi.FileGenerator.controller;

import com.abhi.FileGenerator.exception.AccoutFileGenException;
import com.abhi.FileGenerator.service.FileGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
@Slf4j
public class FileGeneratorControllerImpl implements FileGeneratorController {

    @Autowired
    private FileGeneratorService fileGeneratorService;

    @Override
    public ResponseEntity<Object> createAcFile(String Filename) throws AccoutFileGenException {
        try {
            String acFile = fileGeneratorService.createAcFile(Filename);
            String[] split = acFile.split("/");
            String fileName = split[split.length - 1];
            Path path = Paths.get("file://" + acFile);
            InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ);
            InputStreamResource resource = new InputStreamResource(inputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CACHE_CONTROL, "no-cache,no-store,must-revalidate");
            headers.add(HttpHeaders.PRAGMA, "no-cache");
            headers.add(HttpHeaders.EXPIRES, "0");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\"");
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);


        } catch (IOException e) {
            String msg = "Account file creation failed";
            log.error(msg);
            throw new AccoutFileGenException(msg);
        }
    }
}
