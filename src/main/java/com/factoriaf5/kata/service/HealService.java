package com.factoriaf5.kata.service;

import com.factoriaf5.kata.model.Character;

public class HealService {
    public static boolean canHeal(Character healer, Character target) {
        return (healer.isAlly(target) || healer == target) && target.isAlive();
    }

    public static void heal(Character healer, Character target, float cure) {
        if (canHeal(healer, target)) {
            target.setHealth(target.getHealth() + cure);
            if (target.getHealth() > 1000) {
                target.setHealth(1000);
            }
        }
    }
}
