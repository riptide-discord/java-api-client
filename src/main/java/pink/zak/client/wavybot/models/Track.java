package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface Track {
    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    String getAlbumId();

    @NotNull
    CompletableFuture<Album> retrieveAlbum();

    @NotNull
    Set<String> getArtistIds();

    @NotNull
    CompletableFuture<Set<String>> retrieveArtists();

    // below this are only present if the model is enriched from spotify

    long getLastSpotifyUpdate();

    int getDiscNumber();

    int getDurationMs();

    @Nullable
    String getPreviewUrl();

    int getTrackNumber();
}
