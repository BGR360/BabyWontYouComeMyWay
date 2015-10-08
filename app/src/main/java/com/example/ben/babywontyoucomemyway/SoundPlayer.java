package com.example.ben.babywontyoucomemyway;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.annotation.IdRes;
import android.widget.Toast;

/**
 * Created by Ben on 10/8/15.
 *
 * A small wrapper for the Android MediaPlayer class.
 * Takes in the resource id of a sound clip and asynchronously creates an instance of
 * MediaPlayer for the sound clip
 */
public class SoundPlayer extends MediaPlayer implements MediaPlayer.OnErrorListener
{
    private Context mContext;

    public SoundPlayer(Context context, @IdRes int resId)
    {
        mContext = context;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra)
    {
        Toast toast = new Toast(mContext);
        Resources res = mContext.getResources();

        if (what == MEDIA_ERROR_UNKNOWN)
        {
            switch (extra)
            {
            case MEDIA_ERROR_IO:
                toast.setText(R.string.media_error_io);
                break;

            case MEDIA_ERROR_MALFORMED:
                toast.setText(R.string.media_error_malformed);
                break;

            case MEDIA_ERROR_TIMED_OUT:
                toast.setText(R.string.media_error_timed_out);
                break;

            case MEDIA_ERROR_UNSUPPORTED:
                toast.setText(R.string.media_error_unsupported);
                break;

            default:
                toast.setText(R.string.media_error_unknown);
                break;
            }
        }
        else if (what == MEDIA_ERROR_SERVER_DIED)
        {
            toast.setText(res.getString(R.string.media_error_server_died));

            // Media server died. In this case, the application must release the MediaPlayer
            // object and instantiate a new one.
            release();
        }

        // Show the Toast
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        return true;
    }
}
