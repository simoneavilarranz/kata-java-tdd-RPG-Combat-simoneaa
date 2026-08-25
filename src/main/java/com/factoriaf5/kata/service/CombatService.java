package com.factoriaf5.kata.service;

import com.factoriaf5.kata.interfaces.Damageable;
import com.factoriaf5.kata.model.Character;

public class CombatService {

    private static float calculateEffectiveDamage(Character attacker, Character target, float damage) {
        float effectiveDamage = damage;
        if (target instanceof Character) {
                Character characterTarget = (Character) target;
                if (characterTarget.getLevel() >= attacker.getLevel() + 5) {
                    effectiveDamage = damage * 0.5F;
                }
                if (characterTarget.getLevel() <= attacker.getLevel() - 5) {
                    effectiveDamage = damage * 1.5F;
                } 
            }
        return effectiveDamage;
    }

    private static void applyDamage(Damageable target, float effectiveDamage) {
        target.setHealth(target.getHealth() - effectiveDamage);
    }

    private static void checkDeath(Damageable target) {
        if (target instanceof Character) {
            Character characterTarget = (Character) target;
            if (characterTarget.getHealth() <= 0) {
                characterTarget.setHealth(0);
                characterTarget.setAlive(false);
            }
        }
    }
    
    public static void attack(Character attacker, Damageable target, float damage, float distance) {
        if (target != attacker && distance <= attacker.getRange()) {
            float effectiveDamage;
            if (target instanceof Character) {
                effectiveDamage = calculateEffectiveDamage(attacker, (Character) target, damage);
            } else {
                effectiveDamage = damage;
            }
            applyDamage(target, effectiveDamage);
            checkDeath(target);
        }
    }
}
