package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface Server {

    long getServerId();

    @NotNull
    Set<Long> getLinkedUsers();
}
