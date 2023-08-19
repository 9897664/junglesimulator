package ru.dziuban.jungleapp.util;

import ru.dziuban.jungleapp.model.Jaguar;

public class EventSimulator {

    // 0 - 10 // 10% // ягуар поспал - +7 энергии
    // 10 - 20 // 10% // ягуар просто пробежал -6 энергии
    // 20 - 30 // 10% // ягуар запрыгнул на дерево - 10 energy
    // 30 - 40 // 10% // на ягуара напал охотник - 25 здоровья
    // 40 - 50 // 10% // ягуар съел капибару -6 energy; coeff * 4 здоровья
    // 50 - 60 // 10% // ягуар съел анаконду -15 energy; coeff * 6 здоровья
    // 60 - 70 // 10% // на ягуара напала пума - 17 здоровья
    // 70 - 80 // 10% // ягуар съел каймана -5 energy; coeff * 4 здоровья
    // 80 - 90 // 10% // ягуар поплавал -3 energy
    // 90 - 100 // 10% // ягуар нашёл оставленную кем-то добычу -2 energy; coeff * 4 здоровья
    // энергия = 0 то -5 здоровья

    public void startSimulation(Jaguar jaguar) {
        while (checkStatus(jaguar)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 10) {
                sleepEvent(jaguar);
            } else if (eventNumber >= 10 && eventNumber < 20) {
                move(jaguar);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                jump(jaguar);
            } else if (eventNumber >= 30 && eventNumber < 40) {
                hunterAttack(jaguar);
            } else if (eventNumber >= 40 && eventNumber < 50) {
                ateCapybara(jaguar);
            } else if (eventNumber >= 50 && eventNumber < 60) {
                ateAnaconda(jaguar);
            } else if (eventNumber >= 60 && eventNumber < 70) {
                pumaAttack(jaguar);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                ateCayman(jaguar);
            } else if (eventNumber >= 80 && eventNumber < 90) {
                swim(jaguar);
            } else if (eventNumber >= 90 && eventNumber < 100) {
                ateSnack(jaguar);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("Ооо нет! Ягуар умер! The end!");
    }

    private void sleepEvent(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        energy = energy + 7;
        if (energy > 100) {
            energy = 100;
        }
        jaguar.setEnergy(energy);
        energyChecker(jaguar);
        System.out.println("Ягуар поспал! +7 энергии.");
    }

    private void move(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        energy = energy - 6;
        if (energy < 0) {
            energy = 0;
        }
        jaguar.setEnergy(energy);
        energyChecker(jaguar);
        System.out.println("Ягуар побегал! -5 энергии.");
    }

    private void jump(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        jaguar.setEnergy(energy);
        energyChecker(jaguar);
        System.out.println("Ягуар запрыгнул на дерево! -10 энергии.");
    }

    private void hunterAttack(Jaguar jaguar) {
        int health = jaguar.getHealth();
        health = health - 25;
        if (health < 0) {
            health = 0;
        }
        jaguar.setHealth(health);
        energyChecker(jaguar);
        System.out.println("О нет! На ягуара напал охотник! -25 энергии.");
    }

    private void ateCapybara(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        int health = jaguar.getHealth();
        energy = energy - 6;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (jaguar.getFangs() * 4);
        if (health > 100) {
            health = 100;
        }
        jaguar.setEnergy(energy);
        jaguar.setHealth(health);
        energyChecker(jaguar);
        System.out.println("Ягуар съел капибару! -6 энергии.");
    }

    private void ateAnaconda(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        int health = jaguar.getHealth();
        energy = energy - 15;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (jaguar.getFangs() * 6);
        if (health > 100) {
            health = 100;
        }
        jaguar.setEnergy(energy);
        jaguar.setHealth(health);
        energyChecker(jaguar);
        System.out.println("Ягуару повезло, он съел анаконду! -15 энергии.");
    }

    private void pumaAttack(Jaguar jaguar) {
        int health = jaguar.getHealth();
        health = health - 17;
        if (health < 0) {
            health = 0;
        }
        jaguar.setHealth(health);
        energyChecker(jaguar);
        System.out.println("О нет! На ягуара напала пума! -17 энергии.");
    }

    private void ateCayman(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        int health = jaguar.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (jaguar.getFangs() * 4);
        if (health > 100) {
            health = 100;
        }
        jaguar.setEnergy(energy);
        jaguar.setHealth(health);
        energyChecker(jaguar);
        System.out.println("Ягуар съел каймана! -5 энергии.");
    }

    private void swim(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        energy = energy - 3;
        if (energy < 0) {
            energy = 0;
        }
        jaguar.setEnergy(energy);
        energyChecker(jaguar);
        System.out.println("Ягуар поплавал! -3 энергии.");
    }

    private void ateSnack(Jaguar jaguar) {
        int energy = jaguar.getEnergy();
        int health = jaguar.getHealth();
        energy = energy - 2;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (jaguar.getFangs() * 4);
        if (health > 100) {
            health = 100;
        }
        jaguar.setEnergy(energy);
        jaguar.setHealth(health);
        energyChecker(jaguar);
        System.out.println("Ягуар нашёл оставленную добычу! -2 энергии.");
    }

    private boolean checkStatus(Jaguar jaguar) {
        System.out.println("hp: " + jaguar.getHealth() + " energy: " + jaguar.getEnergy());
        return jaguar.getHealth() > 0;
    }

    private void energyChecker(Jaguar jaguar) {
        if (jaguar.getEnergy() <= 0) {
            int health = jaguar.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            jaguar.setHealth(health);
        }
    }

}


