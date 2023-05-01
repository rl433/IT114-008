package Project.client.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Project.client.Client;
import Project.client.IClientEvents;
import Project.common.Constants;
import Project.common.Phase;

public class GamePanel extends JPanel implements IClientEvents {

    int numReady = 0;

    private static Logger logger = Logger.getLogger(GamePanel.class.getName());
    GamePanel self;
    JPanel gridLayout;
    JPanel readyCheck;

    public GamePanel() {
        gridLayout = new JPanel();
        buildReadyCheck();
        this.setLayout(new BorderLayout());
        this.add(gridLayout, BorderLayout.CENTER);
        this.add(readyCheck, BorderLayout.SOUTH);
        self = this;
        Client.INSTANCE.addListener(this);
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);

    }

    private void buildReadyCheck() {
        if (readyCheck == null) {
            readyCheck = new JPanel();
            readyCheck.setLayout(new BorderLayout());
            JTextField tf = new JTextField(String.format("%s/%s", 0, Constants.MINIMUM_PLAYERS));
            tf.setName("readyText");
            readyCheck.add(tf, BorderLayout.CENTER);
            JButton jb = new JButton("Ready");
            jb.addActionListener((event) -> {
                if (!Client.INSTANCE.isCurrentPhase(Phase.READY)) {
                    return;
                }
                try {
                    Client.INSTANCE.sendReadyStatus();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readyCheck.add(jb, BorderLayout.SOUTH);
        }
    }

    private void drawBoard() {
        gridLayout.setVisible(true);
        gridLayout.repaint();
    }

    // Although we must implement all of these methods, not all of them may be
    // applicable to this panel
    @Override
    public void onClientConnect(long id, String clientName, String message) {

    }

    @Override
    public void onClientDisconnect(long id, String clientName, String message) {

    }

    @Override
    public void onMessageReceive(long id, String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onReceiveClientId(long id) {

    }

    @Override
    public void onSyncClient(long id, String clientName) {
    }

    @Override
    public void onResetUserList() {
        // players.clear();
    }

    @Override
    public void onReceiveRoomList(String[] rooms, String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onRoomJoin(String roomName) {
        logger.info(
                Constants.ANSI_BRIGHT_BLUE + String.format("Received room name %s", roomName) + Constants.ANSI_RESET);

        if (roomName.equalsIgnoreCase("lobby")) {
            setVisible(false);
        } else {
            setVisible(true);
        }

    }

    @Override
    public void onReceiveReady(long clientId) {

    }

    @Override
    public void onReceiveReadyCount(long count) {
        logger.info(
                Constants.ANSI_BRIGHT_BLUE + String.format("Received ready count %s", count) + Constants.ANSI_RESET);

        if (readyCheck != null) {
            for (Component c : readyCheck.getComponents()) {
                if (c.getName().equalsIgnoreCase("readyText")) {
                    ((JTextField) c).setText(String.format("%s/%s", count, Constants.MINIMUM_PLAYERS));
                    break;
                }
            }
        }
        this.validate();
        this.repaint();
    }

    @Override
    public void onReceivePhase(Phase phase) {
        logger.info(Constants.ANSI_BRIGHT_BLUE + String.format("Received phase %s", phase) + Constants.ANSI_RESET);
        if (phase == Phase.READY) {
            readyCheck.setVisible(true);
            gridLayout.setVisible(false);
        } else if (phase == Phase.PICKING) {
            readyCheck.setVisible(false);
            gridLayout.setVisible(true);
        }
        this.validate();
        this.repaint();
        logger.info(
                Constants.ANSI_BRIGHT_MAGENTA + String.format("Dimension %s", this.getSize()) + Constants.ANSI_RESET);
    }

    @Override
    public void onReceiveSeeker(long clientId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'onReceiveSeeker'");
    }

    @Override
    public void onReceiveHide(int x, int y, long clientId) {
    }

    @Override
    public void onReceiveOut(long clientId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'onReceiveOut'");
    }

    

    @Override
    public void onReceivePoints(long clientId, int points) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'onReceivePoints'");
    }

}