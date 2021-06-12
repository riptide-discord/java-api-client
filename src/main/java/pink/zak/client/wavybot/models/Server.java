package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.Riptide;

import java.util.Set;

public interface Server {

    Riptide getRiptide();

    long getServerId();

    @NotNull
    Set<Long> getLinkedUsers();
}
