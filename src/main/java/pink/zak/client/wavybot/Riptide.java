package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.enums.Leaderboard;
import pink.zak.client.wavybot.models.Task;
import pink.zak.client.wavybot.models.Tuple;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;
import pink.zak.client.wavybot.models.spotify.Album;
import pink.zak.client.wavybot.models.spotify.Artist;
import pink.zak.client.wavybot.models.spotify.Track;

import java.net.http.HttpClient;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface Riptide {

    @NotNull
    HttpClient getHttpClient();

    @NotNull
    String getUrl();

    @NotNull
    CompletableFuture<Map<Long, Tuple<String, Integer>>> retrievePartialLeaderboard(long discordId, @NotNull Leaderboard leaderboard, long start, long end);

    @NotNull
    CompletableFuture<Map<Long, Tuple<String, Integer>>> retrievePartialLeaderboard(long discordId, @NotNull Leaderboard leaderboard);

    @NotNull
    CompletableFuture<Album> retrieveAlbum(String spotifyId);

    @NotNull
    CompletableFuture<Map<String, ? extends Album>> retrieveBulkAlbums(Collection<String> SpotifyIds);

    @NotNull
    CompletableFuture<Artist> retrieveArtist(String spotifyId);

    @NotNull
    CompletableFuture<Map<String, ? extends Artist>> retrieveBulkArtists(Collection<String> SpotifyIds);

    @NotNull
    CompletableFuture<Track> retrieveTrack(String spotifyId);

    @NotNull
    CompletableFuture<Map<String, ? extends Track>> retrieveBulkTracks(Collection<String> SpotifyIds);

    @NotNull
    CompletableFuture<Task> retrieveTask(@NotNull UUID taskId);

    @NotNull
    CompletableFuture<User> retrieveUser(long discordId);

    @NotNull
    CompletableFuture<WavyUser> retrieveWavyUser(long discordId);

    @NotNull
    CompletableFuture<Task> linkWavy(long discordId, @NotNull String wavyUsername);

    @NotNull
    CompletableFuture<Task> updateListens(long discordId);
}
