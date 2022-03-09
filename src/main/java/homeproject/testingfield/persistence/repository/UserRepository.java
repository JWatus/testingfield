package homeproject.testingfield.persistence.repository;

import homeproject.testingfield.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByFirstNameAndLastName(String firstName, String lastName);

    void deleteUserEntityByFirstNameAndLastName(String firstName, String lastName);

}
