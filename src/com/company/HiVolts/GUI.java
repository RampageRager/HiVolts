package com.company.HiVolts;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JPanel implements ActionListener {
    Board myBoard = new Board();
    Cell[][] grid;
    Timer updateTimer = new Timer(1, this);
    boolean hasImages = true;
    private BufferedImage smileImage;
    private BufferedImage sadImage;
    private BufferedImage fenceImage;

    private static final String RESTART = "restart";
    private Action restart = new AbstractAction(RESTART) {
        @Override
        public void actionPerformed(ActionEvent e) {
            myBoard = new Board();
            grid = myBoard.getBoard();
            repaint();
        }
    };

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

        try {
            smileImage = ImageIO.read(new File("src/com/company/images/smiley.png"));
            int w = smileImage.getWidth();
            int h = smileImage.getHeight();
            BufferedImage smileAfter = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            AffineTransform at = new AffineTransform();
            at.scale(0.28, 0.26);
            AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            smileAfter = scaleOp.filter(smileImage, smileAfter);
            smileImage = smileAfter;

            sadImage = ImageIO.read(new File("src/com/company/images/sad.png"));
            w = sadImage.getWidth();
            h = sadImage.getHeight();
            BufferedImage sadAfter = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            AffineTransform at2 = new AffineTransform();
            at2.scale(0.07, 0.07);
            AffineTransformOp scaleOp2 = new AffineTransformOp(at2, AffineTransformOp.TYPE_BILINEAR);
            sadAfter = scaleOp2.filter(sadImage, sadAfter);
            sadImage = sadAfter;

            fenceImage = ImageIO.read(new File("src/com/company/images/fence.png"));
            w = fenceImage.getWidth();
            h = fenceImage.getHeight();
            BufferedImage fenceAfter = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            AffineTransform at3 = new AffineTransform();
            at3.scale(0.075, 0.075);
            AffineTransformOp scaleOp3 = new AffineTransformOp(at3, AffineTransformOp.TYPE_BILINEAR);
            fenceAfter = scaleOp3.filter(fenceImage, fenceAfter);
            fenceImage = fenceAfter;

            hasImages = true;
        } catch (IOException ex) {
            System.out.println("problem occurred");
            hasImages = false;
        }


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

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), RESTART);
        this.getActionMap().put(RESTART, restart);

    }
    public Dimension getPreferredSize() {
        return new Dimension(720, 720);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (myBoard.hasFence(i, j)) {
                    if (hasImages == false) {
                        g.setColor(Color.pink);
                        g.fillRect(i * 60, j * 60, 60, 60);
                    } else {
                        g.drawImage(fenceImage, i * 60, j * 60, this);
                    }
                }
                if (myBoard.hasMho(i, j)) {
                    if (hasImages == false) {
                        g.setColor(Color.RED);
                        g.fillRect(i * 60, j * 60, 60, 60);
                    } else {
                        g.drawImage(sadImage, i * 60, j * 60, this);
                    }
                }
                if (myBoard.hasPlayer(i, j)) {
                    if (hasImages == false) {
                        g.setColor(Color.BLUE);
                        g.fillRect(i * 60 + 20, j * 60 + 20, 20, 20);
                    } else {
                        g.drawImage(smileImage, i * 60, j * 60, this);
                    }
                }

                g.setColor(Color.black);
                g.drawRect(i*60, j*60, 60, 60);
            }
        }


        if (!myBoard.checkGameOver()) {
            Font font = new Font("Serif", Font.PLAIN, 1);
            g.setFont(font);
            g.drawString("a", -10, -10);
        } else {
            Font font = new Font("Serif", Font.PLAIN, 96);
            g.setFont(font);
            //g.drawString("Text", 40, 120);
            g.drawString("GAME OVER", 80, 360);
        }

        if (myBoard.checkVictory()) {
            Font font = new Font("Serif", Font.PLAIN, 96);
            g.setFont(font);
            g.drawString("YOU WIN", 120, 360);
        } else {
            Font font = new Font("Serif", Font.PLAIN, 1);
            g.setFont(font);
            g.drawString("a", -10, -10);
        }

    }


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == updateTimer) {

            myBoard.update();



        }
    }
}
