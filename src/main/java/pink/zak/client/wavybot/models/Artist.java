package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public interface Artist {
    @NotNull
    String getId();

    @NotNull
    String getName();

    // below this are only present if the model is enriched from spotify

    long getLastSpotifyUpdate();

    @Nullable
    Set<SpotifyImage> getArtistImages();

    @Nullable
    String[] getGenre();
}
