package com.abhi.FileGenerator.service;

import com.abhi.FileGenerator.dto.FileDTO;

import java.io.IOException;


public interface FileGeneratorService {

    void generateFile(FileDTO fileDTO) throws IOException;
}
