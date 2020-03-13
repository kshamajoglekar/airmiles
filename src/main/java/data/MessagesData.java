package data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import model.Message;
import model.User;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
public class MessagesData {

    private ObjectMapper mapper;

    public MessagesData() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }


    public User getUserData(String userName) throws IOException {
        Set<User> users = loadUsers();

        User userResult = users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .findFirst()
                .orElse(new User(userName));
        users.add(userResult);
        saveUsers(users);
        return userResult;
    }

    public Set<User> loadUsers() throws IOException {
        return mapper.readValue(new File(getClass().getClassLoader().getResource("Users.json").getFile()), new TypeReference<Set<User>>() {
        });
    }

    private void saveUsers(Set<User> users) throws IOException {
        mapper.writeValue(new File(getClass().getClassLoader().getResource("Users.json").getFile()), users);
    }

    public List<Message> addMessage(String userName, String message) throws IOException {
        Set<User> users = loadUsers();

        User userResult = users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .findFirst()
                .get();

        List<Message> messages = userResult.getMessages();
        messages.add(new Message(message));
        userResult.setMessages(messages);

        users.add(userResult);
        saveUsers(users);

        return messages;
    }
}
