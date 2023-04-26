package de.hsos.prog3.pong.logik;

import de.hsos.prog3.pong.ui.Rechteck;
import de.hsos.prog3.pong.util.Interaktionsbrett;

public class Spieler {
    private Spielfeld spielfeld;
    public Rechteck schlaeger;
    private int punkte;
    static int player = 0;
    public Spieler(Spielfeld spielfeld, int x, int y){
        this.spielfeld = spielfeld;
        this.schlaeger = new Rechteck(x, y, spielfeld.hoehe / 10, spielfeld.breite / 100);
    }
    public void darstellen(Interaktionsbrett ib){
        schlaeger.darstellenRahmen(ib);
        schlaeger.darstellenFuellung(ib);
    }
    public int getPunkte(){
        return this.punkte;
    }
    public void aufwaerts(){
        if(schlaeger.oben() > spielfeld.margin + 25){
            schlaeger.verschiebe(0, -25);
        }else{
            schlaeger.verschiebe(0, spielfeld.margin - schlaeger.oben());
        }
    }
    public void abwaerts(){
        if(schlaeger.unten() < spielfeld.hoehe + spielfeld.margin - 25){
            schlaeger.verschiebe(0, 25);
        }else{
            schlaeger.verschiebe(0, spielfeld.hoehe + spielfeld.margin - schlaeger.oben() - schlaeger.hoehe());
        }
    }
    public void erhoehePunkte(){
        ++punkte;
    }
    public void setzePunkteZurueck(){
        punkte = 0;
    }
}
