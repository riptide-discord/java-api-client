package pink.zak.client.wavybot.models.spotify;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.Riptide;
import pink.zak.client.wavybot.enums.RiptideStatusCode;
import pink.zak.client.wavybot.models.FailureResponse;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public interface Track {

    Riptide getRiptide();

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    String getAlbumId();

    default void retrieveAlbum(Consumer<Album> successConsumer, Consumer<FailureResponse> failureConsumer) {
        this.getRiptide().retrieveAlbum(this.getAlbumId(), successConsumer, failureConsumer);
    }

    @NotNull
    Set<String> getArtistIds();

    default void retrieveArtists(Consumer<Collection<? extends Artist>> successConsumer, Consumer<FailureResponse> failureConsumer) {
        Consumer<Map<String, ? extends Artist>> consumer = map -> successConsumer.accept(map.values());
        this.getRiptide().retrieveBulkArtists(this.getArtistIds(), consumer, failureConsumer);
    }

    // below this are only present if the model is enriched from spotify

    long getLastSpotifyUpdate();

    int getDiscNumber();

    int getDurationMs();

    @Nullable
    String getPreviewUrl();

    int getTrackNumber();
}
