package com.example.matchgamesample.dialog;

import android.view.View;
import android.widget.ImageButton;

import com.example.matchgamesample.MainActivity;
import com.example.matchgamesample.R;
import com.example.matchgamesample.Utils;

public class PauseDialog extends BaseDialog implements View.OnClickListener {

    private PauseDialogListener mListener;
    private int mSelectedId;

    public PauseDialog(MainActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_pause);

        // Init button
        ImageButton btnMusic = (ImageButton) findViewById(R.id.btn_music);
        btnMusic.setOnClickListener(this);
        Utils.createButtonEffect(btnMusic);
        ImageButton btnSound = (ImageButton) findViewById(R.id.btn_sound);
        btnSound.setOnClickListener(this);
        Utils.createButtonEffect(btnSound);
        ImageButton btnQuit = (ImageButton) findViewById(R.id.btn_quit);
        btnQuit.setOnClickListener(this);
        Utils.createButtonEffect(btnQuit);
        ImageButton btnResume = (ImageButton) findViewById(R.id.btn_resume);
        btnResume.setOnClickListener(this);
        Utils.createButtonEffect(btnResume);

        updateSoundAndMusicButtons();
    }

    private void updateSoundAndMusicButtons() {
        /*
        SoundManager soundManager = mParent.getSoundManager();
        boolean music = soundManager.getMusicStatus();
        ImageView btnMusic = (ImageView) findViewById(R.id.btn_music);
        if (music) {
            btnMusic.setImageResource(R.drawable.music_on_no_bg);
        }
        else {
            btnMusic.setImageResource(R.drawable.music_off_no_bg);
        }
        boolean sound = soundManager.getSoundStatus();
        ImageView btnSounds= (ImageView) findViewById(R.id.btn_sound);
        if (sound) {
            btnSounds.setImageResource(R.drawable.sounds_on_no_bg);
        }
        else {
            btnSounds.setImageResource(R.drawable.sounds_off_no_bg);
        }

         */
    }

    public void setListener(PauseDialogListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sound) {
            //mParent.getSoundManager().toggleSoundStatus();
            updateSoundAndMusicButtons();
        } else if (view.getId() == R.id.btn_music) {
            //mParent.getSoundManager().toggleMusicStatus();
            updateSoundAndMusicButtons();
        } else if (view.getId() == R.id.btn_quit) {
            mSelectedId = view.getId();
            super.dismiss();
        } else if (view.getId() == R.id.btn_resume) {
            mSelectedId = view.getId();
            super.dismiss();
        }
    }

    @Override
    protected void onDismissed() {
        if (mSelectedId == R.id.btn_quit) {
            mListener.quitGame();
        } else if (mSelectedId == R.id.btn_resume) {
            mListener.resumeGame();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mSelectedId = R.id.btn_resume;
    }

    public interface PauseDialogListener {

        void quitGame();

        void resumeGame();
    }
}

