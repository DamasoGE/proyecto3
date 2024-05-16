package programacion.piano.programa;

import programacion.piano.teclas.Tecla;
import programacion.piano.teclas.TeclaBlanca;

import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano {
    private List<PianoSencillo> pianos;
    public MultiPiano(int ti, int tf) {
        super(ti, tf);

        pianos = new ArrayList<>();

        for (int i = 0; i < 16 ; i++) {
            pianos.add( new PianoSencillo(ti,tf));
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        Tecla tecla= null;
        if (canal >= 0 && canal < pianos.size()) {
            tecla= pianos.get(canal).getTecla(canal, nota);
        }
        return tecla;
    }

    @Override
    public void dibujar() {
        int posx=25;
        int posy=15;

        for (int i = 0; i < pianos.size(); i++) {
            pianos.get(i).setGraphics(this.graphics);
            if(i%2==0){
                pianos.get(i).setPosicion(posx, posy);
            }else{
                pianos.get(i).setPosicion(posx+this.pianos.get(i).getAnchura(), posy);
                posy+= TeclaBlanca.ALTURA+5;
            }
            pianos.get(i).dibujar();
        }

    }

}
