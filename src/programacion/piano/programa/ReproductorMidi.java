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
        if (message instanceof ShortMessage shortMessage){
            shortMessage.getChannel();
            if (shortMessage.getChannel()!=9){
                shortMessage.getData1();
                Tecla tecla = this.piano.getTecla(shortMessage.getChannel(), shortMessage.getData1());

                if ( tecla.getNumeroNota()== shortMessage.getData1()){
                    if (shortMessage.getCommand()== ShortMessage.NOTE_ON){
                        if ( shortMessage.getData2()>0){
                            tecla.setColorPulsado(COLORES[shortMessage.getCommand()]);
                            tecla.pulsar();
                        }
                        else{
                            tecla.soltar();
                        }
                    }
                        else{
                            if (shortMessage.getCommand()== ShortMessage.NOTE_OFF){
                                tecla.soltar();
                            }

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
