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
        character.attack(target, 100, 0);
        assertThat(target.getHealth(), is(900.0F));
    }

    @Test
    public void deathDamage() {
        Character character = new Character();
        Character target = new Character();
        character.attack(target, 1500, 0);
        assertThat(target.getHealth(), is(0.0F));
        assertThat(target.isAlive(), is(false));
    }

    @Test
    public void attackSelf() {
        Character character = new Character();
        character.attack(character, 100, 0);
        assertThat(character.getHealth(), is(1000.0F));
    }

    @Test
    public void moreLevelAttack() {
        Character character = new Character();
        Character target = new Character();
        character.setLevel(6);
        target.setLevel(1);
        character.attack(target, 100, 0); 
        assertThat(target.getHealth(), is(850.0F));
    }

    @Test
    public void lessLevelAttack() {
        Character character = new Character();
        Character target = new Character();
        character.setLevel(1);
        target.setLevel(6);
        character.attack(target, 100, 0); 
        assertThat(target.getHealth(), is(950.0F));
    }

    @Test
    public void succesfulMeleeAttack() {
        Character character = new MeleeFighter();
        Character target = new Character();
        character.attack(target, 100, 0);
        assertThat(target.getHealth(), is(900.0F));
    }

    @Test
    public void failedMeleeAttack() {
        Character character = new MeleeFighter();
        Character target = new Character();
        character.attack(target, 100, 3);
        assertThat(target.getHealth(), is(1000.0F));
    }

    @Test
    public void succesfulRangeAttack() {
        Character character = new RangedFighter();
        Character target = new Character();
        character.attack(target, 100, 19);
        assertThat(target.getHealth(), is(900.0F));
    }

    @Test
    public void failedRangeAttack() {
        Character character = new RangedFighter();
        Character target = new Character();
        character.attack(target, 100, 21);
        assertThat(target.getHealth(), is(1000.0F));
    }

    @Test
    public void normalHeal() {
        Character target = new Character();
        target.setHealth(500);
        target.heal(target, 100);
        assertThat(target.getHealth(), is(600.0F));
    }

    @Test
    public void fullHeal() {
        Character target = new Character();
        target.setHealth(950);
        target.heal(target, 100);
        assertThat(target.getHealth(), is(1000.0F));
    }

    @Test
    public void failedHeal() {
        Character target = new Character();
        target.setHealth(0);
        target.setAlive(false);
        target.heal(target, 100);
        assertThat(target.getHealth(), is(0.0F));
        assertThat(target.isAlive(), is(false));
    }

    @Test
    public void healAlly() {
        Character character = new Character();
        Character target = new Character();
        Faction alliance = new Faction("Alliance");
        character.joinFaction(alliance);
        target.joinFaction(alliance);
        target.setHealth(500);
        character.heal(target, 100);
        assertThat(target.getHealth(), is(600.0F));
    }

    @Test
    public void healEnemy() {
        Character character = new Character();
        Character target = new Character();
        Faction alliance = new Faction("Alliance");
        Faction horde = new Faction("Horde");
        character.joinFaction(alliance);
        target.joinFaction(horde);
        target.setHealth(500);
        character.heal(target, 100);
        assertThat(target.getHealth(), is(500.0F));
    }

}
