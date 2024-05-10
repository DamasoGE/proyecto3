package programacion.piano.test;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;
import programacion.piano.programa.Piano;
import programacion.piano.programa.PianoSencillo;
import programacion.piano.teclas.ElementoVisualTester;

import java.awt.*;

public class PianoSencilloTest {

    public static void main(String[] args) {

        Piano piano=new PianoSencillo(36,72);
        Consola consola=new Consola();
        CapaCanvas capaCanvas=consola.getCapaCanvas();
        Graphics graphics=capaCanvas.getGraphics();
        ElementoVisualTester emt=new ElementoVisualTester(graphics,piano);
        emt.hacerPrueba();

    }


}