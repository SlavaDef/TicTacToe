package com.example.tictactoe2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class TicTacToeController {

    private char nowSymb = 'X';

    private boolean isGame = true;

    private int count = 0;

    private final char[][] gameField = new char[3][3]; // ігрове поле

    @FXML
    void btClick(ActionEvent event) { // логіка кнопки, event обьект з яким працюємо

        Button btn = ((Button) event.getSource()); // кнопка з якою працюємо

        if (!isGame || btn.getText() != "") return; // isGame == false - вихід з методу

        // шукаємо індекс ряду + обробка нуля
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        // індекс колонки + обробка нуля
        int columIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        gameField[rowIndex][columIndex] = nowSymb;


        btn.setText(String.valueOf(nowSymb));

        // логіка пошуку переможця
        // якщо перша ячейка рівна другій і перша рівна третій і перша ячейка не порожня

        if (gameField[0][0] == gameField[0][1] && gameField[0][0] == gameField[0][2]
                && (gameField[0][0] == 'X' || gameField[0][0] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if (gameField[1][0] == gameField[1][1] && gameField[1][0] == gameField[1][2]
                && (gameField[1][0] == 'X' || gameField[1][0] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if (gameField[2][0] == gameField[2][1] && gameField[2][0] == gameField[2][2]
                && (gameField[2][0] == 'X' || gameField[2][0] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if (gameField[0][0] == gameField[1][0] && gameField[0][0] == gameField[2][0]
                && (gameField[0][0] == 'X' || gameField[0][0] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if (gameField[0][1] == gameField[1][1] && gameField[0][1] == gameField[2][1]
                && (gameField[0][1] == 'X' || gameField[0][1] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if (gameField[0][2] == gameField[1][2] && gameField[0][2] == gameField[2][2]
                && (gameField[0][2] == 'X' || gameField[0][2] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2]
                && (gameField[0][0] == 'X' || gameField[0][0] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if (gameField[0][2] == gameField[1][1] && gameField[0][2] == gameField[2][0]
                && (gameField[0][2] == 'X' || gameField[0][2] == '0')) {
            messageShowing(event);
            isGame = false;
        } else if(isGame==true&&count==8){
            drawMessage(event);
        }

        // логіка по зміні X i 0 кожне натиснення -  новий символ
        nowSymb = nowSymb == 'X' ? '0' : 'X';
        count++;
    }

    // метод для виведення сповіщення про переможця
    public Alert messageShowing(ActionEvent event) {
        Button btn = ((Button) event.getSource());
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "We have the  winner, congratulations! - " + btn.getText(), ButtonType.OK);
        alert.showAndWait();
        return alert;
    }

    public Alert drawMessage(ActionEvent event) {
        Button btn = ((Button) event.getSource());
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Congratulations! Draw, play again! " , ButtonType.OK);
        alert.showAndWait();


        return alert;
    }

    @FXML
    void initialize() {
        // стандартна функція накшталт PostConstruct
    }

}
