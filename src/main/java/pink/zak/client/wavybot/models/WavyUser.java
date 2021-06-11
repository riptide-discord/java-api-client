package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface WavyUser {

    @NotNull
    UUID getUuid();

    long getDiscordId();

    @NotNull
    String getUsername();

    @Nullable
    String getSpotifyId();

    @Nullable
    String getSpotifyDisplayName();

    long getLastUpdate();
}
