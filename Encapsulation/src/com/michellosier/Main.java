package com.michellosier;

public class Main {

    public static void main(String[] args) {
//        Player player = new Player();
//        player.fullName = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());

//        EnhancedPlayer player = new EnhancedPlayer("Mike", 100, "Whip");
//        System.out.println("Remaining health = " + player.getHealth());

         Printer printer = new Printer(30, true);
         printer.fillToner(80);
         printer.fillToner(40);
         printer.printPages(4);
    }

}
