package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(bridgeGame.getBridge());
        String sectionInfo = bridgeGame.getBridge().get(0);
        String[] bridge = bridgeGame.move("U");
        System.out.println(Arrays.toString(bridge));
        if (sectionInfo.equals("U")) Assertions.assertEquals("O", bridge[0]);
        if (sectionInfo.equals("D")) Assertions.assertEquals("X", bridge[0]);
    }

    @Test
    @DisplayName("다리의 모양을 출력한다.")
    void printBridge() {
        List<String> bridgeShape = new ArrayList<>(Arrays.asList("U", "D", "D", "D"));
        BridgeGame bridgeGame1 = new BridgeGame(bridgeShape);
        OutputView outputView = new OutputView(bridgeGame1);
        String[] bridge = {"O", "O", "O", "X"};
        String bridgeState = String.format("[ O |   |   |   ]\n[   | O | O | X ]");
        Assertions.assertEquals(bridgeState, outputView.printMap(bridge));
    }
}
