package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BasketballCounterActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_counter);
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
     * This method is called when the activity is restarted to restore the
     * saved state of the activity including scoring parameters and display values.
     * @param savedInstanceState Bundle containing teams' saved scores to be
     *                           restored.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        scoreTeamA = savedInstanceState.getInt("scoreAVar");
        scoreTeamB = savedInstanceState.getInt("scoreBVar");

        final TextView scoreAView = findViewById(R.id.team_a_score);
        CharSequence scoreAText = savedInstanceState.getCharSequence("savedScoreAText");
        scoreAView.setText(scoreAText);

        final TextView scoreBView = findViewById(R.id.team_b_score);
        CharSequence scoreBText = savedInstanceState.getCharSequence("savedScoreBText");
        scoreBView.setText(scoreBText);
    }

    /**
     * This method is called in order to retain the state of the values for each
     * scoring parameter and the values displayed in the app prior to the activity
     * being killed.
     * @param outState Bundle to which instance of teams' scores will be saved.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("scoreAVar",scoreTeamA);
        outState.putInt("scoreBVar",scoreTeamB);

        final TextView scoreAView = findViewById(R.id.team_a_score);
        CharSequence scoreAText = scoreAView.getText();
        outState.putCharSequence("savedScoreAText",scoreAText);

        final TextView scoreBView = findViewById(R.id.team_b_score);
        CharSequence scoreBText = scoreBView.getText();
        outState.putCharSequence("savedScoreBText",scoreBText);
    }

    /**
     * This method is called when clicking one of the score buttons
     * for Team A.
     */
    public void incrementScoreTeamA(View view){
        switch (view.getId()){
            case R.id.team_a_3pt_button :
                scoreTeamA += 3;
                break;
            case R.id.team_a_2pt_button :
                scoreTeamA += 2;
                break;
            case R.id.team_a_ft_button :
                scoreTeamA += 1;
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
            case R.id.team_b_3pt_button :
                scoreTeamB += 3;
                break;
            case R.id.team_b_2pt_button :
                scoreTeamB += 2;
                break;
            case R.id.team_b_ft_button :
                scoreTeamB += 1;
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
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.format("%03d",score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.format("%03d",score));
    }

}
