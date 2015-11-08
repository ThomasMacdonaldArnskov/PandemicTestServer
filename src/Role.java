import java.util.Random;

/**
 * Created by TMA on 08-11-2015.
 */
public class Role {

    int playerOneRole, playerTwoRole, playerThreeRole, playerFourRole;
    int[] roleId;

    public Role() {

        int[] playerId = new int[4];

        for (int i = 0; i < playerId.length; i++) {
            playerId[i] = -1;
        }


    }

    /**
     * Assign one of the games different roles to a player
     * @param id ID of the player
     */
    public void assignRole(int id) {

        Random random = new Random();

        boolean tmpBool = true;
        int tmpInt;

        while (tmpBool) {

            if (id == 0) {

                if (getPlayerOneRole() == getPlayerTwoRole() || getPlayerOneRole() == getPlayerThreeRole() || getPlayerOneRole() == getPlayerFourRole()) {
                    tmpInt = random.nextInt(7);
                    setPlayerOneRole(tmpInt);
                } else {
                    tmpBool = false;
                }
            }
            if (id == 1) {

                if (getPlayerOneRole() == getPlayerTwoRole() || getPlayerTwoRole() == getPlayerThreeRole() || getPlayerTwoRole() == getPlayerFourRole()) {
                    tmpInt = random.nextInt(7);
                    setPlayerTwoRole(tmpInt);
                } else {
                    tmpBool = false;
                }

            } else if (id == 2) {

                if (getPlayerOneRole() == getPlayerThreeRole() || getPlayerTwoRole() == getPlayerThreeRole() || getPlayerThreeRole() == getPlayerFourRole()) {
                    tmpInt = random.nextInt(7);
                    setPlayerThreeRole(tmpInt);
                } else {
                    tmpBool = false;
                }

            } else if (id == 3) {

                if (getPlayerOneRole() == getPlayerThreeRole() || getPlayerTwoRole() == getPlayerThreeRole() || getPlayerThreeRole() == getPlayerFourRole()) {
                    tmpInt = random.nextInt(7);
                    setPlayerThreeRole(tmpInt);
                } else {
                    tmpBool = false;
                }

            } else if (id == 4) {

                if (getPlayerOneRole() == getPlayerFourRole() || getPlayerTwoRole() == getPlayerFourRole() || getPlayerThreeRole() == getPlayerFourRole()) {
                    tmpInt = random.nextInt(7);
                    setPlayerFourRole(tmpInt);
                } else {
                    tmpBool = false;
                }

            } else {
                System.out.println("YOU HAVE ENTERED A WRONG ID NUMBER. THE ID IS" +id);
            }

        }


    }


    public int getPlayerOneRole() {
        return playerOneRole;
    }

    public int getPlayerTwoRole() {
        return playerTwoRole;
    }

    public int getPlayerThreeRole() {
        return playerThreeRole;
    }


    public int getPlayerFourRole() {
        return playerFourRole;
    }

    public void setPlayerOneRole(int playerOneRole) {
        this.playerOneRole = playerOneRole;
    }

    public void setPlayerTwoRole(int playerTwoRole) {
        this.playerTwoRole = playerTwoRole;
    }

    public void setPlayerThreeRole(int playerThreeRole) {
        this.playerThreeRole = playerThreeRole;
    }

    public void setPlayerFourRole(int playerFourRole) {
        this.playerFourRole = playerFourRole;
    }

}
