package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class UserImpl implements User {
    private final long discordId;
    @NotNull
    private final UUID wavyUuid;

    private RiptideImpl riptide;

    public UserImpl(@JsonProperty("discordId") long discordId,
                    @JsonProperty("wavyUuid") @NotNull UUID wavyUuid) {
        this.discordId = discordId;
        this.wavyUuid = wavyUuid;
    }

    @Override
    public RiptideImpl getRiptide() {
        return this.riptide;
    }

    public void setRiptide(RiptideImpl riptide) {
        this.riptide = riptide;
    }

    @Override
    public long getDiscordId() {
        return this.discordId;
    }

    @Override
    @NotNull
    public UUID getWavyUuid() {
        return this.wavyUuid;
    }

    @Override
    public @NotNull CompletableFuture<WavyUser> retrieveWavyUser() {
        return null;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "discordId=" + this.discordId +
                ", wavyUuid=" + this.wavyUuid +
                ", riptide=" + this.riptide +
                '}';
    }
}
