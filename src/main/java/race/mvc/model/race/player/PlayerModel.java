package race.mvc.model.race.player;

public class PlayerModel {

    private double dx;

    private boolean moveLeft;
    private boolean moveRight;

    public void dx(double dx) {
        this.dx = dx;
    }


    public double dx() {
        return dx;
    }

    public boolean moveLeft() {
        return moveLeft;
    }

    public boolean moveRight() {
        return moveRight;
    }

    public void moveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void moveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

}
