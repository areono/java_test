interface caseType{
    public int Timeout = 100;
}//인터페이스 타입의 레퍼런스 변수 선언 가능
class book implements caseType{
    public static void main(String[] args) {
        System.out.println(caseType.Timeout);
    }
}