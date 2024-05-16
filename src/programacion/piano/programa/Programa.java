package programacion.piano.programa;

import bpc.daw.consola.*;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args){
        Consola consola = new Consola();
        CapaTexto ct = consola.getCapaTexto();
        CapaCanvas cv = consola.getCapaCanvas();
        Teclado teclado = consola.getTeclado();
        consola.getCapaFondo().setFondo(new FondoColorSolido(0,0,70));
        ct.println("Introduce la ruta del archivo midi: ");
        String ruta = teclado.leerCadenaCaracteres();
        MultiPiano pianoSencillo = new MultiPiano(36,88);
        pianoSencillo.setGraphics(cv.getGraphics());
        pianoSencillo.dibujar();
        ReproductorMidi reproductorMidi = new ReproductorMidi();
        reproductorMidi.conectar(pianoSencillo);
        reproductorMidi.reproducir(ruta);
    }
}
