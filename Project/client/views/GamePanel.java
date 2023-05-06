package Project.client.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Project.client.Client;
import Project.client.IClientEvents;
import Project.common.Constants;
import Project.common.Phase;
import Project.common.TimedEvent;

public class GamePanel extends JPanel implements IClientEvents {

    int numReady = 0;

    private static Logger logger = Logger.getLogger(GamePanel.class.getName());
    GamePanel self;
    JPanel gridLayout;
    JPanel readyCheck;
    JPanel buttonsPanel = new JPanel(new FlowLayout());
    private boolean isSpectator = false;
    UserListPanel ulp;
    TimedEvent currentTimer;
    JLabel timeLabel = new JLabel("");
    Phase currentPhase;
    public GamePanel() {
        gridLayout = new JPanel();
        buildReadyCheck();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        timeLabel.setName("time");
        Dimension td = new Dimension(this.getWidth(), 30);
        timeLabel.setMaximumSize(td);
        timeLabel.setPreferredSize(td);
        this.add(timeLabel);
        this.add(readyCheck);
        self = this;
        Client.INSTANCE.addListener(this);
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);

        /*
        * rl433
        * 5/1/23
        * Creating buttons for RPS and skip
        */
        JButton R = new JButton("Rock");
        JButton P = new JButton("Paper");
        JButton S = new JButton("Scissor");
        JButton skipButton = new JButton("Skip");
        JButton spectatorButton = new JButton("Spectator");
        JButton awayButton = new JButton("Away");
        buttonsPanel.add(R);
        buttonsPanel.add(P);
        buttonsPanel.add(S);
        buttonsPanel.add(skipButton);
        buttonsPanel.add(awayButton);
        R.addActionListener((event) -> {
            try {
                Client.INSTANCE.sendChoiceStatus("R");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        P.addActionListener((event) -> {
            try {
                Client.INSTANCE.sendChoiceStatus("P");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        S.addActionListener((event) -> {
            try {
                Client.INSTANCE.sendChoiceStatus("S");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        skipButton.addActionListener((event) -> {
            try {
                Client.INSTANCE.sendSkipStatus();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        awayButton.addActionListener((event) -> {
            try {
                Client.INSTANCE.sendAwayStatus();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonsPanel.setPreferredSize(new Dimension(200, 70));
        this.add(buttonsPanel, BorderLayout.WEST);
    }

    public void setUserListPanel(UserListPanel ulp) {
        this.ulp = ulp;
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

            JButton spectatorButton = new JButton("Spectate Mode");
            spectatorButton.addActionListener((event) -> {
                if (!Client.INSTANCE.isCurrentPhase(Phase.READY)) {
                    return;
                }
                try {
                    Client.INSTANCE.sendSpectatorStatus();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
            readyCheck.add(spectatorButton, BorderLayout.NORTH);
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
        if (currentTimer == null) {
            currentTimer = new TimedEvent(30, () -> {
                currentTimer = null;
            });
            currentTimer.setTickCallback((time) -> {
                timeLabel.setText("Remaining: " + time);
            });
        }
    }

    @Override
    public void onReceiveReadyCount(long count) {
        logger.info(
                Constants.ANSI_BRIGHT_BLUE + String.format("Received ready count %s", count) + Constants.ANSI_RESET);
        if (currentTimer != null && count == 0) {
            currentTimer.cancel();
            currentTimer = null;
        }
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
        currentPhase = phase;
        Dimension td = new Dimension(this.getWidth(), 30);
        timeLabel.setMaximumSize(td);
        timeLabel.setPreferredSize(td);
        if (phase == Phase.READY) {
            readyCheck.setVisible(true);
            gridLayout.setVisible(false);
        }

        if(Client.INSTANCE.getIsSpectator()) {
            buttonsPanel.setVisible(false);
        } else {
            buttonsPanel.setVisible(true);
        }

        // if (phase != Phase.READY) {
        if (currentTimer != null) {
            currentTimer.cancel();
            currentTimer = null;
        }
        // }
        if (phase != Phase.READY) {
            currentTimer = new TimedEvent(15, () -> {
                currentTimer = null;
            });
            currentTimer.setTickCallback((time) -> {
                timeLabel.setText("Remaining: " + time);
            });
        }
        this.validate();
        this.repaint();
        logger.info(
                Constants.ANSI_BRIGHT_MAGENTA + String.format("Dimension %s", this.getSize()) + Constants.ANSI_RESET);
    }

    public void onReceiveSpectator(long clientId, boolean isSpectator) {
        logger.info("Receiving sepctator for client: " + clientId + ", Spectator: " + isSpectator);
        if (ulp != null) {
            ulp.setSpectatorPlayer(clientId, isSpectator);
        }
    }

    /*
     * rl433
     * 5/4/23
     * Override method for onreceive away
     */
    @Override
    public void onReceiveAway(long clientId, boolean isAway) {
        logger.info("Away triggered for client: " + clientId + ", away: " + isAway);
        ulp.setAwayPlayer(clientId, isAway);
        if (isAway) {
            ulp.setSpectatorPlayer(clientId, true);
        }
    }

    @Override
    public void onReceiveOut(long clientId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'onReceiveOut'");
    }

    @Override
    public void onReceivePoints(long clientId, int points) {
        if (ulp != null) {
            ulp.setPointsForPlayer(clientId, points);
        }
    }
}