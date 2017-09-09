import java.util.Scanner;

public class MadLibs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a color: ");
        String color = scan.nextLine();
        System.out.println("Enter a past tense verb: ");
        String pastTenseVerb = scan.nextLine();
        System.out.println("Enter an adjective: ");
        String adjective = scan.nextLine();
        System.out.println("Enter a noun: ");
        String noun = scan.nextLine();
        
        System.out.print("The " + color + " dragon " + pastTenseVerb + " at the " + adjective);
        System.out.println(" knight, who rode in on a sturdy, giant " + noun + "."); 

    }

}
