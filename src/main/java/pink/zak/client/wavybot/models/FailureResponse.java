package pink.zak.client.wavybot.models;

import pink.zak.client.wavybot.enums.RiptideStatusCode;

public interface FailureResponse {

    int getStatusCode();

    default RiptideStatusCode getRiptideStatusCode() {
        return RiptideStatusCode.fromCode(this.getStatusCode());
    }

    String getMessage();

    String getPath();
}
