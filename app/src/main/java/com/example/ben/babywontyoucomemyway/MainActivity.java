package com.example.ben.babywontyoucomemyway;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    Button babyButton, spawButton, gawdamButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        babyButton = (Button) findViewById(R.id.baby_button);
        spawButton = (Button) findViewById(R.id.spaw_button);
        gawdamButton = (Button) findViewById(R.id.gawdam_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        babyButton.setOnClickListener(this);
        spawButton.setOnClickListener(this);
        gawdamButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void playBabyWontYouComeMyWay()
    {
        Toast.makeText(this, "Baby Won't You Come My Waaaaaay????1", Toast.LENGTH_SHORT).show();
    }

    public void playSpaw()
    {
        Toast.makeText(this, "SPAW!!", Toast.LENGTH_SHORT).show();
    }

    public void playGawdam()
    {
        Toast.makeText(this, "gawdam-gawdam", Toast.LENGTH_SHORT).show();
    }

    public void stopAudio()
    {
        Toast.makeText(this, "STOP", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v)
    {
        if (v != null)
        {
            if (v == babyButton)
            {
                playBabyWontYouComeMyWay();
            }
            else if (v == spawButton)
            {
                playSpaw();
            }
            else if (v == gawdamButton)
            {
                playGawdam();
            }
            else if (v == stopButton)
            {
                stopAudio();
            }
        }
    }
}
