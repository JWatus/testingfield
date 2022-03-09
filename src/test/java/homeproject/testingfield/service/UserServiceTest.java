package homeproject.testingfield.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeproject.testingfield.model.Address;
import homeproject.testingfield.model.User;
import homeproject.testingfield.persistence.converter.UserConverter;
import homeproject.testingfield.persistence.entity.AddressEntity;
import homeproject.testingfield.persistence.entity.UserEntity;
import homeproject.testingfield.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void createUser() {
        //GIVEN
        UserService userService = new UserService(userRepository, new UserConverter(new ObjectMapper()));

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

        when(userRepository.save(any())).thenReturn(entity);

        //WHEN
        User createdUser = userService.createUser(user);

        //THEN
        assertEquals(user, createdUser);
    }
}