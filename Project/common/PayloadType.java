package Project.common;

public enum PayloadType {

    /*
     * rl433
     * 4/1/23
     * enums 
     */
    CONNECT, DISCONNECT, MESSAGE, CLIENT_ID, RESET_USER_LIST,
    SYNC_CLIENT, CREATE_ROOM, JOIN_ROOM, GET_ROOMS,
    READY, PHASE, SKIP, CHOICE, OUT
}