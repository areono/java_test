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
}3장문제



class Menu{
    private int id;
    private String name;
    private double price;

    public Menu(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
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

    private Menu [] MenuList;
    public Menuboard(){
        MenuList = new Menu[menus.length];
        for (int i = 0; i < menus.length; i++) {
            MenuList[i] = new Menu(i+1, menus[i], prices[i]);
        }
    }

    public static Menuboard makeBoard(){
        return new Menuboard();
    }

    public Menu getMenu(int index) {
        if(index >=1 && index <= MenuList.length)
            return MenuList[index-1];
        else return null;
    }
    public void print(){
        System.out.println("***** Best Coffee *****");
        for(Menu m : MenuList){
            m.print();
        }
        System.out.println("***********************");
    }

}
class MenuOrder {
    public static void makeOrder (){
       Menuboard mboard = Menuboard.makeBoard();
       mboard.print();

        Scanner in = new Scanner(System.in);

        System.out.print("How many kinds of drinks? ");
        int size = in.nextInt();

        Order order = new Order(size);
        for(int i=0;i<size;i++){
            System.out.print("Menu no? ");
            int num = in.nextInt();
            System.out.print("Quantity? ");
            int qty = in.nextInt();
            if(num <1 || num > Menuboard.menus.length){
                System.out.println("Menu id " +  num + " doesn't exist in our menuboard");
                i--;
                continue;
            }

            order.addMenu(num, qty);
            System.out.println("Your selected menu is added to the order");
        }
        in.close();

        order.print(mboard);
    }
}
class Order{
    private int [] num;
    private int [] qty;

    private int index = 0;
    public Order(int size){
        this.num = new int [size];
        this.qty = new int [size];
    }

    public void addMenu(int num, int qty){
        this.num[index] = num;
        this.qty[index] = qty;
        index++;

    }
    public void print(Menuboard mboard){
        System.out.println("** Order details **");
        for( int i=0;i<index;i++){
             Menu menu=mboard.getMenu(num[i]);
             if(menu != null) {
                 System.out.println("Menu: "+menu.getName() +" Qty: "+qty[i]+" Price: "+(int)(menu.getPrice()*qty[i]));
             }else {
                 System.out.println("Invalid menu number: "+num[i]);
             }
        }
    }

}
public class Main {
    public static void main(String[] args) {
        MenuOrder.makeOrder();
    }
}4-1,2problem*/

import java.awt.*;
import java.util.Scanner;

enum MAIN_MENU {
    Insert_front(0), Insert_rear(1), Remove_front(2), Remove_rear(3),
    Move_front(4), Move_rear(5), list_all(6), Exit(7);

    MAIN_MENU(int value) { this.value = value; }

    private final int value;
    public int value() { return value; }
}

enum SHAPE_TYPE {
    Shape_Rect(0), Shape_Circle(1), Shape_Line(2);

    SHAPE_TYPE(int value) { this.value = value; }

    private final int value;
    public int value() { return value; }
}

class UI {
    // msg를 출력한 후 정수 값 하나를 입력 받아 리턴
    // MAIN_MENU 선택을 위한 메소드
    static int getMainMenu(Scanner scanner) {
        System.out.println("Select one operation  ");   // 안내 문자 출력
        System.out.print(
                  "Insert(Front):" + MAIN_MENU.Insert_front.value() + ", "
                + "Insert(Rear):" + MAIN_MENU.Insert_rear.value() + ", "
                + "Remove(Front):" + MAIN_MENU.Remove_front.value() + ", "
                + "Remove(Rear):" + MAIN_MENU.Remove_rear.value() + ", "
                + "Move(Front):" + MAIN_MENU.Move_front.value() + ", "
                + "Move(Rear):" + MAIN_MENU.Move_rear.value() + ", "
                + "Print List:" + MAIN_MENU.list_all.value() + ", "
                + "Exit:" + MAIN_MENU.Exit.value() + " >> ");  // 연산 종류 출력

        int Menu = scanner.nextInt();                                // 사용자가 선택한 연산 입력

        return Menu;                                                 // 사용자가 선택한 연산 리턴
    }

    // msg를 출력한 후 정수 값 하나를 입력 받아 리턴
    // SHAPE_TYPE 선택을 위한 메소드
    static int getShape(Scanner scanner) {
        System.out.println("Select one Shape  ");// 안내 문자 출력
        System.out.print("Rectangle:0, Circle:1, Line:2 >> ");// Shape 종류 출력

       int shapeType = scanner.nextInt();// 사용자가 선택한 Shape 입력
        return shapeType; // 사용자가 선택한 Shape 리턴
    }

    // 안내 msg를 매개 변수로 받아 출력하고
    // 삽입할 도형의 Point 정보 하나를 입력 받아 리턴
    static public Point getWidthHeight(Scanner scanner, String msg) {
        // msg 출력
        System.out.print(msg);
        // width, height 변수 선언
        final int width;
        final int height;

        // width 입력
        width = scanner.nextInt();
        // height 입력
        height = scanner.nextInt();

        // 포인트 객체 생성
        Point point = new Point(width, height);

        //포인트 객체 리턴
        return point;
    }

    // 안내 msg를 매개 변수로 받아 출력하고
    // Circle 객체의 반지름 하나를 입력 받아 리턴
    static public int getRadius(Scanner scanner, String msg) {
        // msg 출력
        System.out.println(msg);
        // radius 변수 선언
        int radius;
        // radius 입력
        radius = scanner.nextInt();
        // radius 리턴
        return radius;
    }
}
class Point {
    int x; // 점의 x 좌표 값
    int y; // 점의 y 좌표 값

    // 객체 초기화: x, y 좌표 초기화
    public Point(int x, int y) {
        this.x = x;	this.y = y;
    }

    // x, y 좌표를 각각 width, height만큼 이동시킨다.
    public void move(int width, int height) {
        this.x += width;
        this.y += height;
    }

    // (x,y) 좌표 문자열을 리턴, 예) "(10, 15)"
    // 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
abstract class Shape {
    public abstract String draw();                       // 정보 출력
    public abstract void move(int width, int height);    // 좌표 이동
}

class Line extends Shape {
    private final Point p1;	// 사각형의 왼쪽 위쪽 좌표
    private final Point p2;	// 사각형의 오른쪽 아래쪽 좌표

    // 생성자 작성
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Shape 의 draw 메소드 오버라이딩
    // 실질적인 자료를 리턴하는 함수는 toString
    // 함수 내부에서 toString() 메소드 호출
    @Override
    public String draw() { return toString(); }

    // 화면에 라인의 좌표 값을 출력, 예) "Line (10,15) (20,30)"
    // 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
    @Override
    public String toString() {
        return ( "Line " + p1 + " " + p2 );
    }

    //기존 객체의 위치를 width, height만큼 옮긴다.
    public void move(int width, int height) {
        //기존 p1의 위치를 width, height만큼 옮긴다.
        p1.move(width, height);
        //기존 p2의 위치를 width, height만큼 옮긴다.
        p2.move(width, height);
    }
}
class Rect extends Shape {
    private final Point p1;	// 사각형의 왼쪽 위쪽 좌표
    private final Point p2;	// 사각형의 오른쪽 아래쪽 좌표

    //생성자: 멤버 초기화
    public Rect(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }


    // Shape 의 draw 메소드 오버라이딩
    @Override
    public String draw() {
        // 실질적인 자료를 리턴하는 함수는 toString
        // 함수 내부에서 toString() 메소드 호출
        return toString();
    }


    // 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
    @Override
    public String toString() {
        //화면에 사각형의 좌표 값을 출력, 예) "Rectangle (10,15) (20,30)"
        return ( "Rectangle  " + p1 + " " + p2);
    }

    public void move(int width, int height) {
        //기존 객체의 위치를 width, height만큼 옮긴다.
        p1.move(width,height);
        p2.move(width,height);
    }
}

class Circle extends Shape {
    private final Point center;	// 원의 중심 좌표
    private final int   radius;       	// 반지름의 길이

    //생성자: 멤버 초기화
    public Circle(int radius, Point center){
        this.center = center;
        this.radius = radius;
    }
    // Shape 의 draw 메소드 오버라이딩
    @Override
    public String draw() {
        // 실질적인 자료를 리턴하는 함수는 toString
        // 함수 내부에서 toString() 메소드 호출
        return toString();
    }

    // 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
    @Override
    public String toString() {
        //화면에 반지름과 중심 좌표 값을 출력, 예) "Circle 5 (20,30)"
        return ( "Circle " + radius + " " + center );
    }

    public void move(int width, int height) {
        //기존 객체의 위치를 width, height만큼 옮긴다.
        center.move(width, height);
    }
}


//*****************************************************************************
// linked list에서 자료 및 링크를 관리할 node 선언
class Node  {
    public Node next;
    public Node prev;

    private final Object value;   // 데이터 (업캐스팅을 통해서 관리 함, 모든 클래스의 최상위 클래스인 Object 클래스로 업캐스팅)

    public Node(Object value) {  next = null; prev = null; this.value = value; }  // 생성자
    public Object  getValue() { return value; }     // 현재 Node의 데이터 리턴
}


//*****************************************************************************
//double linked list를 위한 인터페이스 선언
interface LinkedList{
    void add_front(Object value);   // 리스트 맨 앞에 삽입
    void add_rear(Object value);    // 리스트 맨 뒤에 삽입
    boolean isEmpty();             // 리스트가 empty인지 확인
    Object remove_front();          // 리스트 맨 앞에서 삭제
    Object remove_rear();           // 리스트 맨 뒤에서 삭제
}


//*****************************************************************************


class ShapeList implements LinkedList{

    private Node head;	// double linked 리스트의 맨 처음 노드를 가리키는 포인터
    private Node tail;		// double linked 리스트의 맨 마지막 노드를 가리키는 포인터

    ShapeList() { head= null; tail = null;} // 생성자: 멤버 초기화

    // 리스트의 맨 앞의 노드를 리턴
    public Object get_frontValue() {
        // 리스트가 empty 이면
        // null 리턴
        // 리스트가 empty가 아니면
        // 맨 앞의 데이터 리턴,  head를 이용하여 getValue 메소드 호출
        if(isEmpty())
            return null;
        else
            return head.getValue();
    }

    // 리스트의 맨 뒤의 노드를 리턴
    public Object get_rearValue() {
        // 리스트가 empty 이면
        // null 리턴;
        // 리스트가 empty가 아이면
        // 맨 뒤의 데이터 리턴, tail을 이용하여 getValue 메소드 호출
        if(isEmpty())
            return null;
        else
            return tail.getValue();
    }

    // 리스트 맨 앞에 노드 삽입
    //  인터페이스 메소드 구현
    public void add_front(Object value) {

        Node newNode = new Node(value);// 노드를 생성합니다.
        newNode.next = head;// 새로운 노드의 다음 노드로 헤드를 지정합니다.
        if(!isEmpty()){// 기존에 노드가 있었다면
            newNode.prev = newNode;//  현재 헤드의 이전 노드로 새로운 노드를 지정
            // 헤드로 새로운 노드를 지정
        }
        else
            tail = newNode;
        // 노드가 하나인지 확인
        // tail 에 head 대입
        head = newNode;

    }

    // 리스트 맨 뒤에 노드 삽입
    //  인터페이스 메소드 구현
    public void add_rear(Object value) {
        if (isEmpty()) {   // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
            add_front(value);
        } else {
            Node newNode = new Node(value); 			// 노드를 생성합니다.
            tail.next = newNode; 	    	// tail의 다음 노드로 생성한 노드를 지정합니다.
            newNode.prev = tail;  	        // 새로운 노드의 이전 노드로 tail을 지정합니다.
            tail = newNode;  	        // 마지막 노드를 갱신합니다.
        }
    }


    // list 가 empty인지 확인
    //  인터페이스 메소드 구현
    public boolean isEmpty() {
        // head 와  tail 이 모두 null 이면
        // true 리턴
        // 그렇지 않으면
        // false 리턴
        return head == null && tail == null;
    }

    // 리스트 맨 앞에서 삭제
    //  인터페이스 메소드 구현
    //  remove_rear 참고
    public Object remove_front() {
        if(isEmpty())// list가 empty인지 확인
            return null;//  empty 이면  null 리턴

        Node temp = head;// 첫번째 노드를 temp로 지정하고
        head = null;// head 값 지우기  자바에서는 없어도 되는 부분
        head = temp.next;//  head의 값을 두번째 노드로 변경

        Object returnData = temp.getValue();// temp로부터 리턴할 값을 임시 변수(Object 타입)에 넣기
        temp =null;// temp 지우기  (temp=null)

        if(head != null)// head가 널이 아니면
            head.prev = null;// head의 이전 노드를 null로 지정

        return returnData;// 삭제된 데이터 리턴 (Object 타입)
    }

    // 리스트 맨 뒤에서 삭제
    //  인터페이스 메소드 구현
    public Object remove_rear() {
        if (isEmpty())       // list가 empty인지 확인
            return null;     //  empty 이면  null 리턴

        Node temp = tail;         // tail의 값을 임시변수(temp)에 저장
        tail = null;              // tail 지우기 (tail = null) 자바에서는 없어도 되는 부분
        tail = temp.prev;         // tail에 임시변수의 prev 넣기
        if (tail!= null)
            tail.next = null;      // tail의 next에 null 넣기
        else
            head=null;

        Object returnData = temp.getValue();  	 // temp로부터 리턴할 값을 임시 변수(Object 타입)에 넣기
        return returnData;              // 데이터 리턴 (Object 타입)
    }

    // 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();          // 가변형 String 변수 result 선언
        if (!isEmpty()) {                                            // 리스가 empty가 아니면
            Node node = head;                          // head를 새로운 변수 node에 넣기

            while (node != null) {                          // node가 null 이 아닌 동안
                result.append("[");                     //  result에 "[" 붙이기
                result.append(node.getValue());         //  result에  node.getValue() 호출해서 결과 붙이기
                result.append("]");                     //  result에 "]" 붙이기
                if (node.next==null)                    //  node.next 가 null 이면
                    result.append("\r\n");              //  result에 "\r\n" 붙이기
                else
                    result.append(", ");                 //  result에 ", " 붙이기
                node = node.next;                         //  node = node.next 로 다음 노드로 이동
            }
        }

        return result.toString();
    }
}



class GraphicEditor {
    private Shape createShape(Scanner scanner) {

        SHAPE_TYPE shapeType;
        Point p1, p2;
        int radius;

        int type = UI.getShape(scanner);

        shapeType = SHAPE_TYPE.values()[type] ;
        Shape shape = null;

        String msgpoint = "Enter point coordinates (enter two integers) >> ";
        String msgradius = "Enter the radius (enter one integer) >> ";

        switch (shapeType) {
            case Shape_Rect : // 사각형
                p1 = UI.getWidthHeight(scanner, msgpoint);
                p2 = UI.getWidthHeight(scanner, msgpoint);
                shape = new Rect(p1, p2);
                break;
            case Shape_Circle : // 원
                p1 = UI.getWidthHeight(scanner, msgpoint);
                radius = UI.getRadius(scanner, msgradius);
                shape = new Circle(radius, p1);
                break;
            case Shape_Line : // 라인
                p1 = UI.getWidthHeight(scanner, msgpoint);
                p2 = UI.getWidthHeight(scanner, msgpoint);
                shape = new Line(p1, p2);
                break;

        }
        return shape;
    }


    public void run() {
        ShapeList list = new ShapeList();             // shape 리스트를 관리할 객체 생성

        Scanner scanner = new Scanner(System.in);     // 사용자 입력을 위한 스캐너 객체 생성

        Shape shape = null;			  // 임시로 사용할 Shape 레퍼런스 변수 선언
        boolean  bLoop = true;                         // 반복문 관리용 부울린 변수
        Point p1;
        String msgpoint = "The two integers to move along the X and Y axes (enter two integers) >> ";

        while (bLoop) {
            int n = UI.getMainMenu(scanner);           // 메뉴 정보 읽어 오기
            MAIN_MENU menu = MAIN_MENU.values()[n] ;   // 열겨형의 정보로 변환

            switch (menu)
            {
                case Insert_front:	 // 리스트 앞에 삽입
                    shape = createShape(scanner);// 삽입을 위한 객체 생성
                    list.add_front(shape);//   리스트 앞에 삽입
                    break;
                case Insert_rear:  // 리스트 뒤에 삽입
                    shape = createShape(scanner);// 삽입을 위한 객체 생성
                    list.add_rear(shape);// 리스트 뒤에 삽입
                    break;
                case Remove_front:	// 리스트 앞에서 삭제
                    shape = (Shape)list.remove_front();// 리스트 앞에서 삭제 (리턴 값을 shape에 저장)
                    break;
                case Remove_rear: // 리스트 뒤에서 삭제
                    shape = (Shape) list.remove_rear();// 리스트 뒤에서 삭제 (리턴 값을 shape에 저장)
                    break;
                case Move_front:	// 첫 번째 Shape 이동하기
                    if (!list.isEmpty()) {
                        p1 = UI.getWidthHeight(scanner, msgpoint);
                        ((Shape)list.get_frontValue()).move(p1.x, p1.y);
                    }
                    break;
                case Move_rear:	// 마지막 Shape 이동하기
                    if (!list.isEmpty()) {
                        p1 = UI.getWidthHeight(scanner, msgpoint);
                        ((Shape)list.get_rearValue()).move(p1.x, p1.y);
                    }
                    break;// case가 종료 됐음에도 break를 하지않아 오답이 났음
                case list_all:	// 리스트 정보 출력
                    System.out.print(list.toString());
                    break;
                case Exit:
                    bLoop= false;  // 끝내기
            }
        }
        scanner.close();
    }
}

public class Main {

    public static void main(String[] args) {

        GraphicEditor g = new GraphicEditor();  		// GraphicEditor  생성
        g.run();                                                                // 실행 함수 호출

        System.out.println("Good Bye");
    }
}