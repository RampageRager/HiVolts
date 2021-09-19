package com.company.HiVolts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class GUI extends JPanel implements ActionListener {
    Board myBoard = new Board();
    Cell[][] grid;
    Timer updateTimer = new Timer(5000, this);

    private static final String JUMP = "jump";
    private Action jump = new AbstractAction(JUMP) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(5, 0));
            repaint();
            //myBoard.updateMhos();
        }
    };

    private static final String UP = "up";
    private Action up = new AbstractAction(UP) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(0, -1));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String DOWN = "down";
    private Action down = new AbstractAction(DOWN) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(0, 1));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String LEFT = "left";
    private Action left = new AbstractAction(LEFT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(-1, 0));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String RIGHT = "right";
    private Action right = new AbstractAction(RIGHT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(1, 0));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String SIT = "sit";
    private Action sit = new AbstractAction(SIT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            //myBoard.updatePlayer(new Point(0, 0));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String UPLEFT = "upleft";
    private Action upleft = new AbstractAction(UPLEFT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(-1, -1));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String UPRIGHT = "upright";
    private Action upright = new AbstractAction(UPRIGHT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(1, -1));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String DOWNRIGHT = "downright";
    private Action downright = new AbstractAction(DOWNRIGHT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(1, 1));
            repaint();
            myBoard.updateMhos();
        }
    };

    private static final String DOWNLEFT = "downleft";
    private Action downleft = new AbstractAction(DOWNLEFT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard.updatePlayer(new Point(-1, 1));
            repaint();
            myBoard.updateMhos();
        }
    };




    public GUI() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.LIGHT_GRAY);
        grid = myBoard.getBoard();
        updateTimer.start();

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0), JUMP);
        this.getActionMap().put(JUMP, jump);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), UP);
        this.getActionMap().put(UP, up);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), DOWN);
        this.getActionMap().put(DOWN, down);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), LEFT);
        this.getActionMap().put(LEFT, left);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), RIGHT);
        this.getActionMap().put(RIGHT, right);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), SIT);
        this.getActionMap().put(SIT, sit);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), UPLEFT);
        this.getActionMap().put(UPLEFT, upleft);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), UPRIGHT);
        this.getActionMap().put(UPRIGHT, upright);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), DOWNLEFT);
        this.getActionMap().put(DOWNLEFT, downleft);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), DOWNRIGHT);
        this.getActionMap().put(DOWNRIGHT, downright);

    }
    public Dimension getPreferredSize() {
        return new Dimension(720, 720);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (myBoard.hasFence(i, j)) {
                    g.setColor(Color.pink);
                    g.fillRect(i*60, j*60, 60, 60);
                }
                if (myBoard.hasMho(i, j)) {
                    g.setColor(Color.RED);
                    g.fillRect(i*60, j*60, 60, 60);
                }
                if (myBoard.hasPlayer(i, j)) {
                    g.setColor(Color.BLUE);
                    g.fillRect(i*60+20, j*60+20, 20, 20);
                }

                g.setColor(Color.black);
                g.drawRect(i*60, j*60, 60, 60);
            }
        }

    }


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == updateTimer) {
            /*
            myBoard.updateMhos();
            repaint();

             */
        }
    }
}
