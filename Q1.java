import java.util.*;
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter no element: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter arr element:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("enter finding element: ");
        int key = sc.nextInt();

        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("not found.");
            return;
        }



 
        for (int i = 0; i < idx; i++) {
            int temp = arr[0];


            for (int j = 0; j < n - 1; j++) {
            arr[j] = arr[j + 1];
            }
   
            arr[n - 1] = temp;
        }




        System.out.println("changed array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
     sc.close();
    }
}

    