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
        return pianos.get(canal).getTecla(canal, nota);
    }

    @Override
    public void dibujar() {
        int columnas = 2;
        for (int i = 0; i < pianos.size(); i++) {
            PianoSencillo piano = pianos.get(i);
            int fila = i / columnas;
            int col = i % columnas;
            piano.setPosicion(posicion.x + col * piano.getAnchura(), posicion.y + fila * piano.getAltura());
            piano.dibujar();
        }
    }

}
