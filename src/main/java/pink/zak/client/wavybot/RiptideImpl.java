package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.requests.Route;

import java.net.http.HttpClient;

public class RiptideImpl implements Riptide {
    @NotNull
    private final HttpClient httpClient;
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
    }

    @NotNull
    @Override
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @NotNull
    @Override
    public String getUrl() {
        return this.url;
    }
}
