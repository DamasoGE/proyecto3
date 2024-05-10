package programacion.piano.teclas;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.CapaFondo;
import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import programacion.piano.programa.PianoSencillo;

import java.awt.*;

public class ElementoVisualTester {
    private Graphics graphics;
    private ElementoVisual elemento;
    public ElementoVisualTester(Graphics g, ElementoVisual e){
        this.graphics = g;
        this.elemento= e;
    }
    public ElementoVisualTester(ElementoVisual e){
        Consola consola = new Consola();
        CapaCanvas capaCanvas = consola.getCapaCanvas();
        CapaFondo capaFondo = consola.getCapaFondo();
        capaFondo.setFondo(new FondoColorSolido(Color.GRAY));
        this.graphics = capaCanvas.getGraphics();
        e.setGraphics(this.graphics);
        this.elemento = e;
    }
    public void hacerPrueba(){
        this.elemento.setPosicion(120,90);
        this.elemento.setGraphics(this.graphics);
        this.elemento.dibujar();
        if (this.elemento instanceof Pulsable pulsable){
            pulsable.setColorPulsado(Color.BLUE);
            try {
                Thread.sleep(2000);
                pulsable.pulsar();
                pulsable.dibujar();
                Thread.sleep(2000);
                pulsable.soltar();
                pulsable.dibujar();
                Thread.sleep(2000);
            } catch (InterruptedException e) { }
        }
    }
    public static void main(String[] args){
        ElementoVisualTester elementoVisualTester = new ElementoVisualTester(new TeclaNegra(60));
        elementoVisualTester.hacerPrueba();
    }
}
