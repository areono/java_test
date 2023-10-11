import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class toic {
    private JFrame frame;
    private JTextField textField;
    private JLabel lblQuestion;

    // 단어 목록
    String[][] words = {{"사과", "apple"}, {"바나나", "banana"}, {"참외", "melon"}, /* 추가적인 단어들 */};

    Random random = new Random();

    // 랜덤으로 선택된 단어와 정답
    int currentWordIndex = -1;
    String currentAnswer = "";

    int score = 0;  // 정답 개수를 저장하는 변수
    int totalQuestions = 0;  // 총 문제 개수를 저장하는 변수

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    toic window = new toic();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public toic() {
        initialize();
        nextWord();  // 첫 번째 문제를 출력합니다.
    }

    // 다음 문제를 출력하는 함수입니다.
    private void nextWord() {
        if (totalQuestions == words.length) {  // 모든 문제를 다 푼 경우
            JOptionPane.showMessageDialog(frame, "테스트가 종료되었습니다.\n점수: " + score + "/" + totalQuestions);
            System.exit(0);
        }

        totalQuestions++;

        currentWordIndex++;
        if (currentWordIndex >= words.length) {  // 모든 단어를 다 사용한 경우, 배열을 재섞습니다.
            shuffleWordsArray();
            currentWordIndex = 0;
        }

        boolean isEnglishQuestion = random.nextBoolean();

        if (isEnglishQuestion) {  // 영문 문제인 경우
            lblQuestion.setText(words[currentWordIndex][1]);
            currentAnswer = words[currentWordIndex][0];
        } else {  // 한글 문제인 경우
            lblQuestion.setText(words[currentWordIndex][0]);
            currentAnswer = words[currentWordIndex][1];
        }
    }

    private void shuffleWordsArray() {
        for (int i = words.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String[] temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }
    }

    private void checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(currentAnswer)) {   // 대소문자 구분 없이 정답과 비교합니다.
            score++;
            JOptionPane.showMessageDialog(frame, "정답입니다!");
        } else {
            JOptionPane.showMessageDialog(frame, "오답입니다. 다시 시도하세요.");
        }

        textField.setText("");   // 입력 필드 초기화

        nextWord();   // 다음 문제로 넘어갑니다.
    }

    private void initialize() {

        frame= new JFrame("토익 VOCA 테스트");
        frame.setBounds(100,100,450,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblQuestion= new JLabel("");
        lblQuestion.setFont(new Font("NanumGothic", Font.PLAIN,16));
        lblQuestion.setBounds(12,10,410,50);
        frame.getContentPane().add(lblQuestion);

        textField= new JTextField();
        textField.setBounds(12 ,70 ,116 ,21 );
        frame.getContentPane().add(textField );

        JButton btnCheck= new JButton("확인");
        btnCheck.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent argO){
                checkAnswer(textField.getText());
            }
        });

        btnCheck.setBounds(140 ,70 ,80 ,21 );
        frame.getContentPane().add(btnCheck);
        frame.getRootPane().setDefaultButton(btnCheck);

    }


}
