package programacion.piano.programa;

import org.junit.Test;
import programacion.piano.teclas.ElementoVisualTester;

import static org.junit.Assert.*;

public class PianoSencilloTest {

    @Test
    public void test1(){
        PianoSencillo p = new PianoSencillo(36,72);
        p.setPosicion(20,20);
        ElementoVisualTester evt = new ElementoVisualTester(p);
        evt.hacerPrueba();
    }

}