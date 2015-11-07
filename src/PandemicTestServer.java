import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by TMA on 06-11-2015.
 */
public class PandemicTestServer {

    public static void main(String[] args) throws IOException {

        Database database = new Database();

        ServerSocket m_ServerSocket = new ServerSocket(1234);
        System.out.println("Opening Socket 1234");
        int id = 0;
        while (true) {
            Socket clientSocket = m_ServerSocket.accept();
            ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++, database);
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


    ClientServiceThread(Socket s, int i, Database database) {
        clientSocket = s;
        clientID = i;
        this.database = database;
    }

    public void run() {


        System.out.println("Accepted Client : ID - " + clientID + " : Address - "
                + clientSocket.getInetAddress().getHostName());
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

                //ASSIGN PLAYER ID
                if (clientCommand.equals("ASSIGN_PLAYER_ID")) {
                    clientCommand = "" + database.getPlayerID()+ "";
                    out.println(clientCommand);
                    out.flush();
                    database.setNextPlayerID(1);
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
