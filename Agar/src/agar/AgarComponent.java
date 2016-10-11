/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author John
 */
public class AgarComponent extends JComponent {
    
    private static final float CONSUME_THRESHOLD = 0.9f;
    private final Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            checkCollisions();
        }
    });
    private final ArrayList<Player> players = new ArrayList<>();

    private void checkCollisions() {
        for (Player player : players) {
            for (Player otherPlayer : players) {
                if (player != otherPlayer && player.getInscribedCircle().intersects(otherPlayer)) {
                    if (player.size * CONSUME_THRESHOLD > otherPlayer.size) {
                        player.size = player.size + otherPlayer.size;
                        if (player.getClass() == User.class || otherPlayer.getClass() == User.class) {
                            gameOver();
                        } else {
                            otherPlayer.kill();
                        }
                    } else if (otherPlayer.size * CONSUME_THRESHOLD > player.size) {
                        otherPlayer.size = otherPlayer.size + player.size;
                        if (player.getClass() == User.class || otherPlayer.getClass() == User.class) {
                            gameOver();
                        } else {
                            otherPlayer.kill();
                        }
                    }
                }
            }
        }
    }

    private void gameOver() {
        JOptionPane.show
    }
}
