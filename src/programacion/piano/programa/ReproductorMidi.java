package programacion.piano.programa;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import java.awt.*;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES = {
            Color.BLACK, Color.WHITE, Color.RED, Color.GREEN,
            Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA,
            Color.GRAY, Color.PINK, Color.ORANGE, Color.LIGHT_GRAY,
            Color.DARK_GRAY,
            new Color(23, 217, 131),
            new Color(180, 131, 78),
            new Color(70, 102, 154)
    };
    private Piano piano;

    public ReproductorMidi(){
        throw new IllegalArgumentException();
    }
    public void reproducir(String ruta){
        throw new IllegalArgumentException();
    }
    public void conectar(Piano p){
        throw new IllegalArgumentException();
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        throw new IllegalArgumentException();

    }

    @Override
    public void close() {
        throw new IllegalArgumentException();
    }
}
