package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

public class BridgeTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("무작위로 다리를 생성한다.")
    void createBridge() {
        List<String> bridge = bridgeMaker.makeBridge(4);

        System.out.println(bridge);
        for (String upOrDown : bridge) {
            Assertions.assertTrue(upOrDown.matches("[U|D]"));
        }

    }
}
