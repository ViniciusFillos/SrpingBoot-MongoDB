package com.vinifillos.workshopmongo.services;

import com.vinifillos.workshopmongo.domain.Post;
import com.vinifillos.workshopmongo.repository.PostRespository;
import com.vinifillos.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRespository postRespository;

    public Post findById(String id) {
        Optional<Post> post = postRespository.findById(id);
        if (post.isPresent()) return post.get();
        else throw new ObjectNotFoundException("Objeto não encontrado");
    }

    public List<Post> findByTitle(String title) {
        return postRespository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return  postRespository.fullSearch(text, minDate, maxDate);
    }
}
