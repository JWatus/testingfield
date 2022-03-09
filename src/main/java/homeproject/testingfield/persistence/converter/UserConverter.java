package homeproject.testingfield.persistence.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeproject.testingfield.model.User;
import homeproject.testingfield.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final ObjectMapper mapper;

    public UserConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public User convertToUser(UserEntity userEntity) {
        return mapper.convertValue(userEntity, User.class);
    }

    public UserEntity convertToUserEntity(User user) {
        return mapper.convertValue(user, UserEntity.class);
    }
}
