package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.enums.Leaderboard;
import pink.zak.client.wavybot.models.FailureResponse;
import pink.zak.client.wavybot.models.Task;
import pink.zak.client.wavybot.models.Tuple;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;
import pink.zak.client.wavybot.models.builder.ModelBuilder;
import pink.zak.client.wavybot.models.spotify.Album;
import pink.zak.client.wavybot.models.spotify.Artist;
import pink.zak.client.wavybot.models.spotify.Track;
import pink.zak.client.wavybot.requests.ApiResponse;
import pink.zak.client.wavybot.requests.Route;
import pink.zak.client.wavybot.utils.Joiner;
import pink.zak.client.wavybot.utils.RequestUtils;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RiptideImpl implements Riptide {
    @NotNull
    private final HttpClient httpClient;
    @NotNull
    private final ModelBuilder modelBuilder = new ModelBuilder(this);
    @NotNull
    private final String url;

    public RiptideImpl(@NotNull HttpClient httpClient, @NotNull String url) {
        this.httpClient = httpClient;
        this.url = url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }

    public static void main(String... args) {
        Riptide riptide = RiptideBuilder.create("http://localhost:8080", "admin", "admin")
            .build();

        riptide.retrievePartialLeaderboard(240721111174610945L, Leaderboard.PERSONAL_TRACKS, System.out::println, null);
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
    public void retrievePartialLeaderboard(long discordId, @NotNull Leaderboard leaderboard, long start, long end,
                                           Consumer<Map<Long, Tuple<String, Integer>>> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Leaderboards.GET_PARTIAL_LEADERBOARD, query -> query
            .addParameter("leaderboard", leaderboard)
            .addParameter("start", start)
            .addParameter("end", end), String.valueOf(discordId));

        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createLeaderboard(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrievePartialLeaderboard(long discordId, @NotNull Leaderboard leaderboard, Consumer<Map<Long, Tuple<String, Integer>>> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Leaderboards.GET_PARTIAL_LEADERBOARD, query -> query.addParameter("leaderboard", leaderboard), String.valueOf(discordId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createLeaderboard(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveAlbum(String spotifyId, Consumer<Album> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_SPOTIFY_ALBUM, query -> query.addParameter("id", spotifyId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createAlbum(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveBulkAlbums(Collection<String> spotifyIds, Consumer<Map<String, ? extends Album>> successConsumer, Consumer<FailureResponse> failureConsumer) {
        String joinedIds = Joiner.join(spotifyIds, ",");
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_BULK_SPOTIFY_ALBUM, parameters -> parameters.addParameter("ids", joinedIds));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createAlbums(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveArtist(String spotifyId, Consumer<Artist> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_SPOTIFY_ARTIST, query -> query.addParameter("id", spotifyId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createArtist(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveBulkArtists(Collection<String> spotifyIds, Consumer<Map<String, ? extends Artist>> successConsumer, Consumer<FailureResponse> failureConsumer) {
        String joinedIds = Joiner.join(spotifyIds, ",");
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_BULK_SPOTIFY_ARTIST, parameters -> parameters.addParameter("ids", joinedIds));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createArtists(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveTrack(String spotifyId, Consumer<Track> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_SPOTIFY_TRACK, query -> query.addParameter("id", spotifyId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createTrack(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveBulkTracks(Collection<String> spotifyIds, Consumer<Map<String, ? extends Track>> successConsumer, Consumer<FailureResponse> failureConsumer) {
        String joinedIds = Joiner.join(spotifyIds, ",");
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_BULK_SPOTIFY_TRACK, parameters -> parameters.addParameter("ids", joinedIds));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createTracks(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveTask(@NotNull UUID taskId, Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Tasks.GET_TASK, taskId.toString());
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createTask(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveUser(long discordId, Consumer<User> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Users.GET_USER, String.valueOf(discordId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createUser(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void retrieveWavyUser(long discordId, Consumer<WavyUser> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Users.GET_WAVY, String.valueOf(discordId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createWavyUser(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void linkWavy(long discordId, @NotNull String wavyUsername, Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Users.LINK_WAVY, query -> query.addParameter("wavyUsername", wavyUsername), String.valueOf(discordId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createTask(response.body()), successConsumer, failureConsumer);
    }

    @Override
    public void updateListens(long discordId, Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Users.UPDATE_LISTENS, String.valueOf(discordId));
        CompletableFuture<HttpResponse<String>> responseFuture = this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        new ApiResponse<>(responseFuture, response -> this.modelBuilder.createTask(response.body()), successConsumer, failureConsumer);
    }
}
