package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface WavyUser {

    @NotNull
    UUID getUuid();

    long getDiscordId();

    @NotNull
    CompletableFuture<User> retrieveUser();

    @NotNull
    String getUsername();

    @Nullable
    String getSpotifyId();

    @Nullable
    String getSpotifyDisplayName();

    long getLastUpdate();
}
