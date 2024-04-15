package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        VideoGame plok = new VideoGame("Adventure", "2D Platformer", "E", false, false);
        VideoGame splatoon3 = new VideoGame("Action", "Third-Person Shooter", "E10+", true, true);
        VideoGame miitopia = new VideoGame("Role-Playing Game", "Turn-Based RPG", "E10+",false, true);

        System.out.println(miitopia.getRating());
        miitopia.setRating("MA");

        System.out.println("To comply with the rating Miitopia has in Russia, Miitopia in the US is now " + miitopia.getRating());

    }
}