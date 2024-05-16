package programacion.piano.programa;

import programacion.piano.teclas.Tecla;
import programacion.piano.teclas.TeclaBlanca;

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
        int posy=20;

        pianos.get(0).setGraphics(this.graphics);
        pianos.get(0).setPosicion(0, 0);
        pianos.get(0).dibujar();


        /*
        for (int i = 0; i < pianos.size(); i++) {
            pianos.get(i).setGraphics(this.graphics);
            if(i%2==0){
                pianos.get(i).setPosicion(posx, posy);
            }else{
                pianos.get(i).setPosicion(posx+this.pianos.get(i).getAnchura(), posy);
            }
            pianos.get(i).dibujar();
            posy+= TeclaBlanca.ANCHURA;
        }
        */

    }

}
