package de.unipassau.se2.maze;

public class Player {
    private Room currentRoom;
    private int health = 10;
    private int score = 0;
    private boolean hasKey;

    public Player(Room startRoom) {
        currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void moveTo(Room room) {
        currentRoom = room;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int amount) {
        health = Math.max(0, health - amount);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void pickUpKey() {
        hasKey = true;
    }
}
