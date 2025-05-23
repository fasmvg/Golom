package main;

import java.awt.*;

public class Board {
    final int MAX_COL = 8;
    final int MAX_ROW = 8;
    public static final int SQUARE_SIZE = 65;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE/2;

    public void drawBoard(Graphics2D g2) {
        for(int row = 0; row < MAX_ROW; row++) {
            for(int col = 0; col < MAX_COL; col++) {
                g2.setColor((col + row) % 2 == 0 ? new Color(255,255,255) : new Color(192,192,192));
                g2.fillRect(col*SQUARE_SIZE, row*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
        g2.setColor(new Color(242,232,231));
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(0, 0, (MAX_COL * SQUARE_SIZE) - 1, (MAX_ROW * SQUARE_SIZE) - 1);

        g2.setFont(new Font("Arial", Font.PLAIN, 14));

        for(int col = 0; col < MAX_COL; col++) {
            g2.setColor(col % 2 == 0 ?  new Color(255,255,255) : new Color(192,192,192));
            String letter = String.valueOf((char)('a' + col));
            FontMetrics metrics = g2.getFontMetrics();
            int x = col*SQUARE_SIZE + (SQUARE_SIZE - metrics.stringWidth(letter))/2;
            g2.drawString(letter, x, MAX_ROW*SQUARE_SIZE + 20);
        }

        for(int row = 0; row < MAX_ROW; row++) {
            g2.setColor(row % 2 == 0 ? new Color(192,192,192) : new Color(255,255,255));
            String number = String.valueOf(8 - row);
            FontMetrics metrics = g2.getFontMetrics();
            int y = row*SQUARE_SIZE + (SQUARE_SIZE + metrics.getAscent())/2;
            g2.drawString(number, 530, y);
        }
    }
}
