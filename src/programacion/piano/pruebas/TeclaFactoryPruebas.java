package programacion.piano.pruebas;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.CapaFondo;
import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import programacion.piano.teclas.*;

import java.awt.*;

public class TeclaFactoryPruebas {
    public static void main(String[] args) {
        int posicionx=20;
        Consola consola = new Consola();
        consola.getCapaFondo().setFondo(new FondoColorSolido(Color.GRAY));
        Tecla[] tecla = new Tecla[70];

        for(int i=60; i<=64; i++){
            tecla[i] = TeclaFactory.crearTecla(i);
            tecla[i].setGraphics(consola.getCapaCanvas().getGraphics());
            tecla[i].setPosicion(posicionx,20);
            if(tecla[i] instanceof TeclaBlanca1){
                posicionx+=TeclaNegra.ANCHURA;
            }else if(tecla[i] instanceof TeclaBlanca2){
                posicionx+=TeclaNegra.ANCHURA;
            }else if(tecla[i] instanceof TeclaBlanca3){
                posicionx+=TeclaNegra.ANCHURA/2;
            }else{
                posicionx+=TeclaNegra.ANCHURA/2;
            }

            tecla[i].dibujar();
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
