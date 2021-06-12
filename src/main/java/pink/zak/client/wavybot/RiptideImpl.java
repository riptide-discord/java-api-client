package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;
import pink.zak.client.wavybot.models.builder.ModelBuilder;
import pink.zak.client.wavybot.requests.Route;
import pink.zak.client.wavybot.utils.RequestUtils;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class RiptideImpl implements Riptide {
    @NotNull
    private final HttpClient httpClient;
    @NotNull
    private final ModelBuilder modelBuilder = new ModelBuilder(this);
    @NotNull
    private final String url;

    public RiptideImpl(@NotNull HttpClient httpClient, @NotNull String url) {
        this.httpClient = httpClient;
        this.url = url;
    }

    public static void main(String... args) {
        Riptide riptide = RiptideBuilder.create("http://localhost:8080", "admin", "admin")
                .build();
        System.out.println(Route.Leaderboards.GET_PARTIAL_LEADERBOARD.toUri(riptide.getUrl(), queryParameters -> queryParameters.addParameter("leaderboard", "personal_tracks"),
                "240721111174610945"));

        riptide.retrieveUser(240721111174610945L)
                .thenAccept(System.out::println).join();
    }

    @NotNull
    @Override
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @NotNull
    public ModelBuilder getModelBuilder() {
        return this.modelBuilder;
    }

    @NotNull
    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    @NotNull
    public CompletableFuture<User> retrieveUser(long discordId) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Users.GET_USER, String.valueOf(discordId));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> this.modelBuilder.createUser(response.body()));
    }

    @Override
    @NotNull
    public CompletableFuture<WavyUser> retrieveWavyUser(long discordId) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Users.GET_WAVY, String.valueOf(discordId));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> this.modelBuilder.createWavyUser(response.body()));
    }
}
