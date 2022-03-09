package homeproject.testingfield.persistence.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeproject.testingfield.model.Address;
import homeproject.testingfield.model.User;
import homeproject.testingfield.persistence.entity.AddressEntity;
import homeproject.testingfield.persistence.entity.UserEntity;
import homeproject.testingfield.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    private final UserConverter userConverter = new UserConverter(new ObjectMapper());

    @BeforeAll
    static void setup() {
        LOGGER.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        LOGGER.info("@BeforeEach - executes before each test method in this class");
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        LOGGER.info("@AfterAll - executed after all test methods.");
    }


    @DisplayName("User conversion from entity test")
    @Test
    void shouldConvertToUser() {
        // GIVEN
        UserEntity userEntity1 = new UserEntity(
                1L,
                "John",
                "Smith",
                "agent@matrix.com",
                new AddressEntity(
                        10L,
                        "Redstreet",
                        "Liverpool",
                        "England",
                        "11-101"
                )
        );

        UserEntity userEntity2 = new UserEntity(
                2L,
                "Johnny",
                "Smith",
                "agent@matrix.com",
                new AddressEntity(
                        11L,
                        "Bluestreet",
                        "Manchester",
                        "England",
                        "11-102"
                )
        );

        // WHEN
        User user1 = userConverter.convertToUser(userEntity1);
        User user2 = userConverter.convertToUser(userEntity2);

        // THEN

        assertAll("users",
                () -> assertEquals(user1, new User(
                        "John",
                        "Smith",
                        "agent@matrix.com",
                        new Address(
                                "Redstreet",
                                "Liverpool",
                                "England",
                                "11-101")
                )),
                () -> assertEquals(user2, new User(
                        "Johnny",
                        "Smith",
                        "agent@matrix.com",
                        new Address(
                                "Bluestreet",
                                "Manchester",
                                "England",
                                "11-102")
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("provideUserToTestConversion")
    void shouldConvertToUserEntity(User user) {
        // WHEN
        UserEntity userEntity = userConverter.convertToUserEntity(user);

        // THEN
        assertEquals(userEntity,
                new UserEntity(null,
                        "Sylvanas",
                        "Windrunner",
                        "ranger@wow.com",
                        new AddressEntity(
                                null,
                                "Windrunner Spire",
                                "Silvermoon",
                                "Eastern Kingdoms",
                                "11-101"
                        )
                )
        );
    }

    private static List<User> provideUserToTestConversion() {
        return List.of(
                new User(
                        "Sylvanas",
                        "Windrunner",
                        "ranger@wow.com",
                        new Address(
                                "Windrunner Spire",
                                "Silvermoon",
                                "Eastern Kingdoms",
                                "11-101"
                        )
                )
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void valueSourceTestExample(int arg) {
        assertTrue(arg > 0);
    }

}