package homeproject.testingfield.service;

import homeproject.testingfield.model.User;
import homeproject.testingfield.persistence.converter.UserConverter;
import homeproject.testingfield.persistence.entity.UserEntity;
import homeproject.testingfield.persistence.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Cacheable(cacheNames = "usersCache", key = "#id")
    public User findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return userConverter.convertToUser(userEntity);
    }

    public User findUserByFirstNameAndLastName(String firstName, String lastName) {
        UserEntity userEntity = userRepository.findUserEntityByFirstNameAndLastName(firstName, lastName);
        return userConverter.convertToUser(userEntity);
    }

    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(userConverter::convertToUser).collect(Collectors.toList());
    }

    public User createUser(User user) {
        UserEntity userEntity = userRepository.save(userConverter.convertToUserEntity(user));
        return userConverter.convertToUser(userEntity);
    }

    public User updateUser(User user) {
        UserEntity userEntity = userRepository.save(userConverter.convertToUserEntity(user));
        return userConverter.convertToUser(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void deleteUserByFirstNameAndLastName(String firstName, String lastName) {
        userRepository.deleteUserEntityByFirstNameAndLastName(firstName, lastName);
    }
}
