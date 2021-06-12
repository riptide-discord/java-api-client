package pink.zak.client.wavybot.models.impl;

import com.wrapper.spotify.enums.AlbumType;
import com.wrapper.spotify.enums.ReleaseDatePrecision;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.models.Album;
import pink.zak.client.wavybot.models.SpotifyImage;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class AlbumImpl implements Album {
    private final String id;
    private final String name;
    private final Set<String> artistIds;
    private final Set<SpotifyImage> albumImages;
    private final long lastSpotifyUpdate;

    @Nullable
    private final AlbumType albumType;
    @Nullable
    private final String label;
    @Nullable
    private final Date releaseDate;
    @Nullable
    private final ReleaseDatePrecision releaseDatePrecision;
    @Nullable
    private final String[] genres;
    @Nullable
    private final List<String> trackIds;

    public AlbumImpl(String id, String name, Set<String> artistIds, Set<SpotifyImage> albumImages,
                     long lastSpotifyUpdate, @Nullable AlbumType albumType, @Nullable String label, @Nullable Date releaseDate,
                     @Nullable ReleaseDatePrecision releaseDatePrecision, @Nullable String[] genres, @Nullable List<String> trackIds) {
        this.id = id;
        this.name = name;
        this.artistIds = artistIds;
        this.albumImages = albumImages;
        this.lastSpotifyUpdate = lastSpotifyUpdate;
        this.albumType = albumType;
        this.label = label;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.genres = genres;
        this.trackIds = trackIds;
    }

    @Override
    @NotNull
    public String getId() {
        return this.id;
    }

    @Override
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override
    @NotNull
    public Set<String> getArtistIds() {
        return this.artistIds;
    }

    @Override
    @NotNull
    public Set<SpotifyImage> getAlbumImages() {
        return this.albumImages;
    }

    @Override
    public long getLastSpotifyUpdate() {
        return this.lastSpotifyUpdate;
    }

    @Override
    @Nullable
    public AlbumType getAlbumType() {
        return this.albumType;
    }

    @Override
    @Nullable
    public String getLabel() {
        return this.label;
    }

    @Override
    @Nullable
    public Date getReleaseDate() {
        return this.releaseDate;
    }

    @Override
    @Nullable
    public ReleaseDatePrecision getReleaseDatePrecision() {
        return this.releaseDatePrecision;
    }

    @Override
    @Nullable
    public String[] getGenres() {
        return this.genres;
    }

    @Override
    @Nullable
    public List<String> getTrackIds() {
        return this.trackIds;
    }
}
