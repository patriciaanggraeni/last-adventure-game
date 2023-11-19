package Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Entity {
    public int posX, posY;
    public int speed;

    public String direction;
    public BufferedImage playerUpOne, playerUpTwo, playerRightOne, playerRightTwo;
    public BufferedImage playerDownOne, playerDownTwo, playerLeftOne, playerLeftTwo;

    public int counter = 0;
    public int spriteNumber = 1;
}

