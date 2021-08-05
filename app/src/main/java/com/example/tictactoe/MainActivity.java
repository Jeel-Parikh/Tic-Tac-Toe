package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
//class checker
//{
//        public static void check(TextView status,int[] state,int[][] winstate) {
//        int i, j;
//        int val;
//        int flag = 1;
//        for (i = 0; i < 9; i++) {
//            val = state[i];
//            for (j = 0; j < 3; j++) {
//                if (val == state[winstate[i][j]]) {
//                } else {
//                    flag = 0;
//                    break;
//                }
//            }
//            if (flag == 1) {
//                status.setText(" user Winner");
//                break;
//            }
//        }
//    }
}
*/
public class MainActivity extends AppCompatActivity {

    //0=O
    //1=X
    int activeUser = 0;
    int i, cnt = 0;
    boolean game = true;
    int[] state = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winstate = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    @SuppressLint("SetTextI18n")
    public void playerres(View view) {
        TextView status = findViewById(R.id.Status);
        ImageView img = (ImageView) view;
        int pos = Integer.parseInt(img.getTag().toString());
        if (state[pos] == 2 && game && cnt!=9) {
            state[pos] = activeUser;
            if (activeUser == 0) {
                img.setImageResource(R.drawable.o);
//                check();
//                checker.check(status,state,winstate);
                status.setText("Second player turn");
                cnt++;
                activeUser = 1;
            } else {
                img.setImageResource(R.drawable.x);
//                check();
//                checker.check(status,state,winstate);
                status.setText("First player turn");
                cnt++;
                activeUser = 0;
            }
            for (i = 0; i <= 7; i++) {
                if (state[winstate[i][0]] == state[winstate[i][1]] && state[winstate[i][1]] == state[winstate[i][2]]
                        && state[winstate[i][0]] != 2) {
                    if (state[winstate[i][1]] == 0) {
                        status.setText("First player Winner");
                    } else {
                        status.setText("Second player Winner");
                    }
                    game = false;
                }
            }
            if(cnt==9 && game)
            {
                status.setText("Both are winner");
            }
//            if (activeUser == 1) {
//                status.setText("Second player turn");
//            } else {
//                status.setText("First player turn");
//            }

        } else {

            Toast.makeText(this, "Invalid selection", Toast.LENGTH_SHORT).show();
        }

//        for(int[] winPosition: winstate) {
//            if (state[winPosition[0]] == state[winPosition[1]] &&
//                    state[winPosition[1]] == state[winPosition[2]] &&
//                    state[winPosition[0]] != 2) {
//                // Somebody has won! - Find out who!
//                String winnerStr;
//                game = false;
//                if (state[winPosition[0]] == 0) {
//                    winnerStr = "First player won";
//                } else {
//                    winnerStr = "Second player won";
//                }
//                // Update the status bar for winner announcement
////                TextView status = findViewById(R.id.Status);
//                status.setText(winnerStr);
//            }
//        }
    }

//    void check() {
//        int i, j;
//        int val;
//        int flag = 1;
//        for (i = 0; i < 9; i++) {
//            val = state[i];
//            for (j = 0; j < 3; j++) {
//                if (val == state[winstate[i][j]]) {
//                    flag = 1;
//                } else {
//                    flag = 0;
//                    break;
//                }
//            }
//            if (flag == 1) {
//                status.setText(val + " user Winner");
//                break;
//            }
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}