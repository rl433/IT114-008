package Project.client.views;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.undo.CompoundEdit;

import Project.client.ClientUtils;
import Project.client.ICardControls;
import Project.client.views.UserListItem;

public class UserListPanel extends JPanel {
    JPanel userListArea;
    JPanel wrapper;
    private static Logger logger = Logger.getLogger(UserListPanel.class.getName());

    public UserListPanel(ICardControls controls) {
        super(new BorderLayout(10, 10));
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        // wraps a viewport to provide scroll capabilities
        JScrollPane scroll = new JScrollPane(content);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        // scroll.setBorder(BorderFactory.createEmptyBorder());
        // no need to add content specifically because scroll wraps it

        userListArea = content;
        this.wrapper = wrapper;
        wrapper.add(scroll);
        this.add(wrapper, BorderLayout.CENTER);

        userListArea.addContainerListener(new ContainerListener() {

            @Override
            public void componentAdded(ContainerEvent e) {
                if (userListArea.isVisible()) {
                    userListArea.revalidate();
                    userListArea.repaint();
                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                if (userListArea.isVisible()) {
                    userListArea.revalidate();
                    userListArea.repaint();
                }
            }

        });
    }

    protected void resizeUserListItems() {
        for (Component p : userListArea.getComponents()) {
            if (p.isVisible()) {
                // p.setPreferredSize(
                //         new Dimension(wrapper.getWidth(), ClientUtils.calcHeightForText(this,
                //                 ((JEditorPane) p).getText(), wrapper.getWidth())));
                // p.setMaximumSize(p.getPreferredSize());
                Dimension newSize = new Dimension(wrapper.getWidth(), 30);
                p.setPreferredSize(newSize);
                p.setMaximumSize(newSize);
            }
        }
        userListArea.revalidate();
        userListArea.repaint();
    }

    protected void addUserListItem(long clientId, String clientName) {
        logger.log(Level.INFO, "Adding user to list: " + clientName);
        JPanel content = userListArea;
        logger.log(Level.INFO, "Userlist: " + content.getSize());
        UserListItem uli = new UserListItem(clientName, clientId);
        Dimension newSize = new Dimension(wrapper.getWidth(), 30);
        uli.setPreferredSize(newSize);
        uli.setMaximumSize(newSize);
        // textContainer.setName(clientId + "");
        // // sizes the panel to attempt to take up the width of the container
        // // and expand in height based on word wrapping
        // textContainer.setLayout(null);
        // textContainer.setPreferredSize(
        //         new Dimension(content.getWidth(), ClientUtils.calcHeightForText(this, clientName, content.getWidth())));
        // textContainer.setMaximumSize(textContainer.getPreferredSize());
        // //textContainer.setEditable(false);
        // // remove background and border (comment these out to see what it looks like
        // // otherwise)
        // ClientUtils.clearBackground(textContainer);
        // add to container
        content.add(uli);
    }

    protected void removeUserListItem(long clientId) {
        logger.log(Level.INFO, "removing user list item for id " + clientId);
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            if (c instanceof UserListItem) {
                UserListItem u = (UserListItem) c;
                if (c.getName().equals(clientId + "")) {
                    userListArea.remove(c);
                    break;
                }
            }
        }
    }

    protected void clearUserList() {
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            userListArea.remove(c);
        }
    }

    public void setPointsForPlayer(long clientId, long points) {
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            if (c instanceof UserListItem) {
                UserListItem u = (UserListItem) c;
                if (u.getClientId() == clientId) {
                    u.setPoints(points);
                    break;
                }
            }
        }
    }

    public void setSpectatorPlayer(long clientId, boolean isSpectator) {
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            if (c instanceof UserListItem) {
                UserListItem u = (UserListItem) c;
                if (u.getClientId() == clientId) {
                    u.setSpectator(clientId);
                    break;
                }
            }
        }
    }
}