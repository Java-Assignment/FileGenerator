package com.abhi.FileGenerator.service;

import com.abhi.FileGenerator.dto.FileDTO;

import java.io.IOException;


public interface FileGeneratorService {

    public String createAcFile(FileDTO fileDTO) throws IOException;

    FileDTO add(FileDTO fileDTO) throws IOException;
}
