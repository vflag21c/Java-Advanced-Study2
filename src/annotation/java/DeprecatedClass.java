package annotation.java;

public class DeprecatedClass {

    public void call1() {
        System.out.println("DeprecatedClass.call1");
    }

    @Deprecated
    public void call2() {
        System.out.println("DeprecatedClass.call2");
    }

    @Deprecated(since = "2.4", forRemoval = true) // 코드가 제거 될 예정이다.
    public void call3() {
        System.out.println("DeprecatedClass.call3");
    }
}
