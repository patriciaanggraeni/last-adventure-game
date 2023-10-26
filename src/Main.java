import javax.swing.JFrame;
import javax.swing.JPanel;

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
        
        // buat objek dari class Main
        new Main();

    }
}