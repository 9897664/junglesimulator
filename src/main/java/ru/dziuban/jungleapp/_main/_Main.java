package ru.dziuban.jungleapp._main;

import ru.dziuban.jungleapp.model.Jaguar;
import ru.dziuban.jungleapp.util.EventSimulator;

public class _Main {

    public static void main(String[] args) {
        Jaguar jaguar = new Jaguar();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(jaguar);
    }

}
