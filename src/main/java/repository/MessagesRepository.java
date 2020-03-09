package repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessagesRepository {

    @Getter @Setter
    private Map<String, List<String>> userMessages;

    public MessagesRepository() {

        userMessages=new HashMap<>();
        List<String> Messages = Arrays.asList("Hi, when are we meeting", "How was your day", "I love you");
        userMessages.put("kshama", Messages);

        Messages = Arrays.asList("Will be late", "Remember to pick up Kshama", "I love you");
        userMessages.put("ron", Messages);

        Messages = Arrays.asList("Hey there", "Are you okay?", "see ya tomorrow");
        userMessages.put("jia", Messages);

    }


}
