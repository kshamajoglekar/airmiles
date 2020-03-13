package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.WallFeatureService;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/")
@RestController
public class WallFeaturesController {

    @Autowired
    public WallFeatureService wallFeatureService;

    /**
     * API: This APi provides the <code>User</code> data provided the name of user
     * @param user : user name
     * @return User data json
     * @throws IOException
     */
    @GetMapping(value = "/user/{user}/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage(@PathVariable final String user) throws IOException {
        return wallFeatureService.getUserMessagesData(user);
    }


    @PostMapping(path = "/user/{user}/message/add", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addMeesage(@PathVariable final String user, @RequestBody String message) throws IOException {

        wallFeatureService.addMessage(user, message);
        return wallFeatureService.getUserMessagesData(user);
    }

}

