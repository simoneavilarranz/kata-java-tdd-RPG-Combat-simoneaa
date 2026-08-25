package com.factoriaf5.kata.model;

import com.factoriaf5.kata.interfaces.Damageable;

public class Prop implements Damageable {
    private float health;

    public Prop(float health) {
        this.health = health;
    }

    @Override
    public float getHealth() {
        return this.health;
    }

    @Override
    public boolean isDestroyed() {
        return this.health <= 0;
    }

    @Override
    public void setHealth(float health) {
        this.health = health;
        
    }

    
}
