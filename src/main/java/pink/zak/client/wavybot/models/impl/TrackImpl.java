package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.spotify.Album;
import pink.zak.client.wavybot.models.spotify.Track;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TrackImpl implements Track {
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    @NotNull
    private final String albumId;
    @NotNull
    private final Set<String> artistIds;
    private final long lastSpotifyUpdate;

    private final int discNumber;
    private final int durationMs;
    @Nullable
    private final String previewUrl;
    private final int trackNumber;

    private RiptideImpl riptide;

    public TrackImpl(@JsonProperty("id") @NotNull String id,
                     @JsonProperty("name") @NotNull String name,
                     @JsonProperty("albumId") @NotNull String albumId,
                     @JsonProperty("artistIds") @NotNull Set<String> artistIds,
                     @JsonProperty("lastSpotifyUpdate") long lastSpotifyUpdate,
                     @JsonProperty("discNumber") int discNumber,
                     @JsonProperty("durationMs") int durationMs,
                     @JsonProperty("previewUrl") @Nullable String previewUrl,
                     @JsonProperty("trackNumber") int trackNumber) {
        this.id = id;
        this.name = name;
        this.albumId = albumId;
        this.artistIds = artistIds;
        this.lastSpotifyUpdate = lastSpotifyUpdate;
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.previewUrl = previewUrl;
        this.trackNumber = trackNumber;
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
    public String getAlbumId() {
        return this.albumId;
    }

    @Override
    public @NotNull CompletableFuture<Album> retrieveAlbum() {
        return null;
    }

    @Override
    public @NotNull Set<String> getArtistIds() {
        return this.artistIds;
    }

    @Override
    public long getLastSpotifyUpdate() {
        return this.lastSpotifyUpdate;
    }

    @Override
    public int getDiscNumber() {
        return this.discNumber;
    }

    @Override
    public int getDurationMs() {
        return this.durationMs;
    }

    @Override
    public @Nullable String getPreviewUrl() {
        return this.previewUrl;
    }

    @Override
    public int getTrackNumber() {
        return this.trackNumber;
    }

    @Override
    public String toString() {
        return "TrackImpl{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", albumId='" + this.albumId + '\'' +
                ", artistIds=" + this.artistIds +
                ", lastSpotifyUpdate=" + this.lastSpotifyUpdate +
                ", discNumber=" + this.discNumber +
                ", durationMs=" + this.durationMs +
                ", previewUrl='" + this.previewUrl + '\'' +
                ", trackNumber=" + this.trackNumber +
                ", riptide=" + this.riptide +
                '}';
    }
}
