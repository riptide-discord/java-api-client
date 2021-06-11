package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.models.WavyUser;

import java.util.UUID;

public class WavyUserImpl implements WavyUser {
    @NotNull
    private final UUID uuid;
    private final long discordId;
    @NotNull
    private final String username;
    @Nullable
    private final String spotifyId;
    @Nullable
    private final String spotifyDisplayName;
    private final long lastUpdate;

    public WavyUserImpl(@NotNull UUID uuid, long discordId, @NotNull String username, @Nullable String spotifyId, @Nullable String spotifyDisplayName, long lastUpdate) {
        this.uuid = uuid;
        this.discordId = discordId;
        this.username = username;
        this.spotifyId = spotifyId;
        this.spotifyDisplayName = spotifyDisplayName;
        this.lastUpdate = lastUpdate;
    }

    @Override
    @NotNull
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public long getDiscordId() {
        return this.discordId;
    }

    @Override
    @NotNull
    public String getUsername() {
        return this.username;
    }

    @Override
    @Nullable
    public String getSpotifyId() {
        return this.spotifyId;
    }

    @Override
    @Nullable
    public String getSpotifyDisplayName() {
        return this.spotifyDisplayName;
    }

    @Override
    public long getLastUpdate() {
        return this.lastUpdate;
    }
}
