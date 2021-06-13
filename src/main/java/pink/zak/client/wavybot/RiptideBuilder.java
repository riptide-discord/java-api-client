package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.config.AuthConfig;

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

    @NotNull
    public Riptide build() {
        if (this.httpClientBuilder == null)
            this.httpClientBuilder = HttpClient.newBuilder();

        this.httpClientBuilder.authenticator(new AuthConfig(this.username, this.password));

        return new RiptideImpl(this.httpClientBuilder.build(), this.url);
    }

    public void setUrl(@NotNull String url) {
        this.url = url;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public void setHttpClientBuilder(@Nullable HttpClient.Builder httpClientBuilder) {
        this.httpClientBuilder = httpClientBuilder;
    }
}
