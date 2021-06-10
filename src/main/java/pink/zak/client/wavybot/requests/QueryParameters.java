package pink.zak.client.wavybot.requests;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class QueryParameters {
    @NotNull
    private final Map<String, String> parameters = new HashMap<>();

    @NotNull
    public QueryParameters addParameter(@NotNull String key, @NotNull Object value) {
        this.parameters.put(key, value.toString());
        return this;
    }

    public int getSize() {
        return this.parameters.size();
    }

    public String build() {
        if (this.parameters.size() < 1)
            return "";
        StringBuilder paramBuilder = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            paramBuilder.append(i == 0 ? '?' : '&')
                    .append(entry.getKey())
                    .append('=')
                    .append(entry.getValue());
            i++;
        }
        return paramBuilder.toString();
    }
}
