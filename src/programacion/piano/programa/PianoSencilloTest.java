package programacion.piano.programa;

import org.junit.Test;

import static org.junit.Assert.*;

public class PianoSencilloTest {

    @Test
    public void test1(){

        PianoSencillo pianoSencillo=new PianoSencillo(36,48);

        assertEquals(200,pianoSencillo.getAnchura());
        assertEquals(100,pianoSencillo.getAltura());

    }

}