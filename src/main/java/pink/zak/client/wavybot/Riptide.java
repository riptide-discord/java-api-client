package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;

import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

public interface Riptide {

    @NotNull
    HttpClient getHttpClient();

    @NotNull
    String getUrl();

    @NotNull
    CompletableFuture<User> retrieveUser(long discordId);

    @NotNull
    CompletableFuture<WavyUser> retrieveWavyUser(long discordId);
}
