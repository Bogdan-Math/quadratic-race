package race;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;

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
    @DisplayName("Verify correct label text")
    void test_1(FxRobot fxRobot) {
        assertThat(fxRobot.lookup("#label_1").queryAs(Label.class))
                .hasText("Hello, JavaFX, running on Java 11");
    }

    @Test
    @DisplayName("Verify button text before and after click")
    void test_2(FxRobot fxRobot) {
        assertThat(fxRobot.lookup("#button_1").queryAs(Button.class))
                .hasText("click me!");

        fxRobot.clickOn("#button_1");

        assertThat(fxRobot.lookup("#button_1").queryAs(Button.class))
                .hasText("clicked!");
    }

}