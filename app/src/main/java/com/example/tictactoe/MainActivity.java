package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
     // 0-X
    // 1-O
    int activePlayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    //State_meanings
    //0-X
    //1-O
    //2-NULL
    int[][] winPositions={{0,1,2,},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view)
    {
        ImageView img=(ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
          gameReset();
        }
        if(gamestate[tappedImage]==2) {
            gamestate[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.cross);
                activePlayer = 1;
                TextView status=findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.zero);
                activePlayer = 0;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn - Tap to Play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition:winPositions)
        {
            if(gamestate[winPosition[0]]==gamestate[winPosition[1]] && gamestate[winPosition[1]]==gamestate[winPosition[2]] && gamestate[winPosition[0]]!=2)
            {
                gameActive=false;
                String winnerStr;
               if (gamestate[winPosition[0]]==0)
                   winnerStr="X has won";
               else
                   winnerStr="O has won";

                TextView status=findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
    }

    public void gameReset()
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0 ; i<(gamestate.length);i++) {
            gamestate[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView01)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView02)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView03)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView04)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView05)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView06)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView07)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView08)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView09)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("X's Turn - Tap to Play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}