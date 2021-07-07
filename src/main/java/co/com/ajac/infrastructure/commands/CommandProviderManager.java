package co.com.ajac.infrastructure.commands;

import co.com.ajac.infrastructure.api.commands.CommandProvider;
import co.com.ajac.infrastructure.api.commands.ProviderManager;
import co.com.ajac.infrastructure.commands.v1.CommandProviderV1;
import io.vavr.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandProviderManager implements ProviderManager {

    private final List<CommandProvider> commandProviders;

    @Autowired
    public CommandProviderManager(CommandProviderV1 commandProviderV1) {
        commandProviders = List.of(commandProviderV1);
    }

    @Override
    public List<CommandProvider> getCommandProviders() {
        return commandProviders;
    }
}
