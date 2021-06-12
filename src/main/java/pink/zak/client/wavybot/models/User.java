package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface User {

    long getDiscordId();

    @NotNull
    UUID getWavyUuid();

    @NotNull
    CompletableFuture<WavyUser> retrieveWavyUser();
}
