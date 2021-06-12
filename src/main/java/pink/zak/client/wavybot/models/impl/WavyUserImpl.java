package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

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

    private RiptideImpl riptide;

    public WavyUserImpl(@NotNull UUID uuid, long discordId, @NotNull String username, @Nullable String spotifyId,
                        @Nullable String spotifyDisplayName, long lastUpdate) {
        this.uuid = uuid;
        this.discordId = discordId;
        this.username = username;
        this.spotifyId = spotifyId;
        this.spotifyDisplayName = spotifyDisplayName;
        this.lastUpdate = lastUpdate;
    }

    public void setRiptide(RiptideImpl riptide) {
        this.riptide = riptide;
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
    public @NotNull CompletableFuture<User> retrieveUser() {
        return null;
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

    @Override
    public String toString() {
        return "WavyUserImpl{" +
                "uuid=" + this.uuid +
                ", discordId=" + this.discordId +
                ", username='" + this.username + '\'' +
                ", spotifyId='" + this.spotifyId + '\'' +
                ", spotifyDisplayName='" + this.spotifyDisplayName + '\'' +
                ", lastUpdate=" + this.lastUpdate +
                ", riptide=" + this.riptide +
                '}';
    }
}
