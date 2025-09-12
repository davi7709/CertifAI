package com.certifai.user.application.service.mapper;

import com.certifai.user.domain.User;
import com.certifai.user.gateway.persistence.jpa.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-11T19:25:18-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class OutputMapperImpl implements OutputMapper {

    @Override
    public User toDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String password = null;

        name = userEntity.getName();
        email = userEntity.getEmail();
        password = userEntity.getPassword();

        User user = new User( name, email, password );

        return user;
    }

    @Override
    public UserEntity toEntity(User domain) {
        if ( domain == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName( domain.name() );
        userEntity.setEmail( domain.email() );
        userEntity.setPassword( domain.password() );

        return userEntity;
    }
}
