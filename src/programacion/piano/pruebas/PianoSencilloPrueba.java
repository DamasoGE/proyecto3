package programacion.piano.pruebas;

import programacion.piano.programa.PianoSencillo;
import programacion.piano.teclas.ElementoVisualTester;

public class PianoSencilloPrueba {

    public static void main(String[] args) {
        PianoSencillo p = new PianoSencillo(36,72);
        p.setPosicion(20,20);
        ElementoVisualTester evt = new ElementoVisualTester(p);
        evt.hacerPrueba();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}