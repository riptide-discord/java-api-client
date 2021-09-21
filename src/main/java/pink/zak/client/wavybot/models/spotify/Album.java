package pink.zak.client.wavybot.models.spotify;

import com.wrapper.spotify.enums.AlbumType;
import com.wrapper.spotify.enums.ReleaseDatePrecision;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.Riptide;
import pink.zak.client.wavybot.enums.RiptideStatusCode;
import pink.zak.client.wavybot.models.FailureResponse;
import pink.zak.client.wavybot.requests.ApiResponse;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface Album {

    Riptide getRiptide();

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    Set<String> getArtistIds();

    default void retrieveArtists(Consumer<Collection<? extends Artist>> successConsumer, Consumer<FailureResponse> failureConsumer) {
        Consumer<Map<String, ? extends Artist>> consumer = map -> successConsumer.accept(map.values());
        this.getRiptide().retrieveBulkArtists(this.getArtistIds(), consumer, failureConsumer);
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
     * @throws IllegalStateException if trackIds is null
     */
    default void retrieveTracks(Consumer<Collection<? extends Track>> successConsumer, Consumer<FailureResponse> failureConsumer) throws IllegalStateException {
        if (this.getTrackIds() == null)
            throw new IllegalStateException("retrieveTracks cannot be called if trackIds is null");

        Consumer<Map<String, ? extends Track>> consumer = map -> successConsumer.accept(map.values());
        this.getRiptide().retrieveBulkTracks(this.getArtistIds(), consumer, failureConsumer);
    }
}
