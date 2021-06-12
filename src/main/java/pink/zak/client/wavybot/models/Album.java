package pink.zak.client.wavybot.models;

import com.wrapper.spotify.enums.AlbumType;
import com.wrapper.spotify.enums.ReleaseDatePrecision;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface Album {

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    Set<String> getArtistIds();

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
}
