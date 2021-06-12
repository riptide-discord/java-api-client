package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.Server;
import pink.zak.client.wavybot.models.User;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ServerImpl implements Server {
    private final long serverId;
    private final Set<Long> linkedUsers;

    private RiptideImpl riptide;

    public ServerImpl(long serverId, Set<Long> linkedUsers) {
        this.serverId = serverId;
        this.linkedUsers = linkedUsers;
    }

    public void setRiptide(RiptideImpl riptide) {
        this.riptide = riptide;
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

    @Override
    public @NotNull CompletableFuture<Set<User>> retrieveLinkedUsers() {
        return null;
    }

    @Override
    public String toString() {
        return "ServerImpl{" +
                "serverId=" + this.serverId +
                ", linkedUsers=" + this.linkedUsers +
                ", riptide=" + this.riptide +
                '}';
    }
}
