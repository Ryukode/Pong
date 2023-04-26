package de.hsos.prog3.pong.logik;
import java.util.Random;

public class KollisionsDetektion {
    private Spielfeld spielfeld;
    private Spieler spielerLinks;
    private Spieler spielerRechts;
    private Random rand = new Random();
    public KollisionsDetektion(Spieler spielerLinks, Spieler spielerRechts, Spielfeld spielfeld){
        this.spielerLinks = spielerLinks;
        this.spielerRechts = spielerRechts;
        this.spielfeld = spielfeld;
    }
    public void checkBeruehrungBallSpielfeldGrenzen(Ball ball){
        if(ball.form.oben() == spielfeld.margin || ball.form.unten() == spielfeld.hoehe + spielfeld.margin){
            ball.umkehrenDerBewegungInY();
        }
    }
    public void checkBeruehrungBallMitSchlaeger(Ball ball){
        checkCollision(ball, spielerLinks);
        checkCollision(ball, spielerRechts);
    }

    private void checkCollision(Ball ball, Spieler spieler) {
        if(ball.form.links() <= spieler.schlaeger.rechts() && ball.form.rechts() >= spieler.schlaeger.links()){
            if(ball.form.oben() <= spieler.schlaeger.unten() && ball.form.unten() >= spieler.schlaeger.oben()){
                if(ball.getBewegungInXProFrame() > 0){
                    ball.form.verschiebeNach(spieler.schlaeger.links() - ball.form.breite(), ball.form.oben());
                }else{
                    ball.form.verschiebeNach(spieler.schlaeger.rechts(), ball.form.oben());
                }
                if(rand.nextDouble() * 100 > 75){
                    ball.umkehrenDerBewegungInY();
                }
                ball.umkehrenDerBewegungInX();
            }
        }
    }
    public BallPosition checkAusserhalbDesSpielfeldes(Ball ball){
        if(ball.form.links() <= spielfeld.margin){
            return BallPosition.DRAUSSEN_LINKS;
        }else if(ball.form.rechts() >= spielfeld.margin + spielfeld.breite){
            return BallPosition.DRAUSSEN_RECHTS;
        }else{
            return BallPosition.DRINNEN;
        }
    }
}
