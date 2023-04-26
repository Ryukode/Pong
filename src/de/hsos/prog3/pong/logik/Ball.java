package de.hsos.prog3.pong.logik;

import de.hsos.prog3.pong.ui.Rechteck;
import de.hsos.prog3.pong.util.Interaktionsbrett;

public class Ball {
    public Rechteck form;
    private int bewegungInXProFrame;
    private int bewegungInYProFrame;
    public Ball(int x, int y){
        this.form = new Rechteck(x, y, 10, 10);
        this.bewegungInXProFrame = 4;
        this.bewegungInYProFrame = 1;
    }
    public void incrementSpeed(){
        if(bewegungInXProFrame > 4){
            this.bewegungInXProFrame += 1;
            this.bewegungInYProFrame += 1;
        }else{
            this.bewegungInXProFrame += 1;
        }

    }
    public void decrementSpeed(){
        if(bewegungInXProFrame > 4){
            this.bewegungInXProFrame -= 1;
            this.bewegungInYProFrame -= 1;
        }else{
            if(bewegungInXProFrame > 1){
                this.bewegungInXProFrame -= 1;
            }
        }

    }
    public void umkehrenDerBewegungInX(){
        bewegungInXProFrame *= -1;
    }
    public void umkehrenDerBewegungInY(){
        bewegungInYProFrame *= -1;
    }
    public void darstellen(Interaktionsbrett ib){
        form.darstellenRahmen(ib);
        form.darstellenFuellung(ib);
    }
    public void bewegen(int anzahlFrames){
        for(int i = -1; i < anzahlFrames; ++i){
            form.verschiebe(bewegungInXProFrame, bewegungInYProFrame);
        }
    }

    public int getBewegungInXProFrame() {
        return bewegungInXProFrame;
    }

    public int getBewegungInYProFrame() {
        return bewegungInYProFrame;
    }
}
