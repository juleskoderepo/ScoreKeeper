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
    String score_format = getString(R.string.format_two_digit_score);

    //Initializes the activity's user interface
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
     * This method is called when the activity is restarted to restore the
     * saved state of the activity including scoring parameters and display values.
     * @param savedInstanceState Bundle object containing teams' saved scores
     *                           to be restored.
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
     * @param outState Bundle object to which instance of teams' scores will be
     *                saved.
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
     * for Team B.
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
        TextView scoreAView = findViewById(R.id.team_a_score);
        scoreAView.setText(String.format(score_format,score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreBView = findViewById(R.id.team_b_score);
        scoreBView.setText(String.format(score_format,score));
    }

}
