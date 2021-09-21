package pink.zak.client.wavybot.enums;

import org.jetbrains.annotations.Nullable;

public enum RiptideStatusCode {
    OK(200, "Ok"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    DISCORD_ALREADY_LINKED(5101, "Discord account is already linked to a wavy account"),
    WAVY_ALREADY_LINKED(5102, "Wavy account is already linked to a Discord account"),
    WAVY_PROFILE_HAS_NO_DISCORD(5103, "Wavy account does not have a Discord account displayed"),
    WAVY_DISCORD_DOES_NOT_MATCH(5104, "Wavy Discord account does not match");

    private final int statusCode;
    private final String description;

    RiptideStatusCode(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isTolerable() {
        return this.statusCode < 300 && this.statusCode >= 200;
    }

    @Nullable
    public static RiptideStatusCode fromCode(int statusCode) {
        for (RiptideStatusCode riptideStatusCode : RiptideStatusCode.values())
            if (riptideStatusCode.getStatusCode() == statusCode)
                return riptideStatusCode;
        return null;
    }
}
