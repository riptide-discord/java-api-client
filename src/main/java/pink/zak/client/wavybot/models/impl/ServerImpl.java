package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.Server;

import java.util.Set;

public class ServerImpl implements Server {
    private final long serverId;
    private final Set<Long> linkedUsers;

    private RiptideImpl riptide;

    public ServerImpl(@JsonProperty("serverId") long serverId,
                      @JsonProperty("linkedUsers") Set<Long> linkedUsers) {
        this.serverId = serverId;
        this.linkedUsers = linkedUsers;
    }

    @Override
    public RiptideImpl getRiptide() {
        return this.riptide;
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
    public String toString() {
        return "ServerImpl{" +
                "serverId=" + this.serverId +
                ", linkedUsers=" + this.linkedUsers +
                ", riptide=" + this.riptide +
                '}';
    }
}
