package de.hsos.prog3.pong.tests;

import de.hsos.prog3.pong.logik.Spielfeld;
import de.hsos.prog3.pong.util.Interaktionsbrett;

public class SpielfeldTest {
    Spielfeld sp = new Spielfeld();
    public void testlauf(Interaktionsbrett ib){
        sp.darstellen(ib);
    }
}
