module at.ac.hcw.idledevgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens at.ac.hcw.idledevgame to javafx.fxml;
    exports at.ac.hcw.idledevgame;
}