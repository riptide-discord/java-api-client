package pink.zak.client.wavybot.models;

import com.wrapper.spotify.enums.AlbumType;
import com.wrapper.spotify.enums.ReleaseDatePrecision;
import org.jetbrains.annotations.NotNull;

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

    AlbumType getAlbumType();

    String getLabel();

    Date getReleaseDate();

    ReleaseDatePrecision getReleaseDatePrecision();

    String[] getGenres();

    List<String> getTrackIds();
}
