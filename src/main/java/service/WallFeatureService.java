package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import data.MessagesData;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WallFeatureService {

    @Autowired
    MessagesData messagesData;

    private ObjectMapper mapper;

    public WallFeatureService() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public String getUserMessagesData(String userName) throws IOException {
        User user = messagesData.getUserData(userName);
        String messagesJson = mapper.writeValueAsString(user.getMessages());

        return messagesJson;
    }

    public void addMessage(String user, String msg) throws IOException {
        messagesData.addMessage(user, msg);
    }

}
