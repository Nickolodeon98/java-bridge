package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

public class BridgeTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        this.bridgeGame = new BridgeGame(4);
    }

    @Test
    @DisplayName("무작위로 다리를 생성한다.")
    void createBridge() {
        List<String> bridge = bridgeGame.getBridgeMaker().makeBridge(4);

        System.out.println(bridge);
        for (String upOrDown : bridge) {
            Assertions.assertTrue(upOrDown.matches("[U|D]"));
        }
    }

    @Test
    @DisplayName("칸을 이동한 후 이동 성공 여부를 나타낸다.")
    void moveOrFall() {
        boolean isMoveOrFail = bridgeGame.move("U");
        String sectionInfo = bridgeGame.getBridge().get(0);
        if (sectionInfo.equals("U")) Assertions.assertTrue(isMoveOrFail);
        if (sectionInfo.equals("D")) Assertions.assertFalse(isMoveOrFail);

        isMoveOrFail = bridgeGame.move("D");
        sectionInfo = bridgeGame.getBridge().get(1);
        if (sectionInfo.equals("D")) Assertions.assertTrue(isMoveOrFail);
        if (sectionInfo.equals("U")) Assertions.assertFalse(isMoveOrFail);
    }
}
