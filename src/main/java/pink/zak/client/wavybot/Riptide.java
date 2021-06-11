package pink.zak.client.wavybot;

import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;

public interface Riptide {

    @NotNull
    HttpClient getHttpClient();

    @NotNull
    String getUrl();
}
