package main;

public class ChessMove {
    private String piece;
    private String from;
    private String to;
    private boolean capture;
    
    public ChessMove(String piece, String from, String to, boolean capture) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capture = capture;
    }
    
    @Override
    public String toString() {
        String notation = piece + from;
        if (capture) {
            notation += "x";
        } else {
            notation += "-";
        }
        notation += to;
        return notation;
    }
}