module test.test1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.test1 to javafx.fxml;
    exports test.test1;
}