module race {

    opens race;
    opens race.image;
    opens race.sound;

    requires javafx.controls;
    requires java.desktop;
    requires jlayer;
}