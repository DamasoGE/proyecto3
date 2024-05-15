package programacion.piano.programa;

import programacion.piano.teclas.Tecla;

import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano {
    private List<PianoSencillo> pianos;
    public MultiPiano(int ti, int tf) {
        super(ti, tf);
        PianoSencillo ps = new PianoSencillo(ti,tf);
        pianos = new ArrayList<>();

        for (int i = 0; i < 16 ; i++) {
            pianos.add(ps);
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        Tecla tecla;
        return tecla;
    }

    @Override
    public void dibujar() {
        pianos.get(1).dibujar();
    }

    @Override
    public int getAnchura() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }
}
