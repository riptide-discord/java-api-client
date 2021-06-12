package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.Album;
import pink.zak.client.wavybot.models.Artist;
import pink.zak.client.wavybot.models.Track;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;
import pink.zak.client.wavybot.models.builder.ModelBuilder;
import pink.zak.client.wavybot.requests.Route;
import pink.zak.client.wavybot.utils.Joiner;
import pink.zak.client.wavybot.utils.RequestUtils;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Map;
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

        long time = System.currentTimeMillis();
        riptide.retrieveUser(240721111174610945L)
                .thenAccept(System.out::println).join();

        riptide.retrieveAlbum("0kNUDDHwjpemplDqSZ72Ct")
                .thenApply(album -> {
                    System.out.println(album);
                    return album;
                })
                .thenAccept(album -> {
                    album.retrieveArtists()
                            .thenAccept(System.out::println)
                            .join();
                }).join();

        riptide.retrieveTrack("2kONpeXXK70YEs7c0UQbmq")
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

    @Override
    @NotNull
    public CompletableFuture<Album> retrieveAlbum(String spotifyId) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_SPOTIFY_ALBUM, query -> query.addParameter("id", spotifyId));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> this.modelBuilder.createAlbum(response.body()));
    }

    @Override
    @NotNull
    public CompletableFuture<Map<String, ? extends Album>> retrieveBulkAlbums(Collection<String> spotifyIds) {
        String joinedIds = Joiner.join(spotifyIds, ",");
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_BULK_SPOTIFY_ALBUM, parameters -> parameters.addParameter("ids", joinedIds));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> {
            return this.modelBuilder.createAlbums(response.body());
        });
    }

    @Override
    @NotNull
    public CompletableFuture<Artist> retrieveArtist(String spotifyId) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_SPOTIFY_ARTIST, query -> query.addParameter("id", spotifyId));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> this.modelBuilder.createArtist(response.body()));
    }

    @Override
    @NotNull
    public CompletableFuture<Map<String, ? extends Artist>> retrieveBulkArtists(Collection<String> spotifyIds) {
        String joinedIds = Joiner.join(spotifyIds, ",");
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_BULK_SPOTIFY_ARTIST, parameters -> parameters.addParameter("ids", joinedIds));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> {
            return this.modelBuilder.createArtists(response.body());
        });
    }

    @Override
    @NotNull
    public CompletableFuture<Track> retrieveTrack(String spotifyId) {
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_SPOTIFY_TRACK, query -> query.addParameter("id", spotifyId));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> this.modelBuilder.createTrack(response.body()));
    }

    @Override
    @NotNull
    public CompletableFuture<Map<String, ? extends Track>> retrieveBulkTracks(Collection<String> spotifyIds) {
        String joinedIds = Joiner.join(spotifyIds, ",");
        HttpRequest request = RequestUtils.createRequest(this, Route.Spotify.GET_BULK_SPOTIFY_TRACK, parameters -> parameters.addParameter("ids", joinedIds));
        return this.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> {
            return this.modelBuilder.createTracks(response.body());
        });
    }
}
