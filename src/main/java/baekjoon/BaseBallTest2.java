public class BaseBallTest2 {
    private String a;

    private void generateTarget() {
        a = "5";
    }

    public void test2() {
        generateTarget();
        System.out.println(a.equals("5"));
    }
}
