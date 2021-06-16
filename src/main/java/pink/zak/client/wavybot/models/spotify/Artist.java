package pink.zak.client.wavybot.models.spotify;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.Riptide;

import java.util.Set;

public interface Artist {

    Riptide getRiptide();

    @NotNull
    String getId();

    @NotNull
    String getName();

    // below this are only present if the model is enriched from spotify

    long getLastSpotifyUpdate();

    @Nullable
    Set<? extends SpotifyImage> getArtistImages();

    @Nullable
    String[] getGenre();
}
