package programacion.piano.programa;

import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args){
        Consola consola = new Consola();
        consola.getCapaFondo().setFondo(new FondoColorSolido(0,0,70));
        System.out.println("Introduce la ruta del archivo midi:");
        String ruta = new Scanner(System.in).nextLine();
        PianoSencillo pianoSencillo = new PianoSencillo(24,108);
        pianoSencillo.setGraphics(consola.getCapaCanvas().getGraphics());
        pianoSencillo.setPosicion(120,90);
        ReproductorMidi reproductorMidi = new ReproductorMidi();
        reproductorMidi.conectar(pianoSencillo);
        reproductorMidi.reproducir(ruta);
    }
}
