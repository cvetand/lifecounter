package edu.washington.cvetan.lifecounter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private int[] playerLife;
    private TextView[] playerlifestat;

    @Override
    protected void onSaveInstanceState(Bundle outState){
        int[] playerLife = this.playerLife;
        outState.putIntArray("playerLife", playerLife);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            playerLife = savedInstanceState.getIntArray("playerLife");
        }else {
            playerLife = new int[]{0, 20, 20, 20, 20};
        }

        playerlifestat = new TextView[]{
                null,
                (TextView) findViewById(R.id.p1lifestat),
                (TextView) findViewById(R.id.p2lifestat),
                (TextView) findViewById(R.id.p3lifestat),
                (TextView) findViewById(R.id.p4lifestat)
        };

        updateLives();

        View.OnClickListener buttonListener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.p1add1:
                        changelife(false, 1, 1);
                        break;
                    case R.id.p1sub1:
                        changelife(true, 1, 1);
                        break;
                    case R.id.p1add5:
                        changelife(false, 5, 1);
                        break;
                    case R.id.p1sub5:
                        changelife(true, 5, 1);
                        break;

                    case R.id.p2add1:
                        changelife(false, 1, 2);
                        break;
                    case R.id.p2sub1:
                        changelife(true, 1, 2);
                        break;
                    case R.id.p2add5:
                        changelife(false, 5, 2);
                        break;
                    case R.id.p2sub5:
                        changelife(true, 5, 2);
                        break;

                    case R.id.p3add1:
                        changelife(false, 1, 3);
                        break;
                    case R.id.p3sub1:
                        changelife(true, 1, 3);
                        break;
                    case R.id.p3add5:
                        changelife(false, 5, 3);
                        break;
                    case R.id.p3sub5:
                        changelife(true, 5, 3);
                        break;

                    case R.id.p4add1:
                        changelife(false, 1, 4);
                        break;
                    case R.id.p4sub1:
                        changelife(true, 1, 4);
                        break;
                    case R.id.p4add5:
                        changelife(false, 5, 4);
                        break;
                    case R.id.p4sub5:
                        changelife(true, 5, 4);
                        break;

                }
            }
        };


        List<Button> buttons = new ArrayList<>();

        //add p1 buttons to list
        buttons.add((Button) findViewById(R.id.p1add1));
        buttons.add((Button) findViewById(R.id.p1sub1));
        buttons.add((Button) findViewById(R.id.p1add5));
        buttons.add((Button) findViewById(R.id.p1sub5));

        //add p2 buttons to list
        buttons.add((Button) findViewById(R.id.p2add1));
        buttons.add((Button) findViewById(R.id.p2sub1));
        buttons.add((Button) findViewById(R.id.p2add5));
        buttons.add((Button) findViewById(R.id.p2sub5));

        //add p3 buttons to list
        buttons.add((Button) findViewById(R.id.p3add1));
        buttons.add((Button) findViewById(R.id.p3sub1));
        buttons.add((Button) findViewById(R.id.p3add5));
        buttons.add((Button) findViewById(R.id.p3sub5));

        //add p4 buttons to list
        buttons.add((Button) findViewById(R.id.p4add1));
        buttons.add((Button) findViewById(R.id.p4sub1));
        buttons.add((Button) findViewById(R.id.p4add5));
        buttons.add((Button) findViewById(R.id.p4sub5));

        //adds the listener to all buttons
        for(Button b: buttons){
            b.setOnClickListener(buttonListener);
        }
    }

    private void changelife(boolean damage, int hp, int player){
        if(damage){
            playerLife[player] -= hp;
            if(playerLife[player] <= 0){
                Context c = getApplicationContext();
                Toast toast = Toast.makeText(c, "Player "+player+" LOSES!", Toast.LENGTH_LONG);
                toast.show();
            }
        }else{
            playerLife[player] += hp;
        }
        updateLives();
    }

    private void updateLives(){
        for(int i=1; i<playerlifestat.length; i++){
            playerlifestat[i].setText(""+playerLife[i]);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
