package controller;

import model.MainModel;
import view.MainView;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.Objects;

// free music was taken from: https://www.youtube.com/watch?v=DVEUcbPkb-c
public class MusicController extends AbstractController{

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
                // todo maybe write some code that slightly changes the sound.
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
