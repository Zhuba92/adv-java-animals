package us.mattgreen;
import com.sun.source.tree.TryTree;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserAnimal
{
    private List<Talkable> petList;

    public UserAnimal(List<Talkable> petList)
    {
        this.petList = petList;
    }

    public void getAnimal()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Would you like to create a cat or dog: ");
        try
        {
            String choice = keyboard.nextLine();
            if(choice.equals("dog"))
            {
                boolean isFriendly = true;
                System.out.println("Is your dog friendly (Y/N): ");
                try
                {
                    String friendly = keyboard.nextLine().toUpperCase();
                    if(friendly.equals("Y"))
                    {
                        isFriendly = true;
                    }
                    else
                    {
                        isFriendly = false;
                    }
                }
                catch (IllegalArgumentException xx)
                {
                    System.out.println(xx.getMessage());
                }

                System.out.println("What is the name of your dog: ");
                String name = keyboard.nextLine();
                Dog dog = new Dog(isFriendly, name);
                petList.add(dog);
            }
            else if(choice.equals("cat"))
            {
                System.out.println("What is the name of your cat: ");
                String name = keyboard.nextLine();
                System.out.println("How many mice has your cat killed: ");
                try
                {
                    int miceKilled = keyboard.nextInt();
                    Cat cat = new Cat(miceKilled, name);
                    petList.add(cat);
                }
                catch(InputMismatchException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else
            {
                System.out.println("Incorrect input detected");
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
