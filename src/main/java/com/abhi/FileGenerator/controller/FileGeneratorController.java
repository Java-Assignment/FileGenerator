package com.abhi.FileGenerator.controller;

import com.abhi.FileGenerator.dto.FileDTO;
import com.abhi.FileGenerator.exception.AccountFileGenException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping(value = "/files", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
@Tag(name = "File Generation API", description = "API for all filegeneration related operations")
public interface FileGeneratorController {

    @PostMapping
    @Operation(summary = "Save file config in database")
    ResponseEntity<FileDTO> add(@RequestBody @Valid FileDTO fileDTO) throws IOException, AccountFileGenException;




    @GetMapping("/file")
    @Operation(summary = "File generation API")
    ResponseEntity<Object> generateFile(FileDTO fileDTO1) throws  AccountFileGenException;
}
