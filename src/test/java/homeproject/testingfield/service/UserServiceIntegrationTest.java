package homeproject.testingfield.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeproject.testingfield.model.Address;
import homeproject.testingfield.model.User;
import homeproject.testingfield.persistence.converter.UserConverter;
import homeproject.testingfield.persistence.entity.AddressEntity;
import homeproject.testingfield.persistence.entity.UserEntity;
import homeproject.testingfield.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser() {
        //GIVEN
        UserConverter userConverter = new UserConverter(new ObjectMapper());
        UserService userService = new UserService(userRepository, userConverter);

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

        UserEntity entity = new UserEntity(
                1L,
                "Sylvanas",
                "Windrunner",
                "ranger@wow.com",
                new AddressEntity(
                        10L,
                        "Windrunner Spire",
                        "Silvermoon",
                        "Eastern Kingdoms",
                        "11-101"
                )
        );

        //WHEN
        userService.createUser(user);

        //THEN
        UserEntity userFromDb = userRepository.findUserEntityByFirstNameAndLastName("Sylvanas", "Windrunner");
        assertAll(() -> {
                    assertNotNull(userFromDb.getId());
                    assertEquals("Sylvanas", userFromDb.getFirstName());
                    assertEquals("Windrunner", userFromDb.getLastName());
                    assertEquals("ranger@wow.com", userFromDb.getEmail());
                    assertEquals("Windrunner Spire", userFromDb.getAddress().getStreet());
                    assertEquals("Silvermoon", userFromDb.getAddress().getTown());
                    assertEquals("Eastern Kingdoms", userFromDb.getAddress().getCountry());
                    assertEquals("11-101", userFromDb.getAddress().getPostCode());
                }
        );
    }
}