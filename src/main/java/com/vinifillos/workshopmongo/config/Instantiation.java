package com.vinifillos.workshopmongo.config;

import com.vinifillos.workshopmongo.domain.Post;
import com.vinifillos.workshopmongo.domain.User;
import com.vinifillos.workshopmongo.repository.PostRespository;
import com.vinifillos.workshopmongo.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private PostRespository postRespository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRespository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRespository.saveAll(Arrays.asList(maria,alex,bob));

        postRespository.deleteAll();
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
        postRespository.saveAll(Arrays.asList(post1,post2));
    }
}
