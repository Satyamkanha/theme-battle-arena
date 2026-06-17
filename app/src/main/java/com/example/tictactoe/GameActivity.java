package com.example.tictactoe;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    TextView titleText;

    ImageButton[] cells = new ImageButton[9];

    boolean playerOneTurn = true;

    int playerOneImage;
    int playerTwoImage;

    int[] board = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        titleText = findViewById(R.id.titleText);

        String theme = getIntent().getStringExtra("theme");

        if (theme == null)
            theme = "";

        switch (theme) {

            case "cricket":
                titleText.setText("TEST WORKING");
                playerOneImage = R.drawable.cricket_bat;
                playerTwoImage = R.drawable.cricket_ball;
                break;

            case "football":
                titleText.setText("⚽ Football Battle");
                playerOneImage = R.drawable.football;
                playerTwoImage = R.drawable.goal_post;
                break;

            case "food":
                titleText.setText("🍔 Food Battle");
                playerOneImage = R.drawable.burger;
                playerTwoImage = R.drawable.pizza;
                break;

            case "gaming":
                titleText.setText("🎮 Gaming Battle");
                playerOneImage = R.drawable.controller;
                playerTwoImage = R.drawable.vr_headset;
                break;
        }

        cells[0] = findViewById(R.id.cell0);
        cells[1] = findViewById(R.id.cell1);
        cells[2] = findViewById(R.id.cell2);
        cells[3] = findViewById(R.id.cell3);
        cells[4] = findViewById(R.id.cell4);
        cells[5] = findViewById(R.id.cell5);
        cells[6] = findViewById(R.id.cell6);
        cells[7] = findViewById(R.id.cell7);
        cells[8] = findViewById(R.id.cell8);

        for (int i = 0; i < 9; i++) {

            int index = i;

            cells[i].setOnClickListener(v -> {

                if (board[index] != 0)
                    return;

                if (playerOneTurn) {

                    cells[index].setImageResource(playerOneImage);
                    board[index] = 1;

                } else {

                    cells[index].setImageResource(playerTwoImage);
                    board[index] = 2;
                }

                playerOneTurn = !playerOneTurn;

            });
        }
    }
}