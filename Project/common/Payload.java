package Project.common;

import java.io.Serializable;

public class Payload implements Serializable {
    // read https://www.baeldung.com/java-serial-version-uid
    private static final long serialVersionUID = 1L;// change this if the class changes

    /**
     * rl433
     * 4/6/23
       Determines how to process the data on the receiver's side
     */
    private PayloadType payloadType;

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    /**
     * rl433
     * 4/6/23
       Who the payload is from
     */
    private String clientName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private long clientId;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    private String choice;

    public void setChoice(String choice) {
        this.choice = choice;
    }
    public String getChoice() {
        return choice;
    }
    /**
     * rl433
     * 4/6/23
       Generic text based message
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*
     * rl433
     * 4/6/23
     * Override toString message
     * formats the message as payloadtype, changing it to string, clientid, clientname, and
     * getting the message
     */
    @Override
    public String toString() {
        return String.format("Type[%s],ClientId[%s] ClientName[%s], Message[%s]", getPayloadType().toString(),
                getClientId(), getClientName(),
                getMessage());
    }
}