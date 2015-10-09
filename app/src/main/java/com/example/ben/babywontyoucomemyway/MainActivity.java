package com.example.ben.babywontyoucomemyway;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
                                                               MediaPlayer.OnPreparedListener
{

    Button babyButton, wantToSayButton, spawButton, gawdamButton, stopButton;
    SoundPlayer babyPlayer, wantToSayPlayer, spawPlayer, gawdamPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        if (bar != null)
            bar.setTitle(R.string.toolbar_title);

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
        wantToSayButton = (Button) findViewById(R.id.want_to_say_button);
        spawButton = (Button) findViewById(R.id.spaw_button);
        gawdamButton = (Button) findViewById(R.id.gawdam_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        babyButton.setOnClickListener(this);
        wantToSayButton.setOnClickListener(this);
        spawButton.setOnClickListener(this);
        gawdamButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

        // Don't let them click until the media is loaded
        babyButton.setClickable(false);
        wantToSayButton.setClickable(false);
        spawButton.setClickable(false);
        gawdamButton.setClickable(false);
        stopButton.setClickable(false);

        babyPlayer = new SoundPlayer(this, R.raw.baby, this);
        wantToSayPlayer = new SoundPlayer(this, R.raw.want_to_say, this);
        spawPlayer = new SoundPlayer(this, R.raw.spaw, this);
        gawdamPlayer = new SoundPlayer(this, R.raw.gawdam_gawdam, this);

        // Allow user to use volume buttons to control playback volume
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        stopAudio();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        // Have to actually call stop() on the MediaPlayers
        babyPlayer.stop();
        wantToSayPlayer.stop();
        spawPlayer.stop();
        gawdamPlayer.stop();

        // Have to release all instances of MediaPlayer
        babyPlayer.release();
        wantToSayPlayer.release();
        spawPlayer.release();
        gawdamPlayer.release();
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
        stopAudio();
        babyPlayer.seekTo(0);
        babyPlayer.start();
    }

    public void playGotSomethingIWantToSay()
    {
        stopAudio();
        wantToSayPlayer.seekTo(0);
        wantToSayPlayer.start();
    }

    public void playSpaw()
    {
        stopAudio();
        spawPlayer.seekTo(0);
        spawPlayer.start();
    }

    public void playGawdam()
    {
        stopAudio();
        gawdamPlayer.seekTo(0);
        gawdamPlayer.start();
    }

    public void stopAudio()
    {
        if (babyPlayer.isPlaying())
        {
            babyPlayer.pause();
        }
        if (wantToSayPlayer.isPlaying())
        {
            wantToSayPlayer.pause();
        }
        if (spawPlayer.isPlaying())
        {
            spawPlayer.pause();
        }
        if (gawdamPlayer.isPlaying())
        {
            gawdamPlayer.pause();
        }
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
            else if (v == wantToSayButton)
            {
                playGotSomethingIWantToSay();
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

    @Override
    public void onPrepared(MediaPlayer mp)
    {
        if (mp == babyPlayer)
        {
            babyButton.setClickable(true);
        }
        else if (mp == wantToSayPlayer)
        {
            wantToSayButton.setClickable(true);
        }
        else if (mp == spawPlayer)
        {
            spawButton.setClickable(true);
        }
        else if (mp == gawdamPlayer)
        {
            gawdamButton.setClickable(true);
        }

        if (!stopButton.isClickable())
            stopButton.setClickable(true);
    }
}
