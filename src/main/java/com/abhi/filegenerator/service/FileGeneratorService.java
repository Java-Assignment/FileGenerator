package com.abhi.filegenerator.service;

import com.abhi.filegenerator.dto.FileDTO;

import java.io.IOException;


public interface FileGeneratorService {

    public String createAcFile(FileDTO fileDTO) throws IOException;

    FileDTO add(FileDTO fileDTO) throws IOException;
}
