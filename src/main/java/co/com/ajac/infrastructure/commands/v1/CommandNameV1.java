package co.com.ajac.infrastructure.commands.v1;

import co.com.ajac.infrastructure.api.commands.CommandName;
import io.vavr.collection.List;
import io.vavr.control.Option;

public enum CommandNameV1 implements CommandName {
    REGISTER_USER("RegisterUser");

    private final String name;

    CommandNameV1(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static Option<CommandNameV1> getCommandName(String name) {
        return List.of(CommandNameV1.values())
          .find(commandName -> commandName.name.equals(name));
    }
}
