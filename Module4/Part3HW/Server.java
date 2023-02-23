package Module4.Part3HW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.w3c.dom.UserDataHandler;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
        client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);
        /*
         rl433
         2/19/23
         chooses the flip method if the key word flip is
         typed as well as math.random to find whether the coin will be
         heads or tails
         */
        if (message.equalsIgnoreCase("flip")) {
            if (Math.random() > 0.5) {
                broadcast("flipped a coin and got heads.", clientId);
                return true;
            } else {                    
                broadcast("flipped a coin and got tails", clientId);
                return true;
            }  
        }
        /*
        rl433
        2/20/23
        chooses the roll method if the key word roll is 
        typed. Prints out the number of dices that are being used.
         */
        if(message.startsWith("roll")){
            String[] first = message.split(" ");
            String[] last = first[1].split("d");
            broadcast(Dice(Integer.parseInt(last[0]), Integer.parseInt(last[1])), clientId);
            System.out.println(clientId + Dice(Integer.parseInt(last[0]), Integer.parseInt(last[1])));
            return true;
        }

        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    
                    break;
                }
            }
        }
        return false;
    }
    /*
    rl433
    2/20/23
    Created a Dice method that has two
    dies, a result, and a total.
    As well as has a random variable.
     */
    Random rand = new Random();
    public String Dice(int die1, int die2){
        int dice1, dice2, result = 0, total = 0;
        dice1 = die1;
        dice2 = die2;

        for (int i = 0; i<dice1; i++){
            result = rand.nextInt(dice2)+1;
            total += result;
        }
        
        
        return " you got " + total;
    }
    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}