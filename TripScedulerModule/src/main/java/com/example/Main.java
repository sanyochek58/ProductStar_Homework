package com.example;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Trip> LEAK_CACHE = new ArrayList<>();

    private static final List<WeakReference<Trip>> WEAK_CACHE = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int objectCount = 30_000;

        System.out.println(" Симуляция утечки памяти");
        runLeakSituation(objectCount);

        // Очищаем статическую коллекцию вручную перед вторым тестом
        LEAK_CACHE.clear();
        runGcAndPrintMemory("После очистки LEAK_CACHE");

        System.out.println("\n Решение проблемы (WeakReference)");
        runWeakReferenceScenario(objectCount);
    }

    private static void runLeakSituation(int count) {
        printMemory("До создания объектов");

        for (int i = 0; i < count; i++) {
            Trip trip = new Trip("Route_" + i);
            LEAK_CACHE.add(trip);
        }

        printMemory("После создания " + count + " объектов (Leak)");
        runGcAndPrintMemory("После принудительного System.gc() при утечке");
    }

    private static void runWeakReferenceScenario(int count) {
        printMemory("До создания объектов");

        for (int i = 0; i < count; i++) {
            Trip trip = new Trip("Route_" + i);
            WEAK_CACHE.add(new WeakReference<>(trip));
        }

        printMemory("После создания " + count + " объектов (WeakReference)");
        runGcAndPrintMemory("После принудительного System.gc() с WeakReference");
    }

    private static void runGcAndPrintMemory(String label) {
        System.out.println("Вызываем System.gc()...");
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        printMemory(label);
    }

    private static void printMemory(String stage) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.printf("[%s]%n  Занято Heap:  %.2f MB%n  Выделено Heap: %.2f MB%n  Max Heap:   %.2f MB%n%n",
                stage,
                bytesToMB(usedMemory),
                bytesToMB(totalMemory),
                bytesToMB(runtime.maxMemory()));
    }

    private static double bytesToMB(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }
}