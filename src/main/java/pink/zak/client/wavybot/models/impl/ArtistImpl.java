package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.models.Artist;
import pink.zak.client.wavybot.models.SpotifyImage;

import java.util.Set;

public class ArtistImpl implements Artist {
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    private final long lastSpotifyUpdate;

    @Nullable
    private final Set<SpotifyImage> artistImages;
    @Nullable
    private final String[] genres;

    public ArtistImpl(@NotNull String id, @NotNull String name, long lastSpotifyUpdate, @Nullable Set<SpotifyImage> artistImages,
                      @Nullable String[] genres) {
        this.id = id;
        this.name = name;
        this.lastSpotifyUpdate = lastSpotifyUpdate;
        this.artistImages = artistImages;
        this.genres = genres;
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
    public long getLastSpotifyUpdate() {
        return this.lastSpotifyUpdate;
    }

    @Override
    @Nullable
    public Set<SpotifyImage> getArtistImages() {
        return this.artistImages;
    }

    @Override
    @Nullable
    public String[] getGenre() {
        return this.genres;
    }
}
