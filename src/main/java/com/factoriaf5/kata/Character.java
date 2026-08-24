package com.factoriaf5.kata;

public class Character {
    private float health;
    private int level;
    private boolean alive;

    public Character() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
    }
    
    public void attack(Character target, float damage) {
        target.health -= damage;
    }

    public float getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

}
