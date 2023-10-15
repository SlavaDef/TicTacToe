package com.example.tictactoe2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

   private char nowSymb = 'X';

    @FXML
    void btClick(ActionEvent event) { // логіка кнопки, event обьект з яким працюємо
        ((Button)event.getSource()).setText(String.valueOf(nowSymb));
        // логіка по зміні X i 0 кожне нажатіе новий символ
        nowSymb = nowSymb == 'X' ? '0' : 'X';
    }

    @FXML
    void initialize() {
      // стандартна функція накшталт PostConstruct
    }

}
