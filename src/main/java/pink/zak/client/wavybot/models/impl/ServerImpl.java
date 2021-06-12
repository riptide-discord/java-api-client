package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.Server;

import java.util.Set;

public class ServerImpl implements Server {
    private final long serverId;
    private final Set<Long> linkedUsers;

    public ServerImpl(long serverId, Set<Long> linkedUsers) {
        this.serverId = serverId;
        this.linkedUsers = linkedUsers;
    }


    @Override
    public long getServerId() {
        return this.serverId;
    }

    @Override
    @NotNull
    public Set<Long> getLinkedUsers() {
        return this.linkedUsers;
    }
}
