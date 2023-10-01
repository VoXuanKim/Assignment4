package fa.training.services;


import fa.training.entities.Magazine;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MagazineService {
    private List<Magazine> magazines;

    public MagazineService() {
        magazines = new ArrayList<>();
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public void displayMagazines() {
        if (magazines.isEmpty()) {
            System.out.println("No magazines found in the library.");
        } else {
            System.out.println("List of Magazines:");
            for (Magazine magazine : magazines) {
                magazine.display();
                System.out.println("---------------");
            }
        }
    }

    public void displayTopMagazinesByVolume(int topCount) {
        magazines.sort(Comparator.comparing(Magazine::getVolume).reversed());
        int count = 0;
        System.out.println("Top " + topCount + " magazines by volume:");
        for (Magazine magazine : magazines) {
            if (count >= topCount) {
                break;
            }
            System.out.println();
            magazine.display();
            count++;
        }
    }
}
