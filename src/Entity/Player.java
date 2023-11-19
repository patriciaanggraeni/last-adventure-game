package Entity;

import GamePanel.GamePanel;
import KeyHandler.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    final private GamePanel gamePanel;
    final private KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        defaultValue();
        loadPlayerImage();
    }

    public void defaultValue() {
        posX = 50;
        posY = 50;
        speed = 4;
        direction = "right";
    }

    public void update() {

        // 1. Kalau ingin animasi karakternya diam saat tidak menekan tombol apa-apa
        // if (keyHandler.isUp() || keyHandler.isRight() || keyHandler.isBottom() || keyHandler.isLeft()) {
        //     if (keyHandler.isUp()) {
        //         direction = "up";
        //         posY -= speed;
        //     } else if (keyHandler.isRight()) {
        //         direction = "right";
        //         posX += speed;
        //     } else if (keyHandler.isBottom()) {
        //         direction = "down";
        //         posY += speed;
        //     } else if (keyHandler.isLeft()) {
        //         direction = "left";
        //         posX -= speed;
        //     }
        //
        //     counter++;
        //     if (counter > 10) {
        //         if (spriteNumber == 1) {
        //             spriteNumber = 2;
        //         } else if (spriteNumber == 2) {
        //             spriteNumber = 1;
        //         }
        //         counter = 0;
        //     }
        // }

        // 2, kalau ingin animasinya terus jalan
        if (keyHandler.isUp()) {
            direction = "up";
            posY -= speed;
        } else if (keyHandler.isRight()) {
            direction = "right";
            posX += speed;
        } else if (keyHandler.isBottom()) {
            direction = "down";
            posY += speed;
        } else if (keyHandler.isLeft()) {
            direction = "left";
            posX -= speed;
        }

        counter++;
        if (counter > 10) {
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 1;
            }
            counter = 0;
        }
    }

    public void draw(Graphics2D graphics2D) {
        // graphics2D.setColor(Color.BLACK);
        // graphics2D.fillRect(posX, posY, gamePanel.getOBJECT_SIZE(), gamePanel.getOBJECT_SIZE());

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNumber == 1) {
                    image =  playerUpOne;
                } else if (spriteNumber == 2) {
                    image = playerUpTwo;
                }
            }
            case "right" -> {
                if (spriteNumber == 1) {
                    image = playerRightOne;
                } else if (spriteNumber == 2) {
                    image = playerRightTwo;
                }
            }
            case "down" -> {
                if (spriteNumber == 1) {
                    image = playerDownOne;
                } else if (spriteNumber == 2) {
                    image = playerDownTwo;
                }
            }
            case "left" -> {
                if (spriteNumber == 1) {
                    image = playerLeftOne;
                } else if (spriteNumber == 2) {
                    image = playerLeftTwo;
                }
            }
        };

        graphics2D.drawImage(image, posX, posY, gamePanel.getTILE_SIZE(), gamePanel.getTILE_SIZE(), null);
    }

    public void loadPlayerImage() {
        try {
            playerUpOne = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_up_1.png")));
            playerUpTwo = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_up_2.png")));
            playerRightOne = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_right_1.png")));
            playerRightTwo = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_right_2.png")));
            playerDownOne = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_down_1.png")));
            playerDownTwo = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_down_2.png")));
            playerLeftOne = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_left_1.png")));
            playerLeftTwo = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/walking_sprites/boy_left_2.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
