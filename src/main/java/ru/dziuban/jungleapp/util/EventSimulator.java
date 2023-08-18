package ru.dziuban.jungleapp.util;

import ru.dziuban.jungleapp.model.Jaguar;

public class EventSimulator {

    // 0 - 10 // 10% // ягуар поспал - +8 энергии
    // 10 - 20 // 10% // ягуар просто пробежал -5 энергии
    // 20 - 30 // 10% // ягуар запрыгнул на дерево - 8 energy
    // 30 - 40 // 10% // на ягуара напал охотник - 20 здоровья
    // 40 - 50 // 10% // ягуар съел капибару -4 energy; coeff * 6 здоровья
    // 50 - 60 // 10% // ягуар съел анаконду -10 energy; coeff * 8 здоровья
    // 60 - 70 // 10% // на ягуара напала пума - 12 здоровья
    // 70 - 80 // 10% // ягуар съел каймана -5 energy; coeff * 8 здоровья
    // 80 - 90 // 10% // ягуар поплавал -3 energy
    // 90 - 100 // 10% // ягуар нашёл оставленную кем-то добычу -2 energy; coeff * 4 здоровья
    // энергия = 0 то -5 здоровья

    private void activatEvent() {

    }

    private void sleepEvent(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        energy = energy + 8;
        if (energy > 100) {
            energy = 100;
        }
        jaguar.setEnergy(energy);
        System.out.println("Ягуар поспал! +8 энергии.");
    }

    private void move(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        jaguar.setEnergy(energy);
        System.out.println("Ягуар побегал! -5 энергии.");
    }

    private void jump(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        energy = energy - 8;
        if (energy < 0) {
            energy = 0;
        }
        jaguar.setEnergy(energy);
        System.out.println("Ягуар запрыгнул на дерево! -8 энергии.");
    }

    private void hunterAttack(Jaguar jaguar) {
        int health = jaguar.getHealth();
        health = health - 20;
        if (health < 0) {
            health = 0;
        }
        jaguar.setHealth(health);
        System.out.println("О нет! На ягуара напал охотник! -20 энергии.");
    }

    private void ateCapybara(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        int health = jaguar.getHealth();
        energy = energy - 4;
        if (energy > 100) {
            energy = 100;
        }
        health = health + (int) (jaguar.getFangs() * 4);
        if (health > 100) {
            health = 100;
        }
        jaguar.setEnergy(energy);
        jaguar.setHealth(health);
        System.out.println("Ягуар съел капибару! -4 энергии.");
    }

    private void ateAnaconda(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        int health = jaguar.getHealth();
        energy = energy - 10;
        if (energy > 100) {
            energy = 100;
        }
        health = health + (int) (jaguar.getFangs() * 8);
        if (health > 100) {
            health = 100;
        }
        jaguar.setEnergy(energy);
        jaguar.setHealth(health);
        System.out.println("Ягуару повезло, он съел анаконду! -10 энергии.");
    }

    private void pumaAttack(Jaguar jaguar) {
        int health = jaguar.getHealth();
        health = health - 12;
        if (health < 0) {
            health = 0;
        }
        jaguar.setHealth(health);
        System.out.println("О нет! На ягуара напала пума! -12 энергии.");
    }

    private void ateCayman(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        int health = jaguar.getHealth();
        energy = energy - 5;
        if (energy > 100) {
            energy = 100;
        }
        health = health + (int) (jaguar.getFangs() * 8);
        if (health > 100) {
            health = 100;
        }
        jaguar.setEnergy(energy);
        jaguar.setHealth(health);
        System.out.println("Ягуар съел каймана! -5 энергии");
    }

}


