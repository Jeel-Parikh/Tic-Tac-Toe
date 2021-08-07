package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public static final String Player1 = "com.example.tictactoe.player1";
    public static final String Player2 = "com.example.tictactoe.player2";

    public void start(View view) {
        EditText player1 = findViewById(R.id.player1);
        EditText player2 = findViewById(R.id.player2);
        String name1 = player1.getText().toString();
        String name2 = player2.getText().toString();
        Intent intent = new Intent(this, GameWindow.class);
        intent.putExtra(Player1, name1);
        intent.putExtra(Player2, name2);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}