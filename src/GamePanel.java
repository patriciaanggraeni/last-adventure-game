import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel {
    
    // membuat pengaturan ukuran layar, game retro memiliki ukuran default yaitu 16x16
    // untuk ukuran objeknya seperti player, ubin (tile), monster dan lainnya
    // jadi buat ukuran aktualnya
    final int ACTUAL_SIZE = 16;

    // nah karena layar sekarang memiliki resolusi yang besar sedangkan konsol game jadul memiliki resolusi
    // rendah, maka perlu adanya scaling (perpesar ukuran)
    final int SCALE = 3; // nilai scaling menyesuaikan

    // membuat ukuran tile dengan mengalikan ACTUAL_SIZE dan SCALE
    // ini yang akan menjadi ukuran objeknya, karena resolusinya besar makanya dikali dengan scale
    final int ORIGINAL_TILE_SIZE = ACTUAL_SIZE * SCALE;

    // membuat rasio layar, di sini menggunakan 4 : 3
    // atau 16x12 (masing-masing dibagi 4)
    // 6:4 = 4, 12:4 = 3 -> 4:3
    final int MAX_COLUMN = 16; // untuk lebarnya
    final int MAX_ROW = 12; // untuk tingginya

    // menyeting ukuran lebar dan tinggi layar dengan mengalikan MAX_COLUMN / MAX_ROW dengan ORIGINAL_TILE_SIZE
    final int SCREEN_WIDTH = ORIGINAL_TILE_SIZE * MAX_COLUMN; // 48 x 16 = 768 pixel
    final int SCREEN_HEIGHT = ORIGINAL_TILE_SIZE * MAX_ROW; // 48 * 12 = 576 pixel

    // membuat constructor JPanel
    public GamePanel() {

        // buat objek DimensionUIResource guna membuat ukuran layar game
        DimensionUIResource dimension = new DimensionUIResource(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        // set ukuran ke preferredSize, ini biar fit dengan JFrame
        setPreferredSize(dimension);

        // set background menjadi warna putih (opsional)
        setBackground(Color.WHITE);

        // setDoubleBuffered ke true agar meningkatkan kecepatan render
        // menghindari efek flicker (berkedip) saat elemen berubah
        setDoubleBuffered(true);
    }
}
