package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BaseballCounterActivity extends AppCompatActivity {
    int runsTeamA = 0;
    int runsTeamB = 0;
    int hitsTeamA = 0;
    int hitsTeamB = 0;
    int errorsTeamA = 0;
    int errorsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_counter);
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
     * This method is called when clicking one of the runs buttons.
     */
    public void incrementRuns(View view){
        switch (view.getId()){
            case R.id.team_a_runs_button :
                runsTeamA += 1;

                displayRunsForTeamA(runsTeamA);
                break;
            case R.id.team_b_runs_button :
                runsTeamB += 1;

                displayRunsForTeamB(runsTeamB);
                break;
        }

    }

    /**
     * This method is called when clicking one of the hits buttons.
     */
    public void incrementHits (View view){
        switch (view.getId()){
            case R.id.team_a_hits_button :
                hitsTeamA += 1;

                displayHitsForTeamA(hitsTeamA);
                break;

            case R.id.team_b_hits_button :
                hitsTeamB += 1;

                displayHitsForTeamB(hitsTeamB);
                break;
        }
    }

    /**
     * This method is called when clicking one of the errors buttons.
     */
    public void incrementErrors (View view){
        switch (view.getId()){
            case R.id.team_a_errors_button :
                errorsTeamA += 1;

                displayErrorsForTeamA(errorsTeamA);
                break;

            case R.id.team_b_errors_button :
                errorsTeamB += 1;

                displayErrorsForTeamB(errorsTeamB);
                break;
        }
    }


    /**
     * This method is called when the reset button is clicked.
     */

    public void resetScoreboard(View view){
        runsTeamA = 0;
        hitsTeamA = 0;
        errorsTeamA = 0;
        runsTeamB = 0;
        hitsTeamB = 0;
        errorsTeamB = 0;

        displayRunsForTeamA(runsTeamA);
        displayHitsForTeamA(hitsTeamA);
        displayErrorsForTeamA(errorsTeamA);
        displayRunsForTeamB(runsTeamB);
        displayHitsForTeamB(hitsTeamB);
        displayErrorsForTeamB(errorsTeamB);

    }


    /**
     * Displays the given score for Team A.
     */
    public void displayRunsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_runs_text);
        scoreView.setText(String.format("%02d",score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayRunsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_runs_text);
        scoreView.setText(String.format("%02d",score));
    }

    /**
     * Displays the hits for Team A.
     */
    public void displayHitsForTeamA(int hits) {
        TextView hitsView = (TextView) findViewById(R.id.team_a_hits_text);
        hitsView.setText(String.format("%02d",hits));
    }

    /**
     * Displays the hits for Team B.
     */
    public void displayHitsForTeamB(int hits) {
        TextView hitsView = (TextView) findViewById(R.id.team_b_hits_text);
        hitsView.setText(String.format("%02d",hits));
    }

    /**
     * Displays the errors for Team A.
     */
    public void displayErrorsForTeamA(int e) {
        TextView eView = (TextView) findViewById(R.id.team_a_errors_text);
        eView.setText(String.format("%02d",e));
    }

    /**
     * Displays the hits for Team B.
     */
    public void displayErrorsForTeamB(int e) {
        TextView eView = (TextView) findViewById(R.id.team_b_errors_text);
        eView.setText(String.format("%02d", e));
    }

}
