import java.util.*;
public class DC_HW_W{
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        System.out.println("Input => Output\n" + "Transmitter (Sender)");

        String [][]D = new String[1][];
        String [] T = new String[D.length+2];
        int k = 0;
        for(int i=0;i<10;i++){
            int count =0;
            System.out.print("D ");
            D[i] = new String[]{in.nextLine()};
            count++;

            for(int j=0;j<count;j++){
                if (D[i][j].equals("7E") || D[i][j].equals("1B")) {
                    D[i][k++] = "1B";
                }
                T[k++] = D[i][j];

            }
        }


        for (int i = 0; i < T.length; i++) {
            System.out.print("=>Tx ");
            System.out.println(T[i] + " ");
        }
    }
}