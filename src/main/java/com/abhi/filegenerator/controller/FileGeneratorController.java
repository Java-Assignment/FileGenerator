package com.abhi.filegenerator.controller;

import com.abhi.filegenerator.dto.FileDTO;
import com.abhi.filegenerator.exception.AccoutFileGenException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/file", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
@Tag(name = "File Generation API", description = "API for all filegeneration related operations")
public interface FileGeneratorController {
    @PostMapping
    @Operation(summary = "File generation API")
    ResponseEntity<Object> createAcFile(@RequestBody @Valid FileDTO fileDTO) throws AccoutFileGenException;
}
