package programacion.piano.programa;

import static org.junit.Assert.*;

public class PianoSencilloTest {
    public static void main(String[] args) {
        Piano p = new PianoSencillo(36, 48);
        assertEquals(p.getAnchura(), 325);
        assertEquals(p.getAltura(), 100);
    }

}