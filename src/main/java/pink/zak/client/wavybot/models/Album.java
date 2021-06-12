package pink.zak.client.wavybot.models;

import com.wrapper.spotify.enums.AlbumType;
import com.wrapper.spotify.enums.ReleaseDatePrecision;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface Album {

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    Set<String> getArtistIds();

    CompletableFuture<Set<Artist>> retrieveArtists();

    @NotNull
    Set<SpotifyImage> getAlbumImages();

    // below this are only present if the model is enriched from spotify

    long getLastSpotifyUpdate();

    @Nullable
    AlbumType getAlbumType();

    @Nullable
    String getLabel();

    @Nullable
    Date getReleaseDate();

    @Nullable
    ReleaseDatePrecision getReleaseDatePrecision();

    @Nullable
    String[] getGenres();

    @Nullable
    List<String> getTrackIds();

    /**
     * @return Future of the fetched {@link Track} models from the API
     * @throws IllegalStateException if trackIds is null
     */
    @NotNull
    CompletableFuture<List<Track>> retrieveTracks() throws IllegalStateException;
}
