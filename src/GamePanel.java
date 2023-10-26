import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;
    private final KeyHandler keyHandler;

    private final int ACTUAL_SIZE = 16;
    private final int SCALE = 3;

    private final int OBJECT_SIZE = ACTUAL_SIZE * SCALE;
    private final int MAX_COLUMN = 16;
    private final int MAX_ROW = 12;

    final int SCREEN_WIDTH = OBJECT_SIZE * MAX_COLUMN;
    final int SCREEN_HEIGHT = OBJECT_SIZE * MAX_ROW;

    private int DEFAULT_PLAYER_POSITION_X = 50;
    private int DEFAULT_PLAYER_POSITION_Y = 50;

    private final int FPS = 60;
    private final int PLAYER_SPEED = 5;

    public GamePanel() {
        DimensionUIResource dimension = new DimensionUIResource(SCREEN_WIDTH, SCREEN_HEIGHT);
        keyHandler = new KeyHandler();

        setPreferredSize(dimension);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        startGameThread();

        addKeyListener(keyHandler);
        setFocusable(true);
    }

    @Override
    public void run() {

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
        if (keyHandler.isUp()) {
            DEFAULT_PLAYER_POSITION_Y -= PLAYER_SPEED;
        } else if (keyHandler.isRight()) {
            DEFAULT_PLAYER_POSITION_X += PLAYER_SPEED;
        } else if (keyHandler.isBottom()) {
            DEFAULT_PLAYER_POSITION_Y += PLAYER_SPEED;
        } else if (keyHandler.isLeft()) {
            DEFAULT_PLAYER_POSITION_X -= PLAYER_SPEED;
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(DEFAULT_PLAYER_POSITION_X, DEFAULT_PLAYER_POSITION_Y, OBJECT_SIZE, OBJECT_SIZE);
        graphics2D.dispose();
    }
}
