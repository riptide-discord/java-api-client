package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import pink.zak.client.wavybot.models.spotify.SpotifyImage;

public class SpotifyImageImpl implements SpotifyImage {
    private final int height;
    private final int width;
    private final String url;

    public SpotifyImageImpl(@JsonProperty("height") int height,
                            @JsonProperty("width") int width,
                            @JsonProperty("url") String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        return "SpotifyImageImpl{" +
                "height=" + this.height +
                ", width=" + this.width +
                ", url='" + this.url + '\'' +
                '}';
    }
}
