package de.hsos.prog3.pong.logik;

import de.hsos.prog3.pong.util.*;
public class PongSpiel {
    private Spielfeld spielfeld;
    private Spieler spielerLinks, spielerRechts;
    private Ball ball;
    private KollisionsDetektion detektor;
    private Interaktionsbrett ib;
    private static int FPMS = 17;
    private boolean dontStart = true;

    public PongSpiel (){
        this.ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        this.startaufstellung();
    }

    private void startaufstellung(){
        this.spielfeld = new Spielfeld();
        this.spielerLinks = new Spieler(this.spielfeld, 60, spielfeld.hoehe / 2);
        this.spielerRechts = new Spieler(this.spielfeld, 650, spielfeld.hoehe/2);
        this.ball = new Ball(spielerLinks.schlaeger.mitteInX() + 20, spielerLinks.schlaeger.mitteInY());
        this.detektor = new KollisionsDetektion(this.spielerLinks, this.spielerRechts, this.spielfeld);
    }
    public void tasteGedrueckt(String s){
        switch (s){
            case "e":
                System.out.println("pressed e");
                System.exit(0);
                break;
            case "w":
                System.out.println("pressed a");
                spielerLinks.aufwaerts();
                break;
            case "s":
                System.out.println("pressed y");
                spielerLinks.abwaerts();
                break;
            case "p":
                System.out.println("pressed Oben");
                spielerRechts.aufwaerts();
                break;

            case "l":
                System.out.println("pressed Unten");
                spielerRechts.abwaerts();
                break;
            case "+":
                System.out.println("pressed +");
                ball.incrementSpeed();
                break;
            case "-":
                System.out.println("pressed -");
                ball.decrementSpeed();
                break;
        }
    }
    private void changeInScore(BallPosition pos){
        switch (pos){
            case DRAUSSEN_LINKS  : spielerRechts.erhoehePunkte();
            ball.form.verschiebeNach(spielerLinks.schlaeger.rechts(), spielerLinks.schlaeger.mitteInY());
            break;
            case DRAUSSEN_RECHTS : spielerLinks.erhoehePunkte();
                ball.form.verschiebeNach(spielerRechts.schlaeger.links(), spielerRechts.schlaeger.mitteInY());
        }
    }
    public void spielen(){
        long dtime;
        while(true){
            dtime = System.currentTimeMillis();
            //Elemente darstellen
            ib.abwischen();
            spielfeld.darstellen(ib);
            spielerLinks.darstellen(ib);
            spielerRechts.darstellen(ib);
            ball.darstellen(ib);
            //Ball bewegen, Kollisionen berechnen
            ball.bewegen((int)(System.currentTimeMillis() - dtime)/FPMS);
            detektor.checkBeruehrungBallSpielfeldGrenzen(ball);
            detektor.checkBeruehrungBallMitSchlaeger(ball);
            //Score anpassen falls nötig
            changeInScore(detektor.checkAusserhalbDesSpielfeldes(ball));
            //15 Punkte Abbruchbedingung
            if(spielerRechts.getPunkte() > 14 || spielerLinks.getPunkte() > 14){
                System.exit(1);
            }
            ib.neuerText((650 + 60) / 2 - 15, 25, spielerLinks.getPunkte() + "");
            ib.neuerText((650 + 60) / 2 + 15, 25, spielerRechts.getPunkte() + "");
            dtime = System.currentTimeMillis() - dtime;
            if(dtime < FPMS){
                try{
                    Thread.sleep(FPMS - dtime);
                }catch(InterruptedException e){
                    System.err.println("Oh no what do i do! (Interrupted Exception in Game Loop.)");
                }
            }


        }
    }
}
