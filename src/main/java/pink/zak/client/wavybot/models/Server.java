package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface Server {

    long getServerId();

    @NotNull
    Set<Long> getLinkedUsers();

    @NotNull
    CompletableFuture<Set<User>> retrieveLinkedUsers();
}
