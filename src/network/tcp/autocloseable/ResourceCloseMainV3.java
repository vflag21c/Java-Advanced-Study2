package network.tcp.autocloseable;

public class ResourceCloseMainV3 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CloseException, CallException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;
        try {
            resource1 = new ResourceV1("resource1"); // EX
            resource2 = new ResourceV1("resource1");

            resource1.call();
            resource2.callEx(); // CallException
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            if (resource2 != null) {
                try {
                    resource2.closeEx();
                } catch (CloseException e) {
                    // close()에서 발생한 예외는 버린다. 필요하면 로깅 정도
                    System.out.println("close ex: " + e);
                }
            }
            if (resource1 != null) {
                try {
                    resource1.closeEx(); // 이 코드 호출 안됨!
                } catch (CloseException e) {
                    System.out.println("close ex: " + e);
                }
            }
        }

        System.out.println("자원 정리"); // 호출안됨
        resource2.closeEx();
        resource1.close();
    }
}
