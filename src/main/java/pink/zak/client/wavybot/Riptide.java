package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.enums.Leaderboard;
import pink.zak.client.wavybot.enums.RiptideStatusCode;
import pink.zak.client.wavybot.models.FailureResponse;
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
import java.util.function.Consumer;

public interface Riptide {

    @NotNull
    HttpClient getHttpClient();

    @NotNull
    String getUrl();

    void retrievePartialLeaderboard(long discordId, @NotNull Leaderboard leaderboard, long start, long end,
                                    Consumer<Map<Long, Tuple<String, Integer>>> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrievePartialLeaderboard(long discordId, @NotNull Leaderboard leaderboard, Consumer<Map<Long, Tuple<String, Integer>>> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveAlbum(String spotifyId, Consumer<Album> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveBulkAlbums(Collection<String> SpotifyIds, Consumer<Map<String, ? extends Album>> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveArtist(String spotifyId, Consumer<Artist> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveBulkArtists(Collection<String> SpotifyIds, Consumer<Map<String, ? extends Artist>> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveTrack(String spotifyId, Consumer<Track> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveBulkTracks(Collection<String> SpotifyIds, Consumer<Map<String, ? extends Track>> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveTask(@NotNull UUID taskId, Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveUser(long discordId, Consumer<User> successConsumer, Consumer<FailureResponse> failureConsumer);

    void retrieveWavyUser(long discordId, Consumer<WavyUser> successConsumer, Consumer<FailureResponse> failureConsumer);

    void linkWavy(long discordId, @NotNull String wavyUsername, Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer);

    void updateListens(long discordId, Consumer<Task> successConsumer, Consumer<FailureResponse> failureConsumer);
}
