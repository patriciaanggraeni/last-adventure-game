import GamePanel.GamePanel;

import javax.swing.JFrame;

class Main extends JFrame {

    Main() {
        GamePanel gamePanel = new GamePanel();

        setTitle("The Last Adventure Journey - 2D RPG Adventure Game");
        setResizable(false);
        add(gamePanel);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}