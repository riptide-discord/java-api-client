package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.config.AuthConfig;

import java.net.Authenticator;
import java.net.http.HttpClient;

public class RiptideBuilder {
    @NotNull
    private String url;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Nullable
    private HttpClient.Builder httpClientBuilder;

    private RiptideBuilder(@NotNull String url, @NotNull String username, @NotNull String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static RiptideBuilder create(@NotNull String url, @NotNull String username, @NotNull String password) {
        return new RiptideBuilder(url, username, password);
    }

    public Riptide build() {
        if (this.httpClientBuilder == null)
            this.httpClientBuilder = HttpClient.newBuilder();

        this.httpClientBuilder.authenticator(new AuthConfig(this.username, this.password));

        return new Riptide(this.httpClientBuilder.build(), this.url);
    }
}
