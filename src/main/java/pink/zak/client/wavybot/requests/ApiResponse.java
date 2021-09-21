package pink.zak.client.wavybot.requests;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.enums.RiptideStatusCode;
import pink.zak.client.wavybot.models.FailureResponse;
import pink.zak.client.wavybot.models.builder.ModelBuilder;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class ApiResponse<V> {
    @NotNull
    private final Function<HttpResponse<String>, V> converter;
    @Nullable
    private final Consumer<V> successConsumer;
    @Nullable
    private final Consumer<FailureResponse> failureConsumer;

    public ApiResponse(@NotNull CompletableFuture<HttpResponse<String>> future, @NotNull Function<HttpResponse<String>, V> converter,
                       @Nullable Consumer<V> successConsumer, @Nullable Consumer<FailureResponse> failureConsumer) {
        this.converter = converter;
        this.successConsumer = successConsumer;
        this.failureConsumer = failureConsumer;

        future.thenAccept(this::handle);
    }

    private void handle(HttpResponse<String> httpResponse) {
        RiptideStatusCode statusCode = RiptideStatusCode.fromCode(httpResponse.statusCode());
        if (statusCode != null && statusCode.isTolerable()) {
            if (this.successConsumer != null) {
                this.successConsumer.accept(this.converter.apply(httpResponse));
            }
        } else if (this.failureConsumer != null) {
            this.failureConsumer.accept(ModelBuilder.createFailureResponse(httpResponse.body()));
        }
    }
}
