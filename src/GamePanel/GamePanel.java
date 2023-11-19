package GamePanel;

import Entity.Player;
import KeyHandler.KeyHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;

    private final int ACTUAL_SIZE = 16;
    private final int SCALE = 3;

    private final int TILE_SIZE = ACTUAL_SIZE * SCALE;
    private final int MAX_COLUMN = 16;
    private final int MAX_ROW = 12;

    final int SCREEN_WIDTH = TILE_SIZE * MAX_COLUMN;
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_ROW;

    private final Player player;

    public GamePanel() {
        DimensionUIResource DIMENSION = new DimensionUIResource(SCREEN_WIDTH, SCREEN_HEIGHT);
        KeyHandler keyHandler = new KeyHandler();
        player = new Player(this, keyHandler);

        setPreferredSize(DIMENSION);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        startGameThread();

        addKeyListener(keyHandler);
        setFocusable(true);
    }

    @Override
    public void run() {

        int FPS = 60;
        int interval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (double) (currentTime - lastTime) / interval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    protected void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        player.draw(graphics2D);
        graphics2D.dispose();
    }

    public int getTILE_SIZE() {
        return TILE_SIZE;
    }
}
