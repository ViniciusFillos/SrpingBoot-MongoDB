package com.vinifillos.workshopmongo.repository;

import com.vinifillos.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends MongoRepository<Post, String> {
}
