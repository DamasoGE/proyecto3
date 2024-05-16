package programacion.piano.programa;

import programacion.piano.teclas.Tecla;

import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES = {
            Color.RED, Color.GREEN, Color.BLACK, Color.WHITE,
            Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA,
            Color.GRAY, Color.PINK, Color.ORANGE, Color.LIGHT_GRAY,
            Color.DARK_GRAY,
            new Color(23, 217, 131),
            new Color(180, 131, 78),
            new Color(70, 102, 154)
    };
    private Piano piano;

    public ReproductorMidi(){
        this.piano = null;
    }
    public void reproducir(String ruta){
        try {
            File file = new File(ruta);
            Sequence sequence = MidiSystem.getSequence(file);
            this.conectar(piano);
            Sequencer sequencer =MidiSystem.getSequencer();
            sequencer.open();
            Transmitter transmitter = sequencer.getTransmitter();
            transmitter.setReceiver(this);
            sequencer.setSequence(sequence);
            sequencer.start();
            Thread.sleep(sequence.getMicrosecondLength());
            transmitter.close();
            sequencer.close();

        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void conectar(Piano p){
        this.piano=p;
    }
    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage shortMessage) {
            int canal = shortMessage.getChannel();
            int nota = shortMessage.getData1();
            int volumen = shortMessage.getData2();
            int comando = shortMessage.getCommand();

            if (canal != 9) {
                Tecla tecla = this.piano.getTecla(canal, nota);
                if (tecla!=null){
                    if (comando == ShortMessage.NOTE_ON && volumen > 0) {
                        tecla.pulsar();
                        tecla.setColorPulsado(COLORES[canal]);
                    } else if (comando == ShortMessage.NOTE_OFF || (comando == ShortMessage.NOTE_ON && volumen == 0)) {
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
