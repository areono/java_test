/*public class Main {
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
}3장문제 */


   class Menu{
     private int id;
     private String name;
     private double price;

     public Menu(int id, String name, double price){
         this.id = id;
         this.name = name;
         this.price = price;
     }
     public int getId(int id){// 단순히 멤버변수의 값을 반환하는 일을 한다.
         return id;
     }
     public void setId(int id){//매개변수에 저장된 값을 검사하여 조건에 맞는 값일 때만 멤버변수의 값을 변경하도록 한다.
         this.id = id;
     }

    public String getName(String name){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getPrice(double price){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public void print(){
        System.out.println(this.id + ": " + this.name + " [" + this.price/1000 + "]");
    }
}
class Menuboard{
      static String []   menus = {"Americano", "Latte", "Mocca", "Cappuccino",
              "Milk Tea", "Chi Tea", "Lemon Sweet", "Jamong Honey"};
      static double []     prices = {4100, 4300, 4300, 4800, 5100, 5300, 5800, 6100};

      private Menu [] MenuList; // Menu에 삽입할 메뉴리스르 배열 생성
      private Menuboard(){
          MenuList = new Menu[menus.length];
          for (int i = 0; i < menus.length; i++) {
             MenuList[i] = new Menu(i+1, menus[i], prices[i]);
          }

      }

      public static Menuboard makeBoard(){
             return new Menuboard();

      }

      public void print(){
          System.out.println("***** Best Coffee *****");
          for(Menu m : MenuList){
              m.print();
          }
          System.out.println("***********************");
      }

}

public class Main {
    public static void main(String[] args) {
        Menuboard mboard = Menuboard.makeBoard();// 이부분에서 makeBoard는 static이구나를 파악한다.
        //Menuboard의 객체를 생성하는 부분이므로 Menuboard 생정자에서 객체 저장을 담당한다.
        mboard.print();
    }
}
