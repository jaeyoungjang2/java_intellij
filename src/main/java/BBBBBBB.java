import java.util.Optional;

public class BBBBBBB {

    public static void main(String[] args) {
        test().orElseThrow(
            () -> new IllegalArgumentException("여기서 출력")
        );
    }

    private static Optional<Integer> test() {
        int test = 1;
        if (test == 1) {
            throw new IllegalArgumentException("에러 발생");
        }
        return Optional.ofNullable(2);
    }
}
