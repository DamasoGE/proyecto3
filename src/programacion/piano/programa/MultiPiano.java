package programacion.piano.programa;

import programacion.piano.teclas.Tecla;

import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano{

    List<PianoSencillo> pianos;

    public MultiPiano(int teclaInicial, int teclaFinal) {
        super(teclaInicial, teclaFinal);
        pianos = new ArrayList<>();


        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return null;
    }

    @Override
    public int getAnchura() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }

    @Override
    public void dibujar() {

    }
}
