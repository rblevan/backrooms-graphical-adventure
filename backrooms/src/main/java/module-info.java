module fr.univpoitiers.backrooms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.univpoitiers.backrooms to javafx.fxml;
    exports fr.univpoitiers.backrooms;
}