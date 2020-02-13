package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    boolean gameOn = true;
    int activePlayer = 0 ;
    int gameValues[] = {2,2,2,2,2,2,2,2,2};
    int player1Win = 0;
    int player2Win = 0;

    int winPosition [][] = { {0,1,2} , {3,4,5} , {6,7,8},
                             {0,3,6} , {1,4,7} , {2,5,8},
                             {0,4,8} , {2,4,6}
                            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Tap(View view)
    {
        ImageView imageView = (ImageView) view;
        int imageTap = Integer.parseInt(imageView.getTag().toString());
        if(!gameOn)
        {
            gameReset(view);
        }
        if(gameValues[imageTap] == 2)
        {
            gameValues[imageTap] = activePlayer;
            imageView.setTranslationY(-1000f);
            if(activePlayer == 0)
            {
                imageView.setImageResource(R.drawable.zero);
                activePlayer = 1;
                TextView turn = findViewById(R.id.playerTurn);
                turn.setText("Player2 chal le ");
            }
            else
            {
                imageView.setImageResource(R.drawable.cross);
                activePlayer = 0;
                TextView turn = findViewById(R.id.playerTurn);
                turn.setText("Player1 chal le ");
            }
        }

        else
        {
            TextView turn = findViewById(R.id.playerTurn);
            turn.setText("Wrong Choice!!!");
        }

        imageView.animate().translationYBy(1000f).setDuration(200);

        for(int i=0;i<8;i++)
        {
            if(gameValues[winPosition[i][0]] != 2 && gameValues[winPosition[i][0]] == gameValues[winPosition[i][1]] && gameValues[winPosition[i][0]] == gameValues[winPosition[i][2]] )
            {
                String winner ;
                gameOn = false;
                if(gameValues[winPosition[i][0]] == 0)
                {
                    winner = "Player1 has won!!!";
                    player1Win ++;
                    TextView playerWiins = findViewById(R.id.textView4);
                    playerWiins.setText("PLAYER 1: "+ player1Win);
                }
                else
                {
                    winner = "Player2 has won!!!";
                    player2Win ++;
                    TextView playerWiins = findViewById(R.id.textView5);
                    playerWiins.setText("PLAYER 2: "+ player2Win);

                }
                TextView turn = findViewById(R.id.playerTurn);
                turn.setText(winner);

            }
        }
    }

    public void gameReset(View view) {
        gameOn = true;
        activePlayer = 0;
        for(int i=0; i<gameValues.length;i++)
        {
            gameValues[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }


}
