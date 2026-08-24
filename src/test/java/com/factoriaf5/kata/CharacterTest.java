package com.factoriaf5.kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void checkHealth() {
        Character character = new Character();
        assertThat(character.getHealth(), is(1000.0F));
    }

    @Test
    public void checkLevel() {
        Character character = new Character();
        assertThat(character.getLevel(), is(1));
    }

    @Test
    public void checkAlive() {
        Character character = new Character();
        assertThat(character.isAlive(), is(true));
    }

    @Test
    public void basicAttack() {
        Character character = new Character();
        Character target = new Character();
        character.attack(target, 100);
        assertThat(target.getHealth(), is(900.0F));
    }

    @Test
    public void deathDamage() {
        Character character = new Character();
        Character target = new Character();
        character.attack(target, 1500);
        assertThat(target.getHealth(), is(0.0F));
        assertThat(target.isAlive(), is(false));
    }

    @Test
    public void normalHeal() {
        Character character = new Character();
        Character target = new Character();
        target.setHealth(500);
        character.heal(target, 100);
        assertThat(target.getHealth(), is(600.0F));
    }

    @Test
    public void fullHeal() {
        Character character = new Character();
        Character target = new Character();
        target.setHealth(950);
        character.heal(target, 100);
        assertThat(target.getHealth(), is(1000.0F));
    }

    @Test
    public void failedHeal() {
        Character character = new Character();
        Character target = new Character();
        target.setHealth(0);
        target.setAlive(false);
        character.heal(target, 100);
        assertThat(target.getHealth(), is(0.0F));
        assertThat(target.isAlive(), is(false));
    }
}
