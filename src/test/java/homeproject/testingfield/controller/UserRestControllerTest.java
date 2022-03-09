package homeproject.testingfield.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeproject.testingfield.model.Address;
import homeproject.testingfield.model.User;
import homeproject.testingfield.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    void createUser() throws Exception {
        User user = new User(
                "Sylvanas",
                "Windrunner",
                "ranger@wow.com",
                new Address(
                        "Windrunner Spire",
                        "Silvermoon",
                        "Eastern Kingdoms",
                        "11-101"
                )
        );

        when(userService.createUser(any())).thenReturn(user);

        mockMvc.perform(post("/users/create")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Sylvanas")));
    }

}