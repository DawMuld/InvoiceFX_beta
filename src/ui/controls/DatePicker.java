/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controls;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.ControlBuilder;
import com.gui.laf.Nunito;
import com.gui.laf.WindowBuilder;
import java.time.LocalDate;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author daan-
 */
public class DatePicker extends BorderPane {

    private LocalDate viewDate;

    private AnchorPane headerPane;
    private Button nextButton;
    private Button prevButton;
    private Label yearMonthLabel;
    private GridPane calendarPane;

    private ToggleGroup tGroup = new ToggleGroup();
    private ToggleButton[] dayToggles;

    private Button cancelButton;
    private Button selectButton;



    public DatePicker() {
        super();
        viewDate = LocalDate.now();
        nextButton = ControlBuilder.createFlatButton(">>");
        nextButton.setTextFill(Colors.WHITE1);
        nextButton.setOnAction((event) -> {
            nextMonth();
        });

        prevButton = ControlBuilder.createFlatButton("<<");
        prevButton.setOnAction((event) -> {
            prevMonth();
        });
        prevButton.setTextFill(Colors.WHITE1);
        yearMonthLabel = new Label(viewDate.getMonth().name() + ", " + String.valueOf(viewDate.getYear()));
        yearMonthLabel.setBackground(Background.EMPTY);
        yearMonthLabel.setFont(Nunito.medium(14));
        yearMonthLabel.setTextFill(Colors.WHITE1);
        yearMonthLabel.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(prevButton, 4.0);
        AnchorPane.setLeftAnchor(prevButton, 4.0);
        AnchorPane.setBottomAnchor(prevButton, 4.0);
        AnchorPane.setTopAnchor(nextButton, 4.0);
        AnchorPane.setRightAnchor(nextButton, 4.0);
        AnchorPane.setBottomAnchor(nextButton, 4.0);
        AnchorPane.setTopAnchor(yearMonthLabel, 4.0);
        AnchorPane.setRightAnchor(yearMonthLabel, 40.0);
        AnchorPane.setLeftAnchor(yearMonthLabel, 40.0);
        AnchorPane.setBottomAnchor(yearMonthLabel, 4.0);
        headerPane = new AnchorPane(prevButton, yearMonthLabel, nextButton);
        initDayGrid();
        setTop(headerPane);
        setCenter(calendarPane);
        setBackground(Backgrounds.createColorBg(Colors.BLACK1, 8));
        initMonth(LocalDate.of(viewDate.getYear(), viewDate.getMonthValue(), 1));

        cancelButton = WindowBuilder.createFlatButton("Cancel");
        selectButton = WindowBuilder.createFlatButton("Select");
        cancelButton.setTextFill(Colors.WHITE1);
        selectButton.setTextFill(Colors.WHITE1);

        FlowPane bottomPane = new FlowPane(8, 8, cancelButton, selectButton);
        bottomPane.setPadding(new Insets(8));
        bottomPane.setAlignment(Pos.CENTER_RIGHT);
        setBottom(bottomPane);
        super.setMaxWidth(280);
        tGroup.selectedToggleProperty().addListener((o, v1, v2) -> {
            if (v2 != null) {
                ToggleButton tb = (ToggleButton) v2;
                String day = tb.getText();
                viewDate = LocalDate.of(viewDate.getYear(), viewDate.getMonthValue(), Integer.parseInt(day));
                System.out.println(viewDate.toString());
            }
        });
    }



    public Button getCancelButton() {
        return cancelButton;
    }



    public Button getSelectButton() {
        return selectButton;
    }



    public LocalDate getResult() {
        return viewDate;
    }



    private void initDayGrid() {
        dayToggles = new ToggleButton[42];
        Background disabled = Backgrounds.createColorBg(Colors.GRAY2);
        Background idle = Backgrounds.createColorBg(Colors.BLACK1);
        Background selected = Backgrounds.createColorBg(Colors.BLACK2);
        for (int i = 0; i < 42; i++) {
            ToggleButton dayToggle = new ToggleButton("0");
            dayToggle.setTextFill(Colors.WHITE1);
            dayToggle.setBackground(idle);
            dayToggle.disableProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == true) {
                    dayToggle.setBackground(disabled);
                } else {
                    dayToggle.setBackground(idle);
                }
            });
            dayToggle.selectedProperty().addListener((o, v1, v2) -> {
                if (v2 == true) {
                    dayToggle.setBackground(selected);
                } else {
                    dayToggle.setBackground(idle);
                }
            });
            dayToggle.setFont(Nunito.regular(10));
            dayToggle.setMaxWidth(40);
            dayToggle.setToggleGroup(tGroup);
            dayToggles[i] = dayToggle;
        }
        Label ma = dayLabel("Ma");
        Label di = dayLabel("Di");
        Label wo = dayLabel("Wo");
        Label don = dayLabel("Do");
        Label vr = dayLabel("Vr");
        Label za = dayLabel("Za");
        Label zo = dayLabel("Zo");

        GridPane.setConstraints(ma, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(di, 1, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(wo, 2, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(don, 3, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(vr, 4, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(za, 5, 0, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(zo, 6, 0, 1, 1, HPos.CENTER, VPos.CENTER);

        GridPane.setConstraints(dayToggles[0], 0, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[1], 1, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[2], 2, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[3], 3, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[4], 4, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[5], 5, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[6], 6, 1, 1, 1, HPos.CENTER, VPos.CENTER);

        GridPane.setConstraints(dayToggles[7], 0, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[8], 1, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[9], 2, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[10], 3, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[11], 4, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[12], 5, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[13], 6, 2, 1, 1, HPos.CENTER, VPos.CENTER);

        GridPane.setConstraints(dayToggles[14], 0, 3, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[15], 1, 3, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[16], 2, 3, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[17], 3, 3, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[18], 4, 3, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[19], 5, 3, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[20], 6, 3, 1, 1, HPos.CENTER, VPos.CENTER);

        GridPane.setConstraints(dayToggles[21], 0, 4, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[22], 1, 4, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[23], 2, 4, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[24], 3, 4, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[25], 4, 4, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[26], 5, 4, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[27], 6, 4, 1, 1, HPos.CENTER, VPos.CENTER);

        GridPane.setConstraints(dayToggles[28], 0, 5, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[29], 1, 5, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[30], 2, 5, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[31], 3, 5, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[32], 4, 5, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[33], 5, 5, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[34], 6, 5, 1, 1, HPos.CENTER, VPos.CENTER);

        GridPane.setConstraints(dayToggles[35], 0, 6, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[36], 1, 6, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[37], 2, 6, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[38], 3, 6, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[39], 4, 6, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[40], 5, 6, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(dayToggles[41], 6, 6, 1, 1, HPos.CENTER, VPos.CENTER);
        calendarPane = new GridPane();
        calendarPane.getChildren().addAll(ma, di, wo, don, vr, za, zo);
        for (int i = 0; i < dayToggles.length; i++) {
            calendarPane.getChildren().add(dayToggles[i]);
        }

    }



    private Label dayLabel(String text) {
        Label label = new Label(text);
        label.setFont(Nunito.bold(16));
        label.setTextFill(Colors.WHITE1);
        label.setPrefWidth(40);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);
        label.setBackground(Background.EMPTY);
        return label;
    }



    private void initMonth(LocalDate ld) {
        int monthVal = ld.getMonthValue();
        if (ld.getDayOfWeek().getValue() != 1) {
            while (ld.getDayOfWeek().getValue() != 1) {
                ld = ld.minusDays(1L);
            }
        }
        for (int i = 0; i < dayToggles.length; i++) {
            dayToggles[i].setText(String.valueOf(ld.getDayOfMonth()));
            if (ld.getMonthValue() != monthVal) {
                dayToggles[i].setDisable(true);
            } else {
                dayToggles[i].setDisable(false);
                if (ld.getDayOfMonth() == viewDate.getDayOfMonth()) {
                    tGroup.selectToggle(dayToggles[i]);
                }
            }

            ld = ld.plusDays(1L);
        }
    }



    private void nextMonth() {
        viewDate = viewDate.plusMonths(1L);
        viewDate = LocalDate.of(viewDate.getYear(), viewDate.getMonthValue(), 1);
        yearMonthLabel.setText("1, " + viewDate.getMonth().name().toLowerCase() + ", " + String.valueOf(viewDate.getYear()));
        LocalDate ld = LocalDate.of(viewDate.getYear(), viewDate.getMonthValue(), 1);
        initMonth(ld);

    }



    private void prevMonth() {
        viewDate = viewDate.minusMonths(1L);
        viewDate = LocalDate.of(viewDate.getYear(), viewDate.getMonthValue(), 1);
        yearMonthLabel.setText("1, " + viewDate.getMonth().name().toLowerCase() + ", " + String.valueOf(viewDate.getYear()));
        LocalDate ld = LocalDate.of(viewDate.getYear(), viewDate.getMonthValue(), 1);
        initMonth(ld);
    }

}
