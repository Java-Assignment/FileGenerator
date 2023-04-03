package com.abhi.FileGenerator.repo;

import com.abhi.FileGenerator.entity.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends MongoRepository<File,String> {

    String findByFileName();
}
