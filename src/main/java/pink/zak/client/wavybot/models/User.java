package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.Riptide;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface User {

    Riptide getRiptide();

    long getDiscordId();

    @NotNull
    UUID getWavyUuid();

    @NotNull
    default CompletableFuture<WavyUser> retrieveWavyUser() {
        return this.getRiptide().retrieveWavyUser(this.getDiscordId());
    }

    @NotNull
    default CompletableFuture<Task> updateListens() {
        return this.getRiptide().updateListens(this.getDiscordId());
    }
}
