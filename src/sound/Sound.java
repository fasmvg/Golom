package sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip moveSound;
    private Clip captureSound;

    public Sound() {
        loadSounds();
    }

    private void loadSounds() {
        try {
            moveSound = loadSound("res/sound/move-self.wav");
            captureSound = loadSound("res/sound/capture.wav");
        } catch (Exception e) {
            System.out.println("Erro ao carregar sons: " + e.getMessage());
        }
    }

    private Clip loadSound(String path) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File soundFile = new File(path);
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        return clip;
    }

    public void playMove() {
        playSound(moveSound);
    }

    public void playCapture() {
        playSound(captureSound);
    }

    private void playSound(Clip clip) {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
}
