import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JFrame {
    
    // bikin constructor, maka semua isi akan mengambil dari class yang diextend tersebut
    // keyword this di bawah merujuk pada class JFrame
    Main() {
        // buat objek JPanel
        JPanel gamePanel = new GamePanel();

        // tambahkan panel ke JFrame
        add(gamePanel);

        // memberi aksi agar bisa menenakan tombol close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layar tidak bisa diatur ukurannya secara langsung
        setResizable(false);

        // memposisikan layar pas di tengah
        setLocation(null);
        
        // memberikan judul dari window / game yang dibuat
        setTitle("The Last Adventure Journey - 2D RPG Adventure Game");

        // memunculkan layar biar terlihat
        setVisible(true);

        // memanggil fungsi pack agar ukuran frame sesuai dengan isinya (game panel)
        // mudahnya seperti wrap content
        pack();
    }
    
    public static void main(String[] args) {
        
        // buat objek dari class Main
        new Main();

    }
}