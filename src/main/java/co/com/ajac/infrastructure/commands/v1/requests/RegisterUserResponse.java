package co.com.ajac.infrastructure.commands.v1.requests;

import co.com.ajac.infrastructure.api.commands.Response;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterUserResponse implements Response {
    private final String name;
}
