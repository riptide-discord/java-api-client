package pink.zak.client.wavybot.requests;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.util.Map;
import java.util.function.Consumer;

public class Route {

    public static class Users {
        public static final Route GET_USER = new Route(Method.GET, "/user/{discordId}/get");
        public static final Route GET_MUSIC_DATA = new Route(Method.GET, "/user/{discordId}/getMusicData");
        public static final Route GET_WAVY = new Route(Method.GET, "/user/{discordId}/getWavy");
        public static final Route LINK_WAVY = new Route(Method.GET, "/user/{discordId}/linkWavy");
        public static final Route UPDATE_LISTENS = new Route(Method.GET, "/user/{discordId}/updateListens");
    }

    public static class Tasks {
        public static final Route GET_TASK = new Route(Method.GET, "/task/{uuid}/get");
    }

    public static class Leaderboards {
        public static final Route GET_PARTIAL_LEADERBOARD = new Route(Method.GET, "/leaderboard/{discordId}/getPartial");
    }

    @NotNull
    private final Method method;
    @NotNull
    private final String path;
    private final int paramCount;

    public Route(@NotNull Method method, @NotNull String path) {
        this.method = method;
        this.path = path;

        int parameterCount = 0;
        for (char character : path.toCharArray()) {
            if (character == '{') {
                parameterCount++;
            }
        }
        this.paramCount = parameterCount;
    }

    @NotNull
    public URI toUri(@NotNull String url, Consumer<QueryParameters> queryConsumer, String... urlParameters) {
        QueryParameters parameters = new QueryParameters();
        queryConsumer.accept(parameters);
        return this.toUri(url, parameters, urlParameters);
    }

    @NotNull
    public URI toUri(@NotNull String url, String... urlParameters) {
        return this.toUri(url, (QueryParameters) null, urlParameters);
    }

    @NotNull
    private URI toUri(@NotNull String url, @Nullable QueryParameters queryParameters, String... urlParameters) {
        if (urlParameters.length != this.paramCount)
            throw new IllegalArgumentException("Could not fill out route '" + this.path + "' as the parameters specified didn't match the parameter count in the route " +
                    "(" + urlParameters.length + " != " + this.paramCount + ").");

        StringBuilder urlBuilder = new StringBuilder(url.concat(this.path));
        for (int i = 0; i < this.paramCount; i++) {
            int paramStartIndex = urlBuilder.indexOf("{");
            int paramEndIndex = urlBuilder.indexOf("}");
            urlBuilder.replace(paramStartIndex, paramEndIndex + 1, urlParameters[i]);
        }

        if (queryParameters != null && queryParameters.getSize() > 0)
            urlBuilder.append(queryParameters.build());

        return URI.create(urlBuilder.toString());
    }

    @NotNull
    public Method getMethod() {
        return this.method;
    }

    @NotNull
    public String getPath() {
        return this.path;
    }
}