package pink.zak.client.wavybot.utils;

import java.util.Collection;
import java.util.StringJoiner;

public class Joiner {

    public static String join(Collection<String> strings, CharSequence joiner) {
        StringJoiner stringJoiner = new StringJoiner(joiner);

        for (String string: strings)
            stringJoiner.add(string);

        return stringJoiner.toString();
    }
}
