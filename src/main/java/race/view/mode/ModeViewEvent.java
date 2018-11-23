package race.view.mode;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public enum ModeViewEvent {

    CLICK_EASY_MODE_BUTTON,
    CLICK_NORMAL_MODE_BUTTON,
    CLICK_HARD_MODE_BUTTON;

    public static List<String> asStringList() {
        return stream(ModeViewEvent.values())
                .map(Enum::name)
                .collect(toList());
    }
}
