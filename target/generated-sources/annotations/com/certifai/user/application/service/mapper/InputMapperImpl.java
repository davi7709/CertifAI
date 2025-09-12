package com.certifai.user.application.service.mapper;

import com.certifai.user.domain.User;
import com.certifai.user.gateway.presentation.http.resource.UserRequestBody;
import com.certifai.user.gateway.presentation.http.resource.UserResource;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-11T19:25:18-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class InputMapperImpl implements InputMapper {

    @Override
    public User toDomain(UserRequestBody userRequestBody) {
        if ( userRequestBody == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String password = null;

        name = userRequestBody.name();
        email = userRequestBody.email();
        password = userRequestBody.password();

        User user = new User( name, email, password );

        return user;
    }

    @Override
    public UserResource toResource(User user) {
        if ( user == null ) {
            return null;
        }

        String name = null;
        String email = null;

        name = user.name();
        email = user.email();

        UserResource userResource = new UserResource( name, email );

        return userResource;
    }
}
