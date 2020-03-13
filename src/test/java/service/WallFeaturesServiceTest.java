package service;

import data.MessagesData;
import model.Message;
import model.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WallFeaturesServiceTest {

    @Mock
    private MessagesData messagesData;

    @InjectMocks
    private WallFeatureService wallFeatureService;

    @Before
    public void setUp(){

    }

    @Test
    public void getUserMessagesDataTest() throws IOException {
        User user = new User("test");
        user.setMessages(Arrays.asList(new Message("msg1")));
        //stub
        when(messagesData.getUserData(anyString())).thenReturn(user);

        //call
        String userJson=wallFeatureService.getUserMessagesData(anyString());

        //verify
        verify(messagesData).getUserData(anyString());
        Assert.assertThat("",userJson, Matchers.isA(String.class));
        Assert.assertThat("",userJson, Matchers.notNullValue());
    }

    @Test
    public void addMessageTest() throws IOException {
         //stub
        doNothing().when(messagesData).addMessage(anyString(),anyString());

        //call
        wallFeatureService.addMessage(anyString(),anyString());

        //verify
        verify(messagesData).addMessage(anyString(),anyString());
    }

}
