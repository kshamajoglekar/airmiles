package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import service.WallFeatureService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class WallFeaturesControllerTest {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private WallFeaturesController wallFeaturesController;

    @Mock
    private WallFeatureService wallFeatureService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(wallFeaturesController)
                .setCustomArgumentResolvers().build();
    }

    @Test
    public void testGetMessage() throws Exception {
        String user = "kshama";

        //stub
        when(wallFeatureService.getUserMessagesData(anyString())).thenReturn("Result");
        //action
        mvc.perform(MockMvcRequestBuilders.get("/user/{user}/messages", user))
                .andDo(print())
                .andExpect(status().isOk());

        //verify
        verify(wallFeatureService, times(1)).getUserMessagesData(user);

    }

    @Test
    public void testAddMessage() throws Exception {
        String user = "kshama";
        String message = "msg";

        //stub
        doNothing().when(wallFeatureService).addMessage(anyString(), anyString());
        when(wallFeatureService.getUserMessagesData(anyString())).thenReturn("Result");

        //action
        mvc.perform(MockMvcRequestBuilders
                .post("/user/{user}/message/add", user)
                .content(message)
                .contentType(MediaType.TEXT_PLAIN_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

        //verify
        verify(wallFeatureService, times(1)).addMessage(user, message);
        verify(wallFeatureService, times(1)).getUserMessagesData(user);

    }
}
