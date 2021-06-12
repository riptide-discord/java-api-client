package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.Album;
import pink.zak.client.wavybot.models.Artist;
import pink.zak.client.wavybot.models.Track;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;

import java.net.http.HttpClient;
import java.util.Collection;
import java.util.Map;
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
}
