package pink.zak.client.wavybot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class Tuple<T1, T2> {
    @NotNull
    private final T1 t1;
    @NotNull
    private final T2 t2;

    public Tuple(@JsonProperty("t1") @NotNull T1 t1,
                 @JsonProperty("t2") @NotNull T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @NotNull
    public T1 getT1() {
        return this.t1;
    }

    @NotNull
    public T2 getT2() {
        return this.t2;
    }
}
