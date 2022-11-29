package CP;

import javax.swing.JFrame;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class snakegame extends JFrame implements KeyListener, ActionListener {

    static ArrayList<Integer> arrayx = new ArrayList<>(); // to store x point of the snake
    static ArrayList<Integer> arrayy = new ArrayList<>();// to store y point of the snake
    Timer timer;
    int up = 38;
    int down = 40;
    int left = 37;
    int right = 39;
    int direction = right;
    int appleY = 0;
    int appleX = 0;

    int h = 0;
    int g_moving_h = 0;
    int prev_g = 1000000000;

    public snakegame() {
        newFood();
        addKeyListener(this);
        timer = new Timer(10, this);
        timer.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            arrayx.add(i);
            arrayy.add(100);
        }

        snakegame jf = new snakegame();
        jf.setTitle("Snake game");
        jf.setVisible(true);
        jf.setSize(500, 500);
        jf.setResizable(false);

    }

    @Override
    public void paint(Graphics g) {

        int headX = arrayx.get(arrayx.size() - 1);
        int headY = arrayy.get(arrayy.size() - 1);
        g_moving_h = Math.abs(headX - appleX) + Math.abs(headY - appleY);
        g.setColor(Color.white);
        g.fillRect(0, 0, 500, 500);

        for (int i = 0; i < arrayx.size(); i++) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(arrayx.get(i), arrayy.get(i), 1, 1);
        }

        g.setColor(Color.RED);
        g.fillRect(appleX, appleY, 10, 10);

        if (g_moving_h > prev_g) {
            if (direction == left || direction == right) {
                int upG = calG(up);
                int downG = calG(down);
                if (upG < downG) {
                    direction = up;
                } else {
                    direction = down;
                }
            } else if (direction == up || direction == down) {
                int leftG = calG(left);
                int rightG = calG(right);
                if (leftG < rightG) {
                    direction = left;
                } else {
                    direction = right;
                }
            }
        }
        prev_g = g_moving_h;
    }

    public Boolean isSnakeBite() {
        goAccordingToDirect(direction);
        int headX = arrayx.get(arrayx.size() - 1);
        int headY = arrayy.get(arrayy.size() - 1);
        {
            Boolean yDouble = arrayy.indexOf(headY) != (arrayy.size() - 1);
            Boolean xDouble = headX == arrayx.get(arrayy.indexOf(headY));
            if (yDouble && xDouble) {
                // Undo
                arrayx.remove(arrayx.size() - 1);
                arrayy.remove(arrayy.size() - 1);
                return true;
            }
        }
        {
            Boolean xDouble = arrayx.indexOf(headX) != (arrayx.size() - 1);
            Boolean yDouble = headY == arrayy.get(arrayx.indexOf(headX));
            if (yDouble && xDouble) {
                // Undo
                arrayx.remove(arrayx.size() - 1);
                arrayy.remove(arrayy.size() - 1);
                return true;
            }
        }
        // Undo
        arrayx.remove(arrayx.size() - 1);
        arrayy.remove(arrayy.size() - 1);
        return false;
    }

    public void goAccordingToDirect(int _direction) {
        if (_direction == right) {
            int lastEle = arrayx.get(arrayx.size() - 1);
            int newPos = lastEle + 1;
            arrayx.add(newPos);

            lastEle = arrayy.get(arrayy.size() - 1);
            arrayy.add(lastEle);
        }

        if (_direction == down) {
            int lastEle = arrayx.get(arrayx.size() - 1);
            arrayx.add(lastEle);

            lastEle = arrayy.get(arrayy.size() - 1);
            int newPos = lastEle + 1;
            arrayy.add(newPos);
        }

        if (_direction == left) {
            int head = arrayx.get(arrayx.size() - 1);
            int newPos = head - 1;
            arrayx.add(newPos);

            head = arrayy.get(arrayy.size() - 1);
            arrayy.add(head);
        }

        if (_direction == up) {
            int head = arrayx.get(arrayx.size() - 1);
            arrayx.add(head);

            head = arrayy.get(arrayy.size() - 1);
            int newPos = head - 1;
            arrayy.add(newPos);
        }

    }

    public int calG(int _direction) {
        goAccordingToDirect(_direction);
        int headX = arrayx.get(arrayx.size() - 1);
        int headY = arrayy.get(arrayy.size() - 1);
        g_moving_h = Math.abs(headX - appleX) + Math.abs(headY - appleY);

        // Undo
        arrayx.remove(arrayx.size() - 1);
        arrayy.remove(arrayy.size() - 1);
        return g_moving_h;
    }

    public void keyTyped(KeyEvent k) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        direction = keyEvent.getKeyCode();
    }

    public void keyReleased(KeyEvent k) {

    }

    public void newFood() {
        appleY = (int) (Math.random() * 90 + 5) * 5;
        appleX = (int) (Math.random() * 90 + 5) * 5;
        int headX = arrayx.get(arrayx.size() - 1);
        int headY = arrayy.get(arrayy.size() - 1);
        h = Math.abs(headX - appleX) + Math.abs(headY - appleY);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isSnakeBite()) {
            if (direction == left || direction == right) {
                direction = down;
            } else if (direction == up || direction == down) {
                direction = left;
            }
        }
        if (isSnakeBite()) {
            if (direction == left || direction == right) {
                direction = up;
            } else if (direction == up || direction == down) {
                direction = right;
            }
        }
        int headX = arrayx.get(arrayx.size() - 1);
        int headY = arrayy.get(arrayy.size() - 1);

        if (((appleY + 10) >= headY && appleY <= headY) && ((appleX + 10) >= headX && appleX <= headX)) {
            System.out.println("food eaten");
            newFood();
        } else {
            arrayx.remove(0);
            arrayy.remove(0);
        }
        goAccordingToDirect(direction);
        headX = arrayx.get(arrayx.size() - 1);
        headY = arrayy.get(arrayy.size() - 1);
        {
            Boolean yDouble = arrayy.indexOf(headY) != (arrayy.size() - 1);
            Boolean xDouble = headX == arrayx.get(arrayy.indexOf(headY));
            if (yDouble && xDouble) {
                System.out.println(direction);
                System.out.println("GAME OVER");
                System.exit(0);
            }
        }
        {
            Boolean xDouble = arrayx.indexOf(headX) != (arrayx.size() - 1);
            Boolean yDouble = headY == arrayy.get(arrayx.indexOf(headX));
            if (yDouble && xDouble) {
                System.out.println(direction);
                System.out.println("GAME OVER");
                System.exit(0);
            }
        }
        repaint();
    }

}
