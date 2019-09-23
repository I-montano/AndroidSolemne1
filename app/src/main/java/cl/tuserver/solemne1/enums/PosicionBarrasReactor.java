package cl.tuserver.solemne1.enums;

public enum PosicionBarrasReactor {
    SUMERGIDO, SEMI_SUMERGIDO, SUPERFICIE;

    private static PosicionBarrasReactor POSICION_ACTUAL;

    public static PosicionBarrasReactor getPosicionActual(){
        return PosicionBarrasReactor.POSICION_ACTUAL;
    }

    public static void setPosicionActual(PosicionBarrasReactor posicionActual){
        PosicionBarrasReactor.POSICION_ACTUAL = posicionActual;
    }
}