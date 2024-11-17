package annotation.java;

public class OverrideMain {

    static class A{
        public void call() {
            System.out.println("A.call");
        }
    }

    static class B extends A{

//        @Override // 주석 풀면 오류
        public void callll() {
            System.out.println("B.cal");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.call();
    }
}
