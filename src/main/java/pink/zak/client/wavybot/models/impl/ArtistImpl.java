package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.Artist;
import pink.zak.client.wavybot.models.SpotifyImage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArtistImpl implements Artist {
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    private final long lastSpotifyUpdate;

    @Nullable
    private final Set<SpotifyImageImpl> artistImages;
    @Nullable
    private final String[] genres;

    private RiptideImpl riptide;

    public ArtistImpl(@JsonProperty("id") @NotNull String id,
                      @JsonProperty("name") @NotNull String name,
                      @JsonProperty("lastSpotifyUpdate") long lastSpotifyUpdate,
                      @JsonProperty("artistImages") @Nullable Set<SpotifyImageImpl> artistImages,
                      @JsonProperty("genres") @Nullable String[] genres) {
        this.id = id;
        this.name = name;
        this.lastSpotifyUpdate = lastSpotifyUpdate;
        this.artistImages = artistImages;
        this.genres = genres;
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
    public long getLastSpotifyUpdate() {
        return this.lastSpotifyUpdate;
    }

    @Override
    @Nullable
    public Set<? extends SpotifyImage> getArtistImages() {
        return this.artistImages;
    }

    @Override
    @Nullable
    public String[] getGenre() {
        return this.genres;
    }

    @Override
    public String toString() {
        return "ArtistImpl{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", lastSpotifyUpdate=" + this.lastSpotifyUpdate +
                ", artistImages=" + this.artistImages +
                ", genres=" + Arrays.toString(this.genres) +
                ", riptide=" + this.riptide +
                '}';
    }
}
