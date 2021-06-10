package pink.zak.client.wavybot.requests;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.http.HttpRequest;
import java.util.function.BiConsumer;

public enum Method {
    GET((bodyPublisher, builder) -> builder.GET()),
    POST((bodyPublisher, builder) -> builder.POST(bodyPublisher));

    private final BiConsumer<HttpRequest.BodyPublisher, HttpRequest.Builder> builderConsumer;

    Method(BiConsumer<HttpRequest.BodyPublisher, HttpRequest.Builder> builderConsumer) {
        this.builderConsumer = builderConsumer;
    }

    public HttpRequest.Builder apply(@NotNull HttpRequest.Builder builder, @Nullable HttpRequest.BodyPublisher bodyPublisher) {
        this.builderConsumer.accept(bodyPublisher, builder);
        return builder;
    }
}
