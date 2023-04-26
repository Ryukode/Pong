package de.hsos.prog3.pong.logik;

import de.hsos.prog3.pong.ui.Rechteck;
import de.hsos.prog3.pong.util.Interaktionsbrett;

public class Spielfeld {
    public int breite = 700;
    public int hoehe = 600;
    public int margin = 10;
    public Rechteck spielfeld;

    public Spielfeld(){
        this.spielfeld = new Rechteck(margin, margin, hoehe, breite);
    }
    public void darstellen(Interaktionsbrett ib){
        spielfeld.darstellenRahmen(ib);
        ib.neueLinie(spielfeld.mitteInX(), spielfeld.oben(), spielfeld.mitteInX(), spielfeld.unten());
    }
}
