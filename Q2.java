import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int STUDENTS = 10;
        final int SUBJECTS = 5;

        float[][] grades = new float[STUDENTS][];


        for (int i = 0; i < STUDENTS; i++) {
            System.out.print("Enter number of subjects opted by Student " + (i + 1) + " (2-5): ");
            int n = sc.nextInt();
            while (n < 2 || n > SUBJECTS) {
                System.out.print("Invalid! Enter again (2-5): ");
                n = sc.nextInt();
            }

            grades[i] = new float[n];
            for (int j = 0; j < n; j++) {
                System.out.print("Enter grade of Student " + (i + 1) + " in Subject " + (j + 1) + ": ");
                grades[i][j] = sc.nextFloat();
            }
        }


     System.out.println("\n--- Result Summary ---");



        System.out.printf("%-10s", "Student");
        for (int j = 0; j < SUBJECTS; j++) {
            System.out.printf("%5s", "S" + (j + 1));
        }
        System.out.printf("%8s\n", "Avg");

   
        for (int i = 0; i < STUDENTS; i++) {
            System.out.printf("%-10s", "Stud" + (i + 1));
            float sum = 0;
            for (int j = 0; j < SUBJECTS; j++) {
                if (j < grades[i].length) {
                    System.out.printf("%5.2f", grades[i][j]);
                    sum += grades[i][j];
                } else {
                    System.out.printf("%5s", "-");
                }
            }
            float avg = sum / grades[i].length;
            System.out.printf("%8.2f\n", avg);
        }



        System.out.printf("%-10s", "Avg(Subj)");
        for (int j = 0; j < SUBJECTS; j++) {
            float sum = 0;
            int count = 0;
            for (int i = 0; i < STUDENTS; i++) {
                if (j < grades[i].length) {
                    sum += grades[i][j];
                    count++;
                }
            }
            if (count > 0) {
                System.out.printf("%5.2f", sum / count);
            } else {
                System.out.printf("%5s", "-");
            }
        }
        System.out.println();
         sc.close();
    }
}
