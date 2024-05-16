package programacion.piano.programa;

import programacion.piano.teclas.Tecla;

import javax.sound.midi.*;
import java.awt.*;
import java.io.File;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES = {Color.BLACK, Color.WHITE, Color.RED, Color.GREEN,
            Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA,
            Color.GRAY, Color.PINK, Color.ORANGE, Color.LIGHT_GRAY,
            Color.DARK_GRAY,
            new Color(23, 217, 131),
            new Color(180, 131, 78),
            new Color(70, 102, 154)};
    private Piano piano;

    public ReproductorMidi() {
        this.piano = null;
    }

    public void conectar(Piano piano) {
        this.piano = piano;
    }

    public void reproducir(String ruta) {
        try {
            Sequence sequence = MidiSystem.getSequence(new File(ruta));
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Transmitter transmitter = sequencer.getTransmitter();
            transmitter.setReceiver(this);
            sequencer.setSequence(sequence);
            sequencer.start();
            Thread.sleep(sequence.getMicrosecondLength() / 1000);
            transmitter.close();
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage) {
            ShortMessage shortMessage = (ShortMessage) message;
            int canal = shortMessage.getChannel();
            if (canal != 9) {
                int nota = shortMessage.getData1();
                Tecla tecla = this.piano.getTecla(canal,nota);
                if (tecla != null) {
                    if (  shortMessage.getCommand()== ShortMessage.NOTE_ON) {
                        if (shortMessage.getData2() > 0) {
                            tecla.setColorPulsado(COLORES[canal]);
                            tecla.pulsar();
                        } else {
                            tecla.soltar();
                        }
                    } else if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
                        tecla.soltar();
                    }
                    tecla.dibujar();
                }
            }
        }
    }

    @Override
    public void close() {

    }
}
