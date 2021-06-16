package pink.zak.client.wavybot.models.spotify;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.Riptide;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface Track {

    Riptide getRiptide();

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    String getAlbumId();

    @NotNull
    default CompletableFuture<Album> retrieveAlbum() {
        return this.getRiptide().retrieveAlbum(this.getAlbumId());
    }

    @NotNull
    Set<String> getArtistIds();

    @NotNull
    default CompletableFuture<Collection<? extends Artist>> retrieveArtists() {
        return this.getRiptide().retrieveBulkArtists(this.getArtistIds()).thenApply(Map::values);
    }

    // below this are only present if the model is enriched from spotify

    long getLastSpotifyUpdate();

    int getDiscNumber();

    int getDurationMs();

    @Nullable
    String getPreviewUrl();

    int getTrackNumber();
}
