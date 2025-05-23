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
                g2.setColor((col + row) % 2 == 0 ? new Color(242,232,231) : new Color(165,81,81));
                g2.fillRect(col*SQUARE_SIZE, row*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
        g2.setColor(new Color(242,232,231));
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(0, 0, (MAX_COL * SQUARE_SIZE) - 1, (MAX_ROW * SQUARE_SIZE) - 1);
    }
}
