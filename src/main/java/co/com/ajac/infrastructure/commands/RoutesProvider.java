package co.com.ajac.infrastructure.commands;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;

import java.util.BitSet;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Component
public class RoutesProvider implements Routes {

    @Override
    public <T extends ServerResponse> RouterFunction<T> endpoints(HandlerFunction<T> handlerFunction) {
        return RouterFunctions.route(
          POST("/v1/commands").and(accept(MediaType.APPLICATION_JSON)), handlerFunction
        );
    }
}
