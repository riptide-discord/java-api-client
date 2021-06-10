package pink.zak.client.wavybot.config;

import org.jetbrains.annotations.NotNull;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class AuthConfig extends Authenticator {
    @NotNull
    private final PasswordAuthentication passwordAuthentication;

    public AuthConfig(@NotNull String username, @NotNull String password) {
        this.passwordAuthentication = new PasswordAuthentication(username, password.toCharArray());
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return this.passwordAuthentication;
    }
}
