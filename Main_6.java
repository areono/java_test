import java.util.*;

class TextProcess {
    private String text;
    private String key;
    public TextProcess(String input) {
        String [] splitText = input.split("/");
        this.text = splitText[0].trim();
        this.key = splitText[1].trim();



    }  // 객체 생성 시, 입력받은 텍스트를 기반으로 생성자 함수 수행

    public int getTextLength(String input) {

        return text.length();
    }  // 입력받은 텍스트의 전체 길이를 정수로 반환

    public int getWordCount(String input) {
        int Wcount = 0;
        String  reText = text.replaceAll("\\s+"," ");
        String[] words = reText.split(" ");
        Wcount = words.length;
        return Wcount;
    }  // 입력받은 텍스트의 단어 수를 정수로 반환

    public int getAlphabetCount(String input) {
        int Acount = 0;
        String Aptext = text.replace(" ","");
        for(int i=0;i<Aptext.length();i++){
            char c = Aptext.charAt(i);
            if(Character.isAlphabetic(c)){
                Acount++;
            }
        }
        return Acount;
    }  // 입력받은 텍스트의 문자(A~Z) 수를 정수로 반환

    public int getNumCount(String input) {
        int Ncount = 0;
        String NumText = text.replace(" ","");
        for(int i=0;i<NumText.length();i++){
            char c = NumText.charAt(i);
            if(Character.isDigit(c)){
                Ncount++;
            }
        }
        return Ncount;
    }  // 입력받은 텍스트의 숫자(0~9) 수를 정수로 반환


    public int getSpeChrCount(String input) {
        int Scount = 0;
        String SpeText = text.replace(" ","");
        for(int i=0;i<SpeText.length();i++){
            char c = SpeText.charAt(i);
            if(!Character.isDigit(c) && !Character.isAlphabetic(c)){
                Scount++;
            }
        }
        return Scount;
    }  // 입력받은 텍스트의 특수기호 수를 정수로 반환

    public boolean checkText() {
        String keyword = this.key;  // 찾고자 하는 키워드
        // 입력 텍스트가 keyword를 포함하고 있으면 true를 반환, 그렇지 않으면 false를 반환
        return this.text.toLowerCase().contains(keyword.toLowerCase());
    } //입력받은 텍스트에서 찾고자 하는 키워드가 있는지 여부를 반환

    @Override
    public String toString() {

        return "Text: " + this.text.toUpperCase() +
        "\nText Length: " + this.getTextLength(this.text) +
        "\nWord Count: " + this.getWordCount(this.text) +
        "\nAlphabet Count: " + this.getAlphabetCount(this.text) +
        "\nNumber Count: " + this.getNumCount(this.text) +
        "\nSpecial Character Count: " + this.getSpeChrCount(this.text) + "\n"+
        (checkText() ? "Thers is the keyword in the input text.\n":"Thers is no keyword in the input text.\n") ;
    } // TextProcess 객체를 출력(println)하였을 때, 문제에서 요구하는 양식대로 출력하도록 toString() 함수를 overriding
}

public class Main {  // 메인 클래스

    public static void main(String[] args){  // 메인 함수
        Scanner s = new Scanner(System.in);  // 텍스트를 입력받기 위한 Scanner 객체 생성

        while(true) {  // 텍스트를 연속으로 입력받기 위한 while loop
            //System.out.print("Input Msg: ");

            String text = s.nextLine();// 문제에서 요구하는 형태로 입력 문구 및 입력받은 텍스트 출력
            text = text.trim();// 입력받은 텍스트의 불필요한 양쪽 공백 제거

            System.out.println("Input Msg: " + text);

            if(text.equals("exit"))
                break;
            // exit가 입력되었을 때, 무한 루프 종료
            TextProcess str = new TextProcess(text);
            // TextProcess 객체 생성

            System.out.println(str); // TextProcess 객체 정보 출력
        }
        s.close();// Scanner 객체 종료
        System.out.println("Good bye!");// 종료메세지 출력
    }
}