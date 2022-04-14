package co.com.ajac.infrastructure.commands.v1.requests;

import co.com.ajac.base.errors.AppError;
import co.com.ajac.base.events.Event;
import co.com.ajac.concurrency.FutureEither;
import co.com.ajac.infrastructure.api.commands.Command;
import co.com.ajac.infrastructure.api.commands.Request;
import co.com.ajac.infrastructure.api.commands.Response;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command {

    @Override
    public FutureEither<AppError, Tuple2<Option<Response>, List<Event>>> execute(Request request) {
        final RegisterUserRequest registerUserRequest = (RegisterUserRequest) request;
        final RegisterUserResponse registerUserResponse = new RegisterUserResponse(registerUserRequest.getName());
        return FutureEither.right(Tuple.of(Option.of(registerUserResponse), List.empty()));
    }
}
