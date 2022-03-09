package homeproject.testingfield.other;

import homeproject.testingfield.persistence.entity.UserEntity;
import homeproject.testingfield.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest()
class SaveAndTransactionalTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void shouldUpdateExistingEntryInDBWithoutSave() {
        UserEntity user = new UserEntity(1L, "Thomas", "Anderson", "neo@gmail.com", null);
        user = userRepository.save(user);

        Long originalId = user.getId();

        // Update using setters
        user.setFirstName("NEO");

        Optional<UserEntity> resultOp = userRepository.findById(originalId);

        assertTrue(resultOp.isPresent());
        UserEntity result = resultOp.get();

        assertEquals(originalId, result.getId());
        assertEquals("NEO", result.getFirstName());
    }

    @Test
    public void shouldNotUpdateExistingEntryInDBWithoutSaveAndTransactional() {
        UserEntity user = new UserEntity(1L, "Thomas", "Anderson", "neo@gmail.com", null);
        user = userRepository.save(user);

        Long originalId = user.getId();

        // Update using setters
        user.setFirstName("NEO");

        Optional<UserEntity> resultOp = userRepository.findById(originalId);

        assertTrue(resultOp.isPresent());
        UserEntity result = resultOp.get();

        assertEquals(originalId, result.getId());
        assertEquals("Thomas", result.getFirstName());
    }

}