package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wrapper.spotify.enums.AlbumType;
import com.wrapper.spotify.enums.ReleaseDatePrecision;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.spotify.Album;
import pink.zak.client.wavybot.models.spotify.SpotifyImage;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AlbumImpl implements Album {
    private final String id;
    private final String name;
    private final Set<String> artistIds;
    private final Set<SpotifyImageImpl> albumImages;
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

    private RiptideImpl riptide;

    public AlbumImpl(@JsonProperty("id") String id,
                     @JsonProperty("name") String name,
                     @JsonProperty("artistIds") Set<String> artistIds,
                     @JsonProperty("albumImages") Set<SpotifyImageImpl> albumImages,
                     @JsonProperty("lastSpotifyUpdate") long lastSpotifyUpdate,
                     @JsonProperty("albumType") @Nullable AlbumType albumType,
                     @JsonProperty("label") @Nullable String label,
                     @JsonProperty("releaseDate") @Nullable Date releaseDate,
                     @JsonProperty("releaseDatePrecision") @Nullable ReleaseDatePrecision releaseDatePrecision,
                     @JsonProperty("genres") @Nullable String[] genres,
                     @JsonProperty("trackIds") @Nullable List<String> trackIds) {
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
    public RiptideImpl getRiptide() {
        return this.riptide;
    }

    public void setRiptide(RiptideImpl riptide) {
        this.riptide = riptide;
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
    public Set<? extends SpotifyImage> getAlbumImages() {
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

    @Override
    public String toString() {
        return "AlbumImpl{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", artistIds=" + this.artistIds +
                ", albumImages=" + this.albumImages +
                ", lastSpotifyUpdate=" + this.lastSpotifyUpdate +
                ", albumType=" + this.albumType +
                ", label='" + this.label + '\'' +
                ", releaseDate=" + this.releaseDate +
                ", releaseDatePrecision=" + this.releaseDatePrecision +
                ", genres=" + Arrays.toString(this.genres) +
                ", trackIds=" + this.trackIds +
                ", riptide=" + this.riptide +
                '}';
    }
}
