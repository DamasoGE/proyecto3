package programacion.piano.pruebas;

import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import programacion.piano.teclas.ElementoVisualTester;
import programacion.piano.teclas.Tecla;
import programacion.piano.teclas.TeclaFactory;

import java.awt.*;

public class TeclaFactoryPruebas {
    public static void main(String[] args) {
        Consola consola = new Consola();
        ElementoVisualTester elemento;
        Tecla tecla;
        consola.getCapaFondo().setFondo(new FondoColorSolido(Color.GRAY));
        for(int i=60; i<=64; i++){
            elemento = new ElementoVisualTester(consola.getCapaCanvas().getGraphics(), TeclaFactory.crearTecla(i));
            elemento.hacerPrueba();
        }
    }
}
