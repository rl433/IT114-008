package Project.client.views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import Project.client.ClientUtils;
import Project.common.Constants;

public class UserListItem extends JPanel {
    private static Logger logger = Logger.getLogger(UserListPanel.class.getName());
    private long clientId;
    private String clientName;
    private long points;
    private boolean isSpectator = false;
    private boolean isAway = false;
    JEditorPane text = new JEditorPane("text/plain", "");

    JButton spectatorIndicator = new JButton("Specatator");
    JButton awayIndicator = new JButton("Away");

    public UserListItem(String clientName, long clientId) {
        this.clientId = clientId;
        this.clientName = clientName;
        // setBackground(Color.BLUE);

        Dimension d = new Dimension(30, 30);
        awayIndicator.setEnabled(false);
        awayIndicator.setVisible(false);
        spectatorIndicator.setEnabled(false);
        spectatorIndicator.setVisible(false);
        spectatorIndicator.setPreferredSize(d);
        spectatorIndicator.setMinimumSize(d);
        spectatorIndicator.setMaximumSize(d);
        awayIndicator.setPreferredSize(d);
        awayIndicator.setMinimumSize(d);
        awayIndicator.setMaximumSize(d);
        text.setEditable(false);
        text.setText(getBaseText());
        this.add(spectatorIndicator);
        this.add(awayIndicator);
        this.add(text);
        ClientUtils.clearBackground(text);
    }

    private String getBaseText() {
        return String.format("%s[%s] Pts.(%s)", clientName, clientId, points);
    }

    public long getClientId() {
        return clientId;
    }

    public void setPoints(long points) {
        this.points = points;
        text.setText(getBaseText());
        repaint();
    }

    public void setSpectator(long clientId) {
        logger.log(Level.INFO, "Checking client: " + clientId + ", Spectating: " + isSpectator);
        if (this.clientId == clientId && clientId != Constants.DEFAULT_CLIENT_ID) {
            if (!isSpectator) {
                isSpectator = true;
                logger.log(Level.INFO, "Checking second client: " + clientId + ", Spectating: " + isSpectator);
                spectatorIndicator.setBackground(Color.ORANGE);
                spectatorIndicator.setVisible(true);
            } else {
                isSpectator = false;
                logger.log(Level.INFO, "Checking third client: " + clientId + ", Spectating: " + isSpectator);
                spectatorIndicator.setVisible(false);
            }
        }
        revalidate();
        repaint();
    }

    public void setAway(long clientId) {
        logger.log(Level.INFO, "Checking client: " + clientId + ", Away: " + isAway);
        if (this.clientId == clientId && clientId != Constants.DEFAULT_CLIENT_ID) {
            if (!isAway) {
                isAway = true;
                logger.log(Level.INFO, "Checking second client: " + clientId + ", Away: " + isAway);
                awayIndicator.setBackground(Color.ORANGE);
                awayIndicator.setVisible(true);
            } else {
                isAway = false;
                logger.log(Level.INFO, "Checking third client: " + clientId + ", Away: " + isAway);
                awayIndicator.setVisible(false);
            }
        }
        revalidate();
        repaint();
    }
}