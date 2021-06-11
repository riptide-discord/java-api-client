package pink.zak.client.wavybot.models.impl;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.models.Task;

import java.util.UUID;

public class TaskImpl implements Task {
    @NotNull
    private final UUID taskId;
    private final long creationTime;
    private final int requiredProgress;
    private final int progress;

    public TaskImpl(@NotNull UUID taskId, long creationTime, int requiredProgress, int progress) {
        this.taskId = taskId;
        this.creationTime = creationTime;
        this.requiredProgress = requiredProgress;
        this.progress = progress;
    }

    @Override
    @NotNull
    public  UUID getTaskId() {
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
}
