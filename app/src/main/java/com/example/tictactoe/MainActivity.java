package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
//import android.support.v7.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    int player=1;
    int[] game={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] won={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean win=false;
    public void fade(View view)
    {
        ImageView image = (ImageView) view;
        int pressed = Integer.parseInt(image.getTag().toString());
        if(!win && game[pressed]==-1) {
            game[pressed] = player;
            if (player == 0) {
                player = 1;
                image.setImageResource(R.drawable.o);
                //player=1;
            } else {
                player = 0;
                image.setImageResource(R.drawable.x);
                //player=0;
            }
            for (int i = 0; i < 8; i++) {
                if (game[won[i][0]] == game[won[i][1]] && game[won[i][1]] == game[won[i][2]] && game[won[i][0]] != -1) {
                    String winner = "";
                    if (player == 1) {
                        winner = "Player 2(O)";
                    } else {
                        winner = "Player 1(X)";
                    }
                    Toast.makeText(this, winner + " Won", Toast.LENGTH_SHORT).show();
                    win = true;
                }
            }
            Button b = (Button)findViewById(R.id.button2);
            b.setVisibility(View.VISIBLE);

        }
    }
    public void reset(View view)
    {
        Button b = (Button)findViewById(R.id.button2);
        b.setVisibility(View.INVISIBLE);
        Log.i("INfo","Pressed");
        androidx.gridlayout.widget.GridLayout gl = findViewById(R.id.gridLayout);
        //GridLayout gl = (GridLayout)findViewById(R.id.gridLayout);
        //GridLayout gl = (GridLayout)findViewById(R.id.gridLayout);
        Log.i("INfo","Pressed 2");
        for(int i=0;i<gl.getChildCount();i++)
        {
            ImageView img = (ImageView)gl.getChildAt(i);
            img.setImageDrawable(null);
        }
        player=1;
        for(int i=0;i<game.length;i++)
        {
            game[i]=-1;
        }
        //int[] game={-1,-1,-1,-1,-1,-1,-1,-1,-1};
        win=false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
