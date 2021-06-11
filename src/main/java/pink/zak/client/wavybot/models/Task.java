package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Task {
    @NotNull
    UUID getTaskId();

    long getCreationTime();

    int getRequiredProgress();

    int getProgress();
}
