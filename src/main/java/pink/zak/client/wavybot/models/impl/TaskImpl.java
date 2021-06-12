package pink.zak.client.wavybot.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.Task;

import java.util.UUID;

public class TaskImpl implements Task {
    @NotNull
    private final UUID taskId;
    private final long creationTime;
    private final int requiredProgress;
    private final int progress;

    private RiptideImpl riptide;

    public TaskImpl(@JsonProperty("taskId") @NotNull UUID taskId,
                    @JsonProperty("creationTime") long creationTime,
                    @JsonProperty("requiredProgress") int requiredProgress,
                    @JsonProperty("progress") int progress) {
        this.taskId = taskId;
        this.creationTime = creationTime;
        this.requiredProgress = requiredProgress;
        this.progress = progress;
    }

    @Override
    public RiptideImpl getRiptide() {
        return this.riptide;
    }

    public void setRiptide(RiptideImpl riptide) {
        this.riptide = riptide;
    }

    @Override
    @NotNull
    public UUID getTaskId() {
        return this.taskId;
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override
    public int getRequiredProgress() {
        return this.requiredProgress;
    }

    @Override
    public int getProgress() {
        return this.progress;
    }

    @Override
    public String toString() {
        return "TaskImpl{" +
                "taskId=" + this.taskId +
                ", creationTime=" + this.creationTime +
                ", requiredProgress=" + this.requiredProgress +
                ", progress=" + this.progress +
                ", riptide=" + this.riptide +
                '}';
    }
}
