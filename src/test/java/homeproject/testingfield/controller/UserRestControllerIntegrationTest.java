package homeproject.testingfield.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeproject.testingfield.model.Address;
import homeproject.testingfield.model.User;
import homeproject.testingfield.persistence.entity.UserEntity;
import homeproject.testingfield.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
class UserRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

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

        mockMvc.perform(post("/users/create")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated());

        UserEntity userEntity = userRepository.findUserEntityByFirstNameAndLastName("Sylvanas", "Windrunner");
        assertAll(() -> {
                    assertNotNull(userEntity.getId());
                    assertEquals("Sylvanas", userEntity.getFirstName());
                    assertEquals("Windrunner", userEntity.getLastName());
                    assertEquals("ranger@wow.com", userEntity.getEmail());
                    assertEquals("Windrunner Spire", userEntity.getAddress().getStreet());
                    assertEquals("Silvermoon", userEntity.getAddress().getTown());
                    assertEquals("Eastern Kingdoms", userEntity.getAddress().getCountry());
                    assertEquals("11-101", userEntity.getAddress().getPostCode());
                }
        );
    }

}