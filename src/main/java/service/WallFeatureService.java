package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MessagesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WallFeatureService {

    @Autowired
    MessagesRepository messagesRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public String getMasseges(String user) throws JsonProcessingException {

        List<String> mesages = messagesRepository.getUserMessages().get(StringUtils.lowerCase(user));
        String messagesJson = mapper.writeValueAsString(mesages);
        return messagesJson;
    }

    public void addMessage(String user,String msg) throws JsonProcessingException {

        user=StringUtils.lowerCase(user);
        List<String> messages=new ArrayList<>();;

        Map<String,List<String>> userMessages =messagesRepository.getUserMessages();

        if (userMessages.containsKey(user)) {
            messages.addAll(userMessages.get(user));
        }

        messages.add(msg);
        userMessages.put(user,messages);
        messagesRepository.setUserMessages(userMessages);

    }
}
