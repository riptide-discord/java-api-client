package pink.zak.client.wavybot.models;

import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.Riptide;

import java.util.UUID;

public interface Task {

    Riptide getRiptide();

    @NotNull
    UUID getTaskId();

    long getCreationTime();

    int getRequiredProgress();

    int getProgress();
}
