package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.Riptide;
import pink.zak.client.wavybot.enums.RiptideStatusCode;
import pink.zak.client.wavybot.requests.ApiResponse;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface WavyUser {

    Riptide getRiptide();

    @NotNull
    UUID getUuid();

    long getDiscordId();

    default void retrieveWavyUser(Consumer<User> successConsumer, Consumer<FailureResponse> failureConsumer) {
        this.getRiptide().retrieveUser(this.getDiscordId(), successConsumer, failureConsumer);
    }

    default void updateListens(Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer) {
        this.getRiptide().updateListens(this.getDiscordId(), successConsumer, failureConsumer);
    }

    @NotNull
    String getUsername();

    @Nullable
    String getSpotifyId();

    @Nullable
    String getSpotifyDisplayName();

    long getLastUpdate();
}
