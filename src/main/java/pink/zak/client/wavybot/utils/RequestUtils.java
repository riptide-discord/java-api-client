package pink.zak.client.wavybot.utils;

import pink.zak.client.wavybot.Riptide;
import pink.zak.client.wavybot.requests.QueryParameters;
import pink.zak.client.wavybot.requests.Route;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RequestUtils {

    public static HttpRequest createRequest(Riptide riptide, Route route, String... urlParameters) {
        URI uri = route.toUri(riptide.getUrl(), urlParameters);
        return route.getMethod().apply(HttpRequest.newBuilder().uri(uri), null).build();
    }

    public static HttpRequest createRequest(Riptide riptide, Route route, Consumer<QueryParameters> queryConsumer, String... urlParameters) {
        URI uri = route.toUri(riptide.getUrl(), queryConsumer, urlParameters);
        return route.getMethod().apply(HttpRequest.newBuilder().uri(uri), null).build();
    }
}
