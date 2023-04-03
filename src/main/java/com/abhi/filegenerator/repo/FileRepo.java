package com.abhi.filegenerator.repo;

import com.abhi.filegenerator.entity.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends MongoRepository<File,String> {

    String findByFileName();
}
