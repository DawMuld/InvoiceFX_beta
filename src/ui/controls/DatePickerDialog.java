/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controls;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author daan-
 */
public class DatePickerDialog extends Application {

    private final DatePicker datePicker = new DatePicker();
    private DatePickerResultSink resultSink;
    private Stage stage;
    private LocalDate resultHold;



    public DatePickerDialog() {
        super();
        stage = new Stage();
        datePicker.getCancelButton().setOnAction((event) -> {
            onCancel();
        });
        datePicker.getSelectButton().setOnAction((event) -> {
            onSelect();
        });
    }



    public void showDatePickerDialog(DatePickerResultSink resultSink) {
        this.resultSink = resultSink;

        stage = new Stage();

        Platform.runLater(() -> {
            try {
                start(stage);
            } catch (Exception e) {
            }
        });
    }



    public void onSelect() {
        resultHold = datePicker.getResult();
        stage.close();
        if (resultSink != null) {
            resultSink.setDatePickerResult(resultHold);
        }
    }



    public void onCancel() {
        resultHold = null;
        stage.close();
        if (resultSink != null) {
            resultSink.setDatePickerResult(resultHold);
        }
    }



    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Scene scene = new Scene(datePicker);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

}
