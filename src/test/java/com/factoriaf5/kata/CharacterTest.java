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

}
