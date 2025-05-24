package sound;

import javax.sound.sampled.*;
import java.io.InputStream;

public class Sound {
    private Clip moveSound;
    private Clip captureSound;

    public Sound() {
        loadSounds();
    }

    private void loadSounds() {
        try {
            InputStream pathCaptureSound = getClass().getResourceAsStream("/sound/capture.wav");
            captureSound = AudioSystem.getClip();
            assert pathCaptureSound != null;
            captureSound.open(AudioSystem.getAudioInputStream(pathCaptureSound));

            InputStream pathMoveSound = getClass().getResourceAsStream("/sound/move-self.wav");
            moveSound = AudioSystem.getClip();
            assert pathMoveSound != null;
            moveSound.open(AudioSystem.getAudioInputStream(pathMoveSound));
        } catch (Exception e) {
            System.out.println("Erro ao carregar sons: " + e.getMessage());
        }
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
