package lpnt.cg.exception;

public class Main {
    public static void main(String[] args) {
        try {
            int data = 100/0;
        } catch (ArithmeticException e) {
            System.out.println(e);

        }
    }
}
