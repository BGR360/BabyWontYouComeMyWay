package com.example.ben.babywontyoucomemyway;

import android.media.MediaPlayer;

/**
 * Created by Ben on 10/8/15.
 *
 * A small wrapper for the Android MediaPlayer class.
 * I want to use the static method MediaPlayer.create(), but that method is executed synchronously,
 * and Android recommends you call MediaPlayer.prepare() asynchronously. So, the constructor of this
 * class delegates the creation of the MediaPlayer to an AsyncTask
 */
public class SoundPlayer extends MediaPlayer
{

}
