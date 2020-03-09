package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MessagesRepository;

import java.util.List;

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
}
