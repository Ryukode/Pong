import de.hsos.prog3.pong.logik.PongSpiel;
import de.hsos.prog3.pong.logik.Spieler;
import de.hsos.prog3.pong.logik.Spielfeld;
import de.hsos.prog3.pong.util.Interaktionsbrett;

public class App {
    public static void main(String[] args){
        PongSpiel ps = new PongSpiel();
        ps.spielen();
    }
}
