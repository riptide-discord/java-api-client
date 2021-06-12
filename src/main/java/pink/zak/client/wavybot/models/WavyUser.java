package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.Riptide;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface WavyUser {

    Riptide getRiptide();

    @NotNull
    UUID getUuid();

    long getDiscordId();

    @NotNull
    default CompletableFuture<User> retrieveUser() {
        return this.getRiptide().retrieveUser(this.getDiscordId());
    }

    @NotNull
    String getUsername();

    @Nullable
    String getSpotifyId();

    @Nullable
    String getSpotifyDisplayName();

    long getLastUpdate();
}
