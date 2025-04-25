module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens place2BI to javafx.fxml;
    exports place2BI;
}