package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.Riptide;
import pink.zak.client.wavybot.enums.RiptideStatusCode;
import pink.zak.client.wavybot.requests.ApiResponse;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface User {

    Riptide getRiptide();

    long getDiscordId();

    @NotNull
    UUID getWavyUuid();

    default void retrieveWavyUser(Consumer<WavyUser> successConsumer, Consumer<FailureResponse> failureConsumer) {
        this.getRiptide().retrieveWavyUser(this.getDiscordId(), successConsumer, failureConsumer);
    }

    default void updateListens(Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer) {
        this.getRiptide().updateListens(this.getDiscordId(), successConsumer, failureConsumer);
    }
}
