package com.vinifillos.workshopmongo.resources;

import com.vinifillos.workshopmongo.domain.Post;
import com.vinifillos.workshopmongo.domain.User;
import com.vinifillos.workshopmongo.dto.UserDTO;
import com.vinifillos.workshopmongo.services.PostService;
import com.vinifillos.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
