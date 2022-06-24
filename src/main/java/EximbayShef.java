public class EximbayChef {

    private final String name;

    public EximbayChef(String menu) {
        this.name = String.format("%s 요리사", EximbayMenu.getCookType(menu));
    }

    public void order(String menu) {
        System.out.printf("%s는 %s 주문을 받았습니다.\n", name, menu);
    }

    public void cook(String menu) {
        System.out.printf("%s는 %s를 만들었습니다.\n", name, menu);
    }
}
