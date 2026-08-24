package com.factoriaf5.kata;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private float health;
    private int level;
    private boolean alive;
    protected float range;
    private float distance;

    List<Faction> factions = new ArrayList<>();

    public Character() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
    }
    
    public void attack(Character target, float damage, float distance) {
        if (target != this && distance <= this.range && !this.isAlly(target)) {
            float effectiveDamage = damage;
            if (target.level >= this.level + 5) {
                effectiveDamage = damage * 0.5F;
            }
            if (target.level <= this.level - 5) {
                effectiveDamage = damage * 1.5F;
            }
            target.health -= effectiveDamage;
        }
        if (target.health <= 0) {
            target.health = 0;
            target.alive = false;
        }
    }

    public void heal(Character target, float cure) {
        if ((target == this || this.isAlly(target)) && target.isAlive()) {
            target.health += cure;
            if (target.health >= 1000) {
                target.health = 1000;
            }
        }
    }

    public void joinFaction(Faction faction) {
        factions.add(faction);
    }

    public void leaveFaction(Faction faction) {
        factions.remove(faction);
    }

    public boolean isAlly(Character other) {
        for (Faction faction : this.factions) {
            if (other.factions.contains(faction)) {
                return true;
            }
        }
        return false;
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

    public float getRange() {
        return range;
    }

    public float getDistance() {
        return distance;
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

    public void setRange(float range) {
        this.range = range;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

}
