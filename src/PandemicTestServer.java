import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by TMA on 06-11-2015.
 *
 */
public class PandemicTestServer {

    public static void main(String[] args) throws IOException {

        Database database = new Database();
        Role role = new Role();

        ServerSocket m_ServerSocket = new ServerSocket(1234);
        System.out.println("Opening Socket 1234");
        int id = 0;
        while (true) {
            Socket clientSocket = m_ServerSocket.accept();
            ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++, database, role);
            cliThread.start();
        }
    }
}

class ClientServiceThread extends Thread {
    Socket clientSocket;
    int clientID = -1;
    boolean running = true;

    boolean tmpBool;
    Database database;
    Role role;


    ClientServiceThread(Socket s, int i, Database database, Role role) {
        clientSocket = s;
        clientID = i;
        this.database = database;
        this.role = role;
    }

    public void run() {


        //System.out.println("Accepted Client : ID - " + clientID + " : Address - "
        //        + clientSocket.getInetAddress().getHostName());
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            while (running) {
                String clientCommand = in.readLine();
                System.out.println("Client Says :" + clientCommand);
                if (clientCommand.equalsIgnoreCase("quit")) {
                    running = false;
                    System.out.print("Stopping client thread for client : " + clientID);
                }

                //SET PLAYER ID
                if (clientCommand.equals("ASSIGN_PLAYER_ID")) {
                    clientCommand = "" + database.getPlayerID()+ "";
                    out.println(clientCommand);
                    out.flush();
                    database.setNextPlayerID(1);
                }
                //GET PLAYER ID
                if (clientCommand.equals("GET_PLAYER_ID")) {
                    clientCommand = "" + database.getPlayerID() + "";
                }


                //SET PLAYER STATUS

                else if (clientCommand.equals("SET_PLAYER_STATUS: false 0")) {
                    clientCommand = "false";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP1(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                } else if (clientCommand.equals("SET_PLAYER_STATUS: true 0")) {
                    clientCommand = "true";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP1(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                } else if (clientCommand.equals("SET_PLAYER_STATUS: false 1")) {
                    clientCommand = "false";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP2(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                } else if (clientCommand.equals("SET_PLAYER_STATUS: true 1")) {
                    clientCommand = "true";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP2(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                } else if (clientCommand.equals("SET_PLAYER_STATUS: false 2")) {
                    clientCommand = "false";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP3(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                } else if (clientCommand.equals("SET_PLAYER_STATUS: true 2")) {
                    clientCommand = "true";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP3(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                } else if (clientCommand.equals("SET_PLAYER_STATUS: false 3")) {
                    clientCommand = "false";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP4(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                } else if (clientCommand.equals("SET_PLAYER_STATUS: true 3")) {
                    clientCommand = "true";
                    tmpBool = Boolean.valueOf(clientCommand);
                    database.setP4(tmpBool);
                    out.println(clientCommand);
                    out.flush();
                }

                //GET PLAYER STATUS
                if (clientCommand.equals("GET_PLAYER_STATUS: 0")) {
                    clientCommand = String.valueOf( database.getP1());
                    out.println(clientCommand);
                    out.flush();
                }
                if (clientCommand.equals("GET_PLAYER_STATUS: 1")) {
                    clientCommand = String.valueOf( database.getP2());
                    out.println(clientCommand);
                    out.flush();
                }
                if (clientCommand.equals("GET_PLAYER_STATUS: 2")) {
                    clientCommand = String.valueOf( database.getP3());
                    out.println(clientCommand);
                    out.flush();
                }
                if (clientCommand.equals("GET_PLAYER_STATUS: 3")) {
                    clientCommand = String.valueOf(database.getP4());
                    out.println(clientCommand);
                    out.flush();
                }



                //SET ROLE ON SERVER

                if (clientCommand.equals("SET_PLAYER_ROLE: 0")) {
                    role.assignRole(0);
                    clientCommand = String.valueOf(role.getPlayerOneRole());
                    out.println(clientCommand);
                    out.flush();
                }
                if (clientCommand.equals("SET_PLAYER_ROLE: 1")) {
                    role.assignRole(1);
                    clientCommand = String.valueOf(role.getPlayerTwoRole());
                    out.println(clientCommand);
                    out.flush();
                }
                if (clientCommand.equals("SET_PLAYER_ROLE: 2")) {
                    role.assignRole(2);
                    clientCommand = String.valueOf(role.getPlayerThreeRole());
                    out.println(clientCommand);
                    out.flush();
                } if (clientCommand.equals("SET_PLAYER_ROLE: 3")) {
                    role.assignRole(3);
                    clientCommand = String.valueOf(role.getPlayerFourRole());
                    out.println(clientCommand);
                    out.flush();
                }


                //GET ROLE ON SERVER
                if (clientCommand.equals("GET_PLAYER_ROLE: 0")) {
                    clientCommand = String.valueOf(role.getPlayerOneRole());
                    out.println(clientCommand);
                    out.flush();
                }
                if (clientCommand.equals("GET_PLAYER_ROLE: 1")) {
                    clientCommand = String.valueOf(role.getPlayerTwoRole());
                    out.println(clientCommand);
                    out.flush();
                }
                if (clientCommand.equals("GET_PLAYER_ROLE: 2")) {
                    clientCommand = String.valueOf(role.getPlayerThreeRole());
                    out.println(clientCommand);
                    out.flush();
                } if (clientCommand.equals("GET_PLAYER_ROLE: 3")) {
                    clientCommand = String.valueOf(role.getPlayerFourRole());
                    out.println(clientCommand);
                    out.flush();
                }

                //Animation Control
                if (clientCommand.equals("SET_ANIMATION_TRUE")) {
                    database.setAnimationControl(true);
                }
                if (clientCommand.equals("GET_ANIMATION_STATUS")) {
                    clientCommand = String.valueOf(database.getAnimationControl());
                    out.println(clientCommand);
                    out.flush();
                }



                else {
                    out.println(clientCommand);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
