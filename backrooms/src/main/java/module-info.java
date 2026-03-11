module fr.univpoitiers.backrooms {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;

    exports fr.univpoitiers.backrooms.main;
    opens fr.univpoitiers.backrooms.main to javafx.graphics;

    exports fr.univpoitiers.backrooms.view;
    opens fr.univpoitiers.backrooms.view to javafx.graphics;
}