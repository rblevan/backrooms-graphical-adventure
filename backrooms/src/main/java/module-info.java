module fr.univpoitiers.backrooms {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;
    requires javafx.base;

    requires com.google.gson;
    opens fr.univpoitiers.backrooms.model.levelEditor to com.google.gson;

    exports fr.univpoitiers.backrooms.main;
    opens fr.univpoitiers.backrooms.main to javafx.graphics;

    exports fr.univpoitiers.backrooms.view;
    opens fr.univpoitiers.backrooms.view to javafx.graphics;

    exports fr.univpoitiers.backrooms.controller;
    opens fr.univpoitiers.backrooms.controller to javafx.graphics;

    exports fr.univpoitiers.backrooms;
    opens fr.univpoitiers.backrooms to javafx.graphics;
}