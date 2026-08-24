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
        if (target != this) {
            target.health -= damage;
        }
        if (target.health <= 0) {
            target.health = 0;
            target.alive = false;
        }
    }

    public void heal(float cure) {
        if (this.isAlive()) {
            this.health += cure;
            if (this.health >= 1000) {
                this.health = 1000;
            }
        }
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

    public void setHealth(float health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
