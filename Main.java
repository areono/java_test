import java.util.*;

public class Main {
    public static void printArray(double [][]arr) {
        System.out.println("The number of rows in the array: " + arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print("arr[" + i + "] " );
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double[][] run1(Scanner s) {
        System.out.print("The number of rows in the real-number non-square array: " );
        int num = s.nextInt(); // 배열의 행의 개수 입력

        double [][] temp = new double [num][]; // 배열을 저장할 새로운 배열 동적 할당

        for(int i=0;i<num;i++){
            temp[i] = new double[i+1]; // 행별로 필요한 레퍼런스 배열 할당

            System.out.print("Input " +(i+1)+" real numbers in row "+ (i+1) +": ");

            for(int j=0;j<=i;j++){

                temp[i][j] = s.nextDouble();
            }
        }
        return temp;

    }
    public static double[][] run2(Scanner s) {
        while(true){
            System.out.print("The number of rows in the real-number non-square array: " );
            try {
                int num = s.nextInt(); // 배열의 행의 개수 입력
                double [][] temp = new double [num][]; // 배열을 저장할 새로운 배열 동적 할당
                for(int i=0;i<num;i++){
                    temp[i] = new double[i+1]; // 행별로 필요한 레퍼런스 배열 할당

                    System.out.print("Input " +(i+1)+" real numbers in row "+ (i+1) +": ");

                        for (int j = 0; j <= i; j++) {
                            try {
                                temp[i][j] = s.nextDouble();
                            }catch (InputMismatchException e){
                                System.out.println("Input an integer or a real number!");
                                s.nextLine();
                                i--;
                                break;
                            }
                        }


                }
                return temp;
            }catch (NegativeArraySizeException e){
                System.out.println("Input a positive integer!");
                s.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Input an integer!");
                s.nextLine();
            }
        }
    }
    public static void main(String[] args) {
        double [][]array = { {0}, {1,2}, {3,4,5} };
        printArray(array);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        double dArr1[][] = run1(scanner);
        printArray(dArr1);
        System.out.println();

        double dArr2[][] = run2(scanner);
        printArray(dArr2);
        System.out.println();

        scanner.close();
        System.out.println("Exit.");
    }
}