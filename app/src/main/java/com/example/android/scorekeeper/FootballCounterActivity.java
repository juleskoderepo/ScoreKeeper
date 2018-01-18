package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FootballCounterActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_counter);
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

    /**
     * This method is called when clicking one of the score buttons
     * for Team A.
     */
    public void incrementScoreTeamA(View view){
        switch (view.getId()){
            case R.id.team_a_td_button :
                scoreTeamA += 6;
                break;
            case R.id.team_a_pat_button :
                scoreTeamA += 1;
                break;
            case R.id.team_a_2ptconv_button :
                scoreTeamA += 2;
                break;
            case R.id.team_a_fg_button :
                scoreTeamA += 3;
                break;
            case R.id.team_a_safety_button :
                scoreTeamA += 2;
                break;
        }

        displayForTeamA(scoreTeamA);
    }

    /**
     * This method is called when clicking one of the score buttons
     * for Team A.
     */

    public void incrementScoreTeamB(View view){
        switch (view.getId()){
            case R.id.team_b_td_button :
                scoreTeamB += 6;
                break;
            case R.id.team_b_pat_button :
                scoreTeamB += 1;
                break;
            case R.id.team_b_2ptconv_button :
                scoreTeamB += 2;
                break;
            case R.id.team_b_fg_button :
                scoreTeamB += 3;
                break;
            case R.id.team_b_safety_button :
                scoreTeamB += 2;
                break;
        }

        displayForTeamB(scoreTeamB);
    }

    /**
     * This method is called when the reset button is clicked.
     */

    public void resetScores(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.format("%02d",score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.format("%02d",score));
    }

}
