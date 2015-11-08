/**
 * Created by TMA on 07-11-2015.
 */
public class Database {

    private boolean p1,p2,p3,p4, animationControl;
    private int playerID, gameState;

    public Database() {

        playerID = 0;
        gameState = 1;

        p1 = false;
        p2 = false;
        p3 = false;
        p4 = false;

        animationControl = false;

    }

    public int getPlayerID() { return playerID; }

    public void setPlayerID(int i) { this.playerID = i; }

    public void setNextPlayerID(int i) {
            this.playerID += i;
    }

    public boolean getP2() {
        return p2;
    }

    public void setP2(boolean p2) {
        this.p2 = p2;
    }

    public boolean getP1() {
        return p1;
    }

    public void setP1(boolean p1) {
        this.p1 = p1;
    }

    public boolean getP3() {
        return p3;
    }

    public void setP3(boolean p3) {
        this.p3 = p3;
    }

    public boolean getP4() {
        return p4;
    }

    public void setP4(boolean p4) {
        this.p4 = p4;
    }

    public void setGameState(int gameState) { this.gameState = gameState; }

    public int getGameState() { return gameState; }

    public void setAnimationControl(boolean animationControl) {
        this.animationControl = animationControl;
    }

    public boolean getAnimationControl() {
        return animationControl;
    }
}
