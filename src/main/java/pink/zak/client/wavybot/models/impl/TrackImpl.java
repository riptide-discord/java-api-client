package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.models.Track;

import java.util.Set;

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

    public TrackImpl(@NotNull String id, @NotNull String name, @NotNull String albumId, @NotNull Set<String> artistIds,
                     long lastSpotifyUpdate, int discNumber, int durationMs, @Nullable String previewUrl,
                     int trackNumber) {
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
}
