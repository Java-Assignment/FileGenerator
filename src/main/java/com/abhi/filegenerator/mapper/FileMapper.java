package com.abhi.filegenerator.mapper;

import com.abhi.filegenerator.dto.FileDTO;
import com.abhi.filegenerator.entity.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") 
public interface FileMapper {

    File convertFiledtoToFile(FileDTO fileDTO);

    FileDTO convertFileToFileDTO(File file1);
}
