package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.WallFeatureService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/")
@RestController
public class WallFeaturesController {

    @Autowired
    public WallFeatureService wallFeatureService;

    @RequestMapping("/posts/{user}")
    public String getPosts(@PathVariable String user) throws JsonProcessingException {
        System.out.println(user+"--");
        //return "Greetings from Spring Boot!";
        return wallFeatureService.getMasseges(user);
    }


}

