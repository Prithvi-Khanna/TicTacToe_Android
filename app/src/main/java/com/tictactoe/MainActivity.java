package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    int activePlayer = 0 ;
    int gameValues[] = {2,2,2,2,2,2,2,2,2};

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
        if(gameValues[imageTap] == 2)
        {
            gameValues[imageTap] = activePlayer;
            imageView.setTranslationY(-1000f);
            if(activePlayer == 0)
            {
                imageView.setImageResource(R.drawable.zero);
                activePlayer = 1;
            }
            else
            {
                imageView.setImageResource(R.drawable.cross);
                activePlayer = 0;
            }
        }

        imageView.animate().translationYBy(1000f).setDuration(200);

        for(int i=0;i<8;i++)
        {
            if(gameValues[winPosition[i][0]] != 2 && gameValues[winPosition[i][0]] == gameValues[winPosition[i][1]] && gameValues[winPosition[i][0]] == gameValues[winPosition[i][2]] )
            {
                TextView textView3 = (TextView) findViewById(R.id.textView3);
                textView3.setText("PLAYER"+ activePlayer +"Wins!!!");
                break;
            }
        }
    }
}
