package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.User;

import java.util.UUID;

public class UserImpl implements User {
    private final long discordId;
    @NotNull
    private final UUID wavyUuid;

    public UserImpl(long discordId, @NotNull UUID wavyUuid) {
        this.discordId = discordId;
        this.wavyUuid = wavyUuid;
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
}
