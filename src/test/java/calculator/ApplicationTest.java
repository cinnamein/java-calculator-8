package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }

    // 자연수만 입력할 경우
    @Test
    void 자연수_테스트() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    // 비정수 실수만 입력할 경우
    @Test
    void 비정수실수_테스트() {
        assertSimpleTest(() -> {
            run("0.1");
            assertThat(output()).contains("결과 : 0.1");
        });
    }

    // 양수와 기본 구분자 조합으로 구성된 경우
    @Test
    void 양수_기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 양수와 커스텀 구분자의 조합으로 구성된 경우
    @Test
    void 양수_커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    // 양수와 기본, 커스텀 구분자의 조합으로 구성된 경우
    @Test
    void 양수_구분자_혼용_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:0.4");
            assertThat(output()).contains("결과 : 6.4");
        });
    }

    // 입력 문자열이 null인 경우
    @Test
    void null_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 입력 문자열이 공백(whitespace)인 경우
    @Test
    void 공백_테스트() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("-1,2,3"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @ParameterizedTest
    @ValueSource(strings = {
            // 음수 혹은 0이 제공된 경우
            "1,-2,3", "0,1,2", "0.0,1.5",
            // 소수점 양식에 오류가 있는 경우
            "1..5,2", "3,4,5.",
            // 숫자 혹은 구분자가 아닌 문자가 포함된 경우
            "1,a,3", "4+5",
            // 구분자가 연속으로 나와 숫자가 비어있는 부분이 있는 경우
            "1,,2,3", "1::2:3", "//;\\n1;;2;3",
            // 문자열이 구분자로 시작하거나 끝나는 경우
            ",1,2,3", "1,2,3,", ":1:2", "1:2:", "//;\\n;1;2", "//;\\n1;2;",
            // 허용되지 않은 문자를 커스텀 문자로 지정하는 경우
            "//.\n", "//1\n", "// \n", "//\n"
    })
    void 예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
