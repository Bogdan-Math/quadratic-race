package race;

import javafx.stage.Stage;
import javafx.stage.Window;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
class MainFXTest {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("testfx.headless", "true");
    }

    @Start
    void onStart(Stage stage) {
        new MainFX()
                .start(stage);

        stage.show();
    }

    @Test
    @DisplayName("verify window title")
    void title(FxRobot fxRobot) {
        List<Window> windows = fxRobot.listWindows();
        assertAll(
                () -> assertEquals(windows.size(),1),
                () -> assertEquals(((Stage)windows.get(0)).getTitle(), "Quadratic Race")
        );
    }
}