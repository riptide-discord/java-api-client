package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface User {

    long getDiscordId();

    @NotNull
    UUID getWavyUuid();
}