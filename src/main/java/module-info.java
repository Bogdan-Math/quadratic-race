module race {

    opens race;
    opens race.multimedia.image;
    opens race.multimedia.sound;

    requires javafx.controls;
    requires javafx.media;
    requires java.desktop;
}