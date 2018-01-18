package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Locate the basketball button in activity_main.xml
        button1 = (Button) findViewById(R.id.homepage_button1);

        //Capture basketball button click
        button1.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                //Start NewActivity class
                Intent myIntent = new Intent(MainActivity.this,BaseballCounterActivity.class);
                startActivity(myIntent);
            }
        });

        // Locate the basketball button in activity_main.xml
        button2 = (Button) findViewById(R.id.homepage_button2);

        //Capture basketball button click
        button2.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                //Start NewActivity class
                 Intent myIntent = new Intent(MainActivity.this,BasketballCounterActivity.class);
                 startActivity(myIntent);
            }
        });

        // Locate the basketball button in activity_main.xml
        button3 = (Button) findViewById(R.id.homepage_button3);

        //Capture basketball button click
        button3.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                //Start NewActivity class
                Intent myIntent = new Intent(MainActivity.this,FootballCounterActivity.class);
                startActivity(myIntent);
            }
        });

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
