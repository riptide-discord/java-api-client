package pink.zak.client.wavybot.models.spotify;

import com.wrapper.spotify.enums.AlbumType;
import com.wrapper.spotify.enums.ReleaseDatePrecision;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.Riptide;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface Album {

    Riptide getRiptide();

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    Set<String> getArtistIds();

    @NotNull
    default CompletableFuture<Collection<? extends Artist>> retrieveArtists() {
        return this.getRiptide().retrieveBulkArtists(this.getArtistIds()).thenApply(Map::values);
    }

    @NotNull
    Set<? extends SpotifyImage> getAlbumImages();

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
    default CompletableFuture<Collection<? extends Track>> retrieveTracks() throws IllegalStateException {
        if (this.getTrackIds() == null)
            throw new IllegalStateException("retrieveTracks cannot be called if trackIds is null");

        return this.getRiptide().retrieveBulkTracks(this.getTrackIds()).thenApply(Map::values);
    }
}
