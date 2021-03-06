package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public WavyUserImpl(@JsonProperty("uuid") @NotNull UUID uuid,
                        @JsonProperty("discordId") long discordId,
                        @JsonProperty("username") @NotNull String username,
                        @JsonProperty("spotifyId") @Nullable String spotifyId,
                        @JsonProperty("spotifyDisplayName") @Nullable String spotifyDisplayName,
                        @JsonProperty("lastUpdate") long lastUpdate) {
        this.uuid = uuid;
        this.discordId = discordId;
        this.username = username;
        this.spotifyId = spotifyId;
        this.spotifyDisplayName = spotifyDisplayName;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public RiptideImpl getRiptide() {
        return this.riptide;
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
