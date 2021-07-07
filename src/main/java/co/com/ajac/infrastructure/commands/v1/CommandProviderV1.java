package co.com.ajac.infrastructure.commands.v1;

import co.com.ajac.infrastructure.api.commands.Command;
import co.com.ajac.infrastructure.api.commands.CommandProvider;
import co.com.ajac.infrastructure.api.commands.Request;
import co.com.ajac.infrastructure.commands.v1.requests.RegisterUserRequest;
import co.com.ajac.infrastructure.commands.v1.requests.RegisterUserCommand;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandProviderV1 extends CommandProvider {

    @Autowired
    public CommandProviderV1(RegisterUserCommand registerUserCommand) {
        this.version = "v1";
        this.commands = HashMap.of(CommandNameV1.REGISTER_USER, Tuple.of(registerUserCommand, new RegisterUserRequest()));
    }

    @Override
    public Option<Command> provide(String nombreComando) {
        return CommandNameV1.getCommandName(nombreComando)
          .flatMap(commands::get)
          .map(Tuple2::_1);
    }

    @Override
    public Try<Request> deserialize(JsonNode comandoBody, String nombreComando) {
        return CommandNameV1.getCommandName(nombreComando)
          .flatMap(commands::get)
          .map(Tuple2::_2)
          .toTry()
          .flatMap(request -> Try.of(() -> new ObjectMapper().readValue(comandoBody.toPrettyString(), request.getClass())));
    }
}
