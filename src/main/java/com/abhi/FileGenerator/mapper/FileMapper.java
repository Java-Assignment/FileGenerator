package com.abhi.FileGenerator.mapper;

import com.abhi.FileGenerator.dto.FileDTO;
import com.abhi.FileGenerator.entity.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") 
public interface FileMapper {

    File convertFiledtoToFile(FileDTO fileDTO);

    FileDTO convertFileToFileDTO(File file1);
}
