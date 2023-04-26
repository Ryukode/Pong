package de.hsos.prog3.pong.ui;

import de.hsos.prog3.pong.util.Interaktionsbrett;

public class Rechteck {
    private int x;
    private int y;
    private int hoehe;
    private int breite;

    public Rechteck(int x, int y, int hoehe, int breite) {
        setX(x);
        setY(y);
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public void setX(int x) {
        if(x < 0){
            this.x = 0;
        }else{
            this.x = x;
        }
    }

    public void setY(int y) {
        if(y < 0){
            this.y = 0;
        }else{
            this.y = y;
        }
    }

    public int oben(){
        return y;
    }
    public int unten(){
        return y + hoehe;
    }
    public int links(){
        return x;
    }
    public int rechts(){
        return x + breite;
    }
    public int breite(){
        return breite;
    }
    public int hoehe(){
        return hoehe;
    }
    public int mitteInY(){
        return (2*y + hoehe)/2;
    }
    public int mitteInX(){
        return (2*x + breite)/2;
    }
    public void verschiebe(int dx, int dy){
        this.setX(x+dx);
        this.setY(y+dy);
    }
    public void verschiebeNach(int x, int y){
        this.setX(x);
        this.setY(y);
    }
    public boolean ueberschneidet(Rechteck o){
        if(this.rechts() >= o.links() && this.links() <= o.rechts()){
            if(this.unten() >= o.oben() && this.oben() <= o.unten()){
                return true;
            }
        }
        return false;
    }

    public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(x, y, breite, hoehe);
    }
    public void darstellenFuellung(Interaktionsbrett ib){
        for(int i = 1; i < breite; ++i){
            ib.neueLinie(x + i, y, x + i, y + hoehe);
        }
    }
}
