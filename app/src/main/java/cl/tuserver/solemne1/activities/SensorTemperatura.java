package cl.tuserver.solemne1.activities;

import java.io.Serializable;
import java.util.Random;

public class SensorTemperatura extends Thread implements Serializable {
    public static double TEMPERATURA_ACTUAL = 0.0;
    private Random rand;

    public SensorTemperatura(){
        rand = new Random(256);
        this.setDaemon(true);
    }

    // Obtener valor de la temperatura
    public final double getTemperaturaActual(){
        return SensorTemperatura.TEMPERATURA_ACTUAL;
    }

    // Alterar valor de la temperatura
    public final void setTemperaturaActual(double nuevaTemperatura){
        SensorTemperatura.TEMPERATURA_ACTUAL += nuevaTemperatura;
    }

    @Override
    public void run(){
        while(true){
            try{
                TEMPERATURA_ACTUAL = rand.nextDouble()*100;
                System.out.println(String.format("Temperatura actual: %f", TEMPERATURA_ACTUAL));
                Thread.sleep(5000);
            }
            catch (InterruptedException ex){
                System.out.println("Thread say\'s: " + ex.getMessage());
            }
        }
    }
}