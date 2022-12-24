package main.controllers;

import main.controllers.bases.BaseController;
import main.model.MainModel;
import yahtzee.views.MainView;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.Objects;

// free music was taken from: https://www.youtube.com/watch?v=DVEUcbPkb-c
public class MusicController extends BaseController {

    public MusicController(MainView view, MainModel model, MainController controller) {
        super(view, model);
        startBackgroundSong();
    }

    public void startBackgroundSong() {
        playSound("music/background_song.wav", true, false);
    }


    public void playSound(String soundDir, boolean loop, boolean pitchViration){

        try {
            Clip clip = AudioSystem.getClip();
            URL url = Objects.requireNonNull(getClass().getClassLoader().getResource(soundDir));
            clip.open(AudioSystem.getAudioInputStream(url));

            if (pitchViration) {
                // https://docs.oracle.com/javase/7/docs/api/javax/sound/sampled/AudioSystem.html
                // todo maybe write some code that slightly changes the sound, so the voice doesnt
                // always sound the same
            }

            clip.start();

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void playRollSound() {
        playSound("sounds/roll_dice.wav", false, true);
    }

}
