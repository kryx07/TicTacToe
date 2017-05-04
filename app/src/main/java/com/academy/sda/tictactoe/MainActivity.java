package com.academy.sda.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private String sign = "X";

    private boolean gameOver = false;

    private Button buttonA1;
    private Button buttonB1;
    private Button buttonC1;
    private Button buttonA2;
    private Button buttonB2;
    private Button buttonC2;
    private Button buttonA3;
    private Button buttonB3;
    private Button buttonC3;

    private void configureButtons() {
        buttonA1 = (Button) findViewById(R.id.buttonA1);
        buttonB1 = (Button) findViewById(R.id.buttonB1);
        buttonC1 = (Button) findViewById(R.id.buttonC1);
        buttonA2 = (Button) findViewById(R.id.buttonA2);
        buttonB2 = (Button) findViewById(R.id.buttonB2);
        buttonC2 = (Button) findViewById(R.id.buttonC2);
        buttonA3 = (Button) findViewById(R.id.buttonA3);
        buttonB3 = (Button) findViewById(R.id.buttonB3);
        buttonC3 = (Button) findViewById(R.id.buttonC3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureButtons();
    }

    public void onButtonClick(View view) {
        if (gameOver) {
            makeShortToast("Esta finito!");
            return;
        }

        Button button = (Button) view;
        if (button.getText().equals("")) {
            button.setText(sign);
            switchSign();
            checkBoard();
        } else {
            makeShortToast("Hey, that's already clicked");
        }

    }

    private void switchSign() {
        if (sign.equals("O")) {
            sign = "X";
        } else {
            sign = "O";
        }
    }

    private void checkBoard() {
        checkButtonsForWinner(Arrays.asList(buttonA1, buttonA2, buttonA3));
        checkButtonsForWinner(Arrays.asList(buttonB1, buttonB2, buttonB3));
        checkButtonsForWinner(Arrays.asList(buttonC1, buttonC2, buttonC3));
        checkButtonsForWinner(Arrays.asList(buttonA1, buttonB1, buttonC1));
        checkButtonsForWinner(Arrays.asList(buttonA2, buttonB2, buttonC2));
        checkButtonsForWinner(Arrays.asList(buttonA3, buttonB3, buttonC3));
        checkButtonsForWinner(Arrays.asList(buttonA1, buttonB2, buttonC3));
        checkButtonsForWinner(Arrays.asList(buttonA3, buttonB2, buttonC1));
    }

    private void checkButtonsForWinner(List<Button> buttons) {
        if ((buttons.get(0).getText().equals("") || buttons.get(1).getText().equals("") || buttons.get(2).getText().equals(""))) {
            return;
        }
        if (buttons.get(0).getText().equals(buttons.get(1).getText()) && buttons.get(1).getText().equals(buttons.get(2).getText())) {
            makeShortToast(buttons.get(0).getText().toString() + " has won!");
            gameOver = true;
        }
    }

    private void makeShortToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    private void logDebugActivity(String str) {
        Log.d(this.getClass().getSimpleName(), str);
    }
}
