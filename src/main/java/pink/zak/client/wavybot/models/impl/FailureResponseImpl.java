package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.FailureResponse;

public class FailureResponseImpl implements FailureResponse {
    private final int statusCode;
    @NotNull
    private final String message;
    @NotNull
    private final String path;

    public FailureResponseImpl(@JsonProperty("status") int statusCode,
                               @JsonProperty("message") @NotNull String message,
                               @JsonProperty("path") @NotNull String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getPath() {
        return this.path;
    }
}
