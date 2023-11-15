import java.util.*;
public class Main{
    public static void main(String[] args) {
        //입력할 데이터
        Scanner in = new Scanner(System.in);
        StringBuilder txOutput = new StringBuilder();
        StringBuilder rxOutput = new StringBuilder();
        System.out.println( "Input=>Output");

        int loopCount = 0;
        while(loopCount < 10) {
            System.out.print("D ");
            String str1 = in.nextLine();

            if(str1.equalsIgnoreCase("exit")) break;

            String[] Data1 = str1.split(" ");  // 공백일 때 분리

            //TX1 배열에 추가 할 값 세기
            int count = 0 ;
            for(String s : Data1){
                if(s.equals("7E")|| s.equals("1B"))
                    count++;
            }
            String[] TX1 = new String[Data1.length + count];
            String[] RX1 = new String[Data1.length];

            //str1 에 7E 또는 1B 가 있으면 앞에 1B 추가
            int j = 0;
            for (int i = 0; i < Data1.length; i++) {
                if (Data1[i].equals("7E") || Data1[i].equals("1B")) {
                    TX1[j++] = "1B";
                }
                TX1[j++] = Data1[i];
            }

            //TX1 출력
            txOutput.append("=>Tx ");
            for (int i = 0; i < TX1.length; i++) {
                txOutput.append(TX1[i] + " ");
            }
            txOutput.append("\n");

            //TX1의 저장되이있는 배열중 7E 앞에 1B 가 있으면 제거
            int k = 0;
            boolean isPrev1B = false;
            for (String s : TX1) {
                if (!s.equals("1B")) {
                    RX1[k++] = s;
                    isPrev1B = false;
                } else {
                    if (isPrev1B) {
                        RX1[k++] = s;
                        isPrev1B = false;
                    } else {
                        isPrev1B = true;
                    }
                }
            }

            //RX1 출력
            rxOutput.append("=>D ");
            for (int i = 0; i < RX1.length; i++) {
                rxOutput.append(RX1[i] + " ");
            }
            rxOutput.append("\n");
            loopCount++;
        }

        System.out.println( "Transmitter (Sender)");
        System.out.println(txOutput.toString());
        System.out.println("Receiver");
        System.out.println(rxOutput.toString());

        in.close();
    }
}
