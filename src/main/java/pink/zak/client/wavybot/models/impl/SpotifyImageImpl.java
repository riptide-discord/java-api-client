package pink.zak.client.wavybot.models.impl;

import pink.zak.client.wavybot.models.SpotifyImage;

public class SpotifyImageImpl implements SpotifyImage {
    private final int height;
    private final int width;
    private final String url;

    public SpotifyImageImpl(int height, int width, String url) {
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
}
