package programacion.piano.programa;

import programacion.piano.teclas.Tecla;

import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano{

    private Map<Integer, Tecla> teclas;

    public PianoSencillo(int teclaInicial, int teclaFinal){
        teclaInicial = 0;
        teclaFinal = 0;
        teclas = new HashMap<>();



    }

}
