package Project.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import Project.common.Constants;
import Project.common.Phase;
import Project.common.Player;
import Project.common.TimedEvent;

public class GameRoom extends Room {
    Phase currentPhase = Phase.READY;
    private static Logger logger = Logger.getLogger(GameRoom.class.getName());
    private TimedEvent readyTimer = null;
    private ServerPlayer currentPlayer = null;
    private TimedEvent roundTimer = null;
    private ConcurrentHashMap<Long, ServerPlayer> players = new ConcurrentHashMap<Long, ServerPlayer>();

    public GameRoom(String name) {
        super(name);
    }

    @Override
    protected void addClient(ServerThread client) {
        logger.info("Adding client as player");
        players.computeIfAbsent(client.getClientId(), id -> {
            ServerPlayer player = new ServerPlayer(client);
            super.addClient(client);
            logger.info(String.format("Total clients %s", clients.size()));
            return player;
        });
    }

    protected void setReady(ServerThread client) {
        logger.info("Ready check triggered");
        if (currentPhase != Phase.READY) {
            logger.warning(String.format("readyCheck() incorrect phase: %s", Phase.READY.name()));
            return;
        }
        if (readyTimer == null) {
            sendMessage(null, "Ready Check Initiated, 30 seconds to join");
            readyTimer = new TimedEvent(30, () -> {
                readyTimer = null;
                readyCheck(true);
            });
        }
        if (players.containsKey(client.getClientId())) {
            players.get(client.getClientId()).setReady(true);
            logger.info(String.format("Marked player %s[%s] as ready", client.getClientName(), client.getClientId()));
            syncReadyStatus(client.getClientId());
        }
        readyCheck(false);
    }

    private void readyCheck(boolean timerExpired) {
        if (currentPhase != Phase.READY) {
            return;
        }
        // two examples for the same result
        // int numReady = players.values().stream().mapToInt((p) -> p.isReady() ? 1 :
        // 0).sum();
        long numReady = players.values().stream().filter(ServerPlayer::isReady).count();
        if (numReady >= Constants.MINIMUM_PLAYERS) {

            if (timerExpired) {
                sendMessage(null, "Ready Timer expired, starting session");
                start();
            } else if (numReady >= players.size()) {
                sendMessage(null, "Everyone in the room marked themselves ready, starting session");
                if (readyTimer != null) {
                    readyTimer.cancel();
                    readyTimer = null;
                }
                start();
            }

        } else {
            if (timerExpired) {
                resetSession();
                sendMessage(null, "Ready Timer expired, not enough players. Resetting ready check");
            }
        }
    }

    private synchronized void start() {
        updatePhase(Phase.PICKING);
        // TODO only do this if it's the first round
        players.values().stream().forEach(p -> p.setOut(false));
        // players.values().stream().forEach(p -> p.setSetIsOut(false));
        // pickRandom();
        // TODO example
        sendMessage(null, "Session started");
        new TimedEvent(15, () -> timeExpired());

    }

    protected void timeExpired() {
        updatePhase(Phase.OUTCOME);
        for (ServerPlayer player : players.values()) {
            if (!player.isReady() || player.getChoice() == null) {
                player.setSkipped(true);
                sendMessage(null, player.getClient().getClientName() + " skipped due to timeout");
            }
        }
        outcome();
    }

    // /*
    // * Picks player randomly or next player
    // */
    // private void pickRandom() {
    // if (currentPlayer == null && players.values().stream().count() > 0) {
    // // orElse() triggers when list is empty, shouldn't happen
    // currentPlayer = players.values().stream().filter(p ->
    // p.isReady()).findAny().orElse(null);
    // } else {
    // // find the next player in order or default to first ready
    // int currentPlayerIndex =
    // players.values().stream().toList().indexOf(currentPlayer) + 1;
    // currentPlayer =
    // players.values().stream().skip(currentPlayerIndex).findFirst().orElse(
    // players.values().stream().filter(p -> p.isReady()).findFirst().orElse(null));
    // }
    // }
    private int checkOutcome(String a, String b) {
        if (a.equals(b)) {
            return 0;
        } else if ((a.equals("R") && b.equals("S"))
                || (a.equals("S") && b.equals("P"))
                || (a.equals("P") && b.equals("R"))) {
            return 1;
        } else {
            return -1;
        }
    }

    protected void outcome() {
        // deal with skipped players first
        List<ServerPlayer> skipped = players.values().stream().filter(p -> p.getChoice() == null || p.getChoice().length() == 0
            || "skip".equals(p.getChoice())).toList();

        // players.values().forEach(p -> {
        //     if (p.getChoice() == null || p.getChoice().length() == 0 || "skip".equals(p.getChoice())) {
        //         p.setSkipped(true);
        //         p.setChoice("skip");
        //         sendMessage(null, "Player: " + p.getClient().getClientName() + " skipped his turn.");
        //     }
        // });
        List<ServerPlayer> active = players.values().stream().filter(p -> p.isReady() && p.isNotOut() &&
                !"skip".equals(p.getChoice())).toList();
        logger.info(String.format("%s Outcome Active Players %s %s", Constants.ANSI_BRIGHT_MAGENTA, active.size(),
                Constants.ANSI_RESET));
        if (active.size() > 1) {
            for (int i = 0; i < active.size(); i++) {
                ServerPlayer playerA = (ServerPlayer) active.get(i);
                int otherPlayer = i + 1;
                if (otherPlayer >= active.size()) {
                    otherPlayer = 0;
                }
                ServerPlayer playerB = active.get(otherPlayer);
    
                // important codes
                // players.values().filter(p->p.isReady()).forEach(p->P.setChoice(""));
                // players.values().filter(p->p.isReady()).forEach(p->{p.setChoice(""));p.setIsOut(false)};
                logger.info(String.format("%s PlayerA %s vs PlayerB %s %s", Constants.ANSI_BLUE, playerA.getChoice(),
                        playerB.getChoice(), Constants.ANSI_RESET));
                int outcome = checkOutcome(playerA.getChoice(), playerB.getChoice());
                if (outcome == 0) {
                    // tied
                    // TODO fix message show player A and Player B, their choices, and the result
                    sendMessage(null,
                            "Players: " + playerA.getClient().getClientName() + " and " + playerB.getClient().getClientName() + " both tied with " + playerA.getChoice());
                } else if (outcome == 1) {
                    // A won
                    // TODO fix message show player A and Player B, their choices, and the result
                    sendMessage(null,
                            "Player: " + playerA.getClient().getClientName() + " wins with " + playerA.getChoice() + " against Player: " +
                            playerB.getClient().getClientName() + " that chose " + playerB.getChoice());
                            playerB.setOut(true);
                } else {
                    // A lost
                    // TODO fix message show player A and Player B, their choices, and the result
                    sendMessage(null,
                            "Player: " + playerB.getClient().getClientName() + " wins with " + playerB.getChoice() + " against Player: " +
                            playerA.getClient().getClientName() + "that chose " + playerA.getChoice());
                            playerA.setOut(true);
                }
        
            }
        if (active.size() == 0) {
            sendMessage(null, "There are no more players.");

        }

            /*
             * if (playerA.getChoice().equals("R")) {
             * if (playerB.getChoice().equals("P")) {
             * sendMessage(null, "Player: " + playerB.getClient().getClientName() +
             * " wins with paper");
             * playerA.setOut(true);
             * }
             * }
             * if (playerA.getChoice().equals("P")) {
             * if (playerB.getChoice().equals("S")) {
             * sendMessage(null, "Player: " + playerB.getClient().getClientName() +
             * " wins with scissor");
             * playerA.setOut(true);
             * }
             * }
             * if (playerA.getChoice().equals("S")) {
             * if (playerB.getChoice().equals("R")) {
             * sendMessage(null, "Player: " + playerB.getClient().getClientName() +
             * " wins with rock");
             * playerA.setOut(true);
             * ;
             * }
             * }
             * if (playerB.getChoice().equals("R")) {
             * if (playerA.getChoice().equals("P")) {
             * sendMessage(null, "Player: " + playerA.getClient().getClientName() +
             * " wins with paper");
             * playerB.setOut(true);
             * ;
             * }
             * }
             * if (playerB.getChoice().equals("P")) {
             * if (playerA.getChoice().equals("S")) {
             * sendMessage(null, "Player: " + playerA.getClient().getClientName() +
             * " wins with scissor");
             * playerB.setOut(true);
             * ;
             * }
             * }
             * if (playerB.getChoice().equals("S")) {
             * if (playerA.getChoice().equals("R")) {
             * sendMessage(null, "Player: " + playerA.getClient().getClientName() +
             * " wins with rock");
             * playerB.setOut(true);
             * ;
             * }
             * }
             * if (playerB.getChoice().equals("S")) {
             * if (playerA.getChoice().equals("S")) {
             * sendMessage(null, "Both players have tied with scissor");
             * }
             * }
             * if (playerB.getChoice().equals("P")) {
             * if (playerA.getChoice().equals("P")) {
             * sendMessage(null, "Both players have tied with paper");
             * }
             * }
             * if (playerB.getChoice().equals("R")) {
             * if (playerA.getChoice().equals("R")) {
             * sendMessage(null, "Both players have tied with rock");
             * }
             * }
             */    

        }
        List<ServerPlayer> remainingPlayers = players.values().stream().filter(p -> {
            return p.isReady() && !p.isSkipped() && p.isNotOut();
        }).toList();
        
        if (remainingPlayers.size() == 1) {
            ServerPlayer winner = remainingPlayers.get(0);
            sendMessage(null, "Player " + winner.getClient().getClientName() + " wins the game.");
            resetSession();
        }

        else if (remainingPlayers.size() == 0) {
            sendMessage(null, "All players have tied.");
            resetSession();
        } if (skipped.size() > 1) {
            sendMessage(null, "Player: " + skipped.getClient().getClientName() + " skipped his turn.");
        }

        else if (remainingPlayers.size() > 1) {
            sendMessage(null, "Since there is no one winner, the game will start again.");
            start();
        }

    }

    /*
     * rl433
     * 4/6/23
     * setting the choices for the certain client
     */
    protected void setChoice(String choice, long clientId) {
        ServerPlayer sp = players.get(clientId);
        logger.info(String.format("%s ClientId %s chose %s %s", Constants.ANSI_BRIGHT_YELLOW, clientId,
                choice, Constants.ANSI_RESET));
        sp.setHold(choice);
    }

    protected void setSkipped(long clientId) {
        ServerPlayer sp = players.get(clientId);
        sp.setSkipped(true);
        //sendMessage(null, "Player: " + sp.getClient().getClientName() + " skipped his turn.");
        // ???
        /*
         * if (!sp.getClient().sendSkip(clientId) == true) {
         * players.values().stream().filter(ServerPlayer::isSkipped);
         * }
         */
    }

    // serverplayer.getChoice(CHOICE);
    // private synchronized void startRound() {
    // if (roundTimer != null) {
    // roundTimer.cancel();
    // roundTimer = null;
    // }
    // roundTimer = new TimedEvent(15, () -> {
    // sendMessage(null, "Times up!");
    // updatePhase(Phase.OUTCOME);
    // roundTimer = new TimedEvent(15, () -> {
    // sendMessage(null, "Times up!");
    // });
    // });
    // }

    // private synchronized void outPlayer() {
    // players.values().stream().forEach(p -> p.setSkipped(true));
    // updatePhase(Phase.OUTCOME);
    // }

    private synchronized void resetSession() {
        players.values().stream().forEach(p -> p.setReady(false));
        updatePhase(Phase.READY);
        sendMessage(null, "Session ended, please intiate ready check to begin a new one");
    }

    private void updatePhase(Phase phase) {
        if (currentPhase == phase) {
            return;
        }
        currentPhase = phase;
        // NOTE: since the collection can yield a removal during iteration, an iterator
        // is better than relying on forEach
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        while (iter.hasNext()) {
            ServerPlayer client = iter.next();
            boolean success = client.getClient().sendPhaseSync(currentPhase);
            if (!success) {
                handleDisconnect(client);
            }
        }
    }

    protected void handleDisconnect(ServerPlayer player) {
        if (players.containsKey(player.getClient().getClientId())) {
            players.remove(player.getClient().getClientId());
            super.handleDisconnect(null, player.getClient());
            logger.info(String.format("Total clients %s", clients.size()));
            sendMessage(null, player.getClient().getClientName() + " disconnected");
            if (players.isEmpty()) {
                close();
            }
        }
    }

    private void syncReadyStatus(long clientId) {
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        while (iter.hasNext()) {
            ServerPlayer client = iter.next();
            boolean success = client.getClient().sendReadyStatus(clientId);
            if (!success) {
                handleDisconnect(client);
            }
        }
    }

}