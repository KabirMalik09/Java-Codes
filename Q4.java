import java.util.*;

public class Q4 {
    
    public static void main(String[] args) {
    
            Scanner sc = new Scanner(System.in);
        
            System.out.print("Enter a string: ");

            String str = sc.nextLine();
            str.toLowerCase();
            char one = str.charAt(1);



    

            if ((one == 'a' || one == 'c' || one == 'w' || one == 'm') && str.length() > 4) {

                System.out.println("Finding roots of equation.");


                System.out.println("Enter the value of a: ");
                float a = sc.nextFloat();
                System.out.println("Enter the value of b: ");
                float b = sc.nextFloat();
                System.out.println("Enter the value of c: ");
                float c = sc.nextFloat();

                float d = (b * b) - (4 * a * c);

                if (d > 0) {
                    float root1 = (float)((-b + Math.sqrt(d)) / (2 * a));
                    float root2 = (float)((-b - Math.sqrt(d)) / (2 * a));
                    System.out.println("Roots are real and different.");
                    System.out.println("Root 1: " + root1);
                    System.out.println("Root 2: " + root2);

                } else if (d == 0) {
                    float root = -b / (2 * a);
                    System.out.println("Roots are real and same.");
                    System.out.println("Root: " + root);

                } else {
                    System.out.println("Roots are complex and imaginary.");
                }

            }

            

            else if (one == 'e' || one == 'q' || one == 'z' ) { 

                System.out.println("Enter a number: ");
                int num = sc.nextInt();

                boolean isPrime = true;
                if (num < 2) {
                    isPrime = false;
                } else {
                    for (int i = 2; i <= Math.sqrt(num); i++) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }

                if (isPrime) { 
                    int a = 1;

                    do{
                        if (a % 2 != 0) {
                            System.out.print(a + " ");
                        }
                        a++;
                    } while (a <= 50);
                    System.out.println();
                }

            }

            else {
                System.out.println("Name of Dev is Rudra");
            }


    sc.close();

    }



}