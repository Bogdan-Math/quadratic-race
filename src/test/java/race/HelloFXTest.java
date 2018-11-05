package race;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.assertions.api.Assertions.assertThat;

public class HelloFXTest extends ApplicationTest {

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("testfx.headless", "true");
    }

    @Override
    public void start(Stage stage) {
        new HelloFX()
                .start(stage);

        stage.show();
    }

    @Test
    public void test_1() {
        assertThat(lookup("#label_1").queryAs(Label.class))
                .hasText("Hello, JavaFX, running on Java 11");
    }

    @Test
    public void test_2() {
        assertThat(lookup("#button_1").queryAs(Button.class))
                .hasText("click me!");

        clickOn("#button_1");

        assertThat(lookup("#button_1").queryAs(Button.class))
                .hasText("clicked!");
    }

}