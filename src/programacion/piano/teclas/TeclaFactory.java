package programacion.piano.teclas;

public class TeclaFactory {
    private TeclaFactory(){

    }
    public static Tecla crearTecla(int nota){
        Tecla teclacreada;
        int resto = nota%12;
        if(resto==0 || resto==5){
            teclacreada = new TeclaBlanca1(nota);
        }else if(resto==2 || resto==7 || resto==9){
            teclacreada = new TeclaBlanca2(nota);
        }else if(resto==4 || resto==11){
            teclacreada = new TeclaBlanca3(nota);
        }else{
            teclacreada = new TeclaNegra(nota);
        }
        return teclacreada;
    }
}
