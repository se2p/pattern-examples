package de.unipassau.se2.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maze {
    private final List<Room> rooms = new ArrayList<>();
    private Room startRoom;
    private Room exitRoom;

    public void add(Room room) {
        rooms.add(room);
        if (startRoom == null) {
            startRoom = room;
        }
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
        if (!rooms.contains(startRoom)) {
            rooms.add(startRoom);
        }
    }

    public Room getExitRoom() {
        return exitRoom;
    }

    public void setExitRoom(Room exitRoom) {
        this.exitRoom = exitRoom;
        if (!rooms.contains(exitRoom)) {
            rooms.add(exitRoom);
        }
    }
}
