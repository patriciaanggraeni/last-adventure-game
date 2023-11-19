package KeyHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean up = false, right = false, bottom = false, left = false;
    private int keyboardCode;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keyboardCode = e.getKeyCode();
        switch (keyboardCode) {
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_D -> right = true;
            case KeyEvent.VK_S -> bottom = true;
            case KeyEvent.VK_A -> left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyboardCode = e.getKeyCode();
        switch (keyboardCode) {
            case KeyEvent.VK_W -> up = false;
            case KeyEvent.VK_D -> right = false;
            case KeyEvent.VK_S -> bottom = false;
            case KeyEvent.VK_A -> left = false;
        }
    }

    public boolean isUp() {
        return this.up;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isBottom() {
        return this.bottom;
    }

    public boolean isLeft() {
        return this.left;
    }
}
