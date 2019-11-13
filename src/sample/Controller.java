package sample;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class Controller {

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox month;

    private ArrayList observableList;

    @FXML
    void initialize() {
        setLocalDateNow();
        getLocalDate();
        setMonthComboBox();
        getCurrentMonth();
    }

    public void setLocalDateNow() {
        datePicker.setValue(LocalDate.now());
    }

    public void getLocalDate() {
        datePicker.setValue(datePicker.getValue());
    }

    public void setMonthComboBox() {
        ArrayList monthList = new ArrayList();
        monthList.add("Январь");
        monthList.add("Февраль");
        monthList.add("Март");
        monthList.add("Апрель");
        monthList.add("Май");
        monthList.add("Июнь");
        monthList.add("Июль");
        monthList.add("Август");
        monthList.add("Сентябрь");
        monthList.add("Октябрь");
        monthList.add("Ноябрь");
        monthList.add("Декабрь");

        ObservableList observableList = FXCollections.observableList(monthList);
        month.setItems(observableList);

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int mnth = localDate.getMonthValue();
        month.setValue(monthList.get(mnth - 1));
    }

    public void getCurrentMonth() {
        System.out.println(month.getValue());
    }
}