package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.WallFeatureService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/")
@RestController
public class WallFeaturesController {

    @Autowired
    public WallFeatureService wallFeatureService;

    @GetMapping("/user/{user}/messages")
    public String getMessage(@PathVariable String user) throws JsonProcessingException {
        return wallFeatureService.getMasseges(user);
    }

    @PostMapping(path = "/user/{user}/message/add")
    public String addMeesage(@PathVariable String user, @RequestBody String message) throws JsonProcessingException {

        wallFeatureService.addMessage(user, message);
        return wallFeatureService.getMasseges(user);
    }

}

