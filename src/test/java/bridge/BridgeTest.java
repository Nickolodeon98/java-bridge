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
    OutputView outputView;
    String[] bridge;
    @BeforeEach
    void setUp() {
        this.bridgeGame = new BridgeGame(4);
        List<String> bridgeShape = new ArrayList<>(Arrays.asList("U", "D", "D", "D"));
        BridgeGame bridgeGame1 = new BridgeGame(bridgeShape);
        this.outputView = new OutputView(bridgeGame1);
        this.bridge = new String[]{"O", "O", "O", "X"};
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
        boolean moveOrFall = bridgeGame.move("U");
        System.out.println(Arrays.toString(bridgeGame.getFeasibility()));
        if (sectionInfo.equals("U")) Assertions.assertEquals("O", bridgeGame.getFeasibility()[0]);
        if (sectionInfo.equals("D")) Assertions.assertEquals("X", bridgeGame.getFeasibility()[0]);
    }

    @Test
    @DisplayName("다리의 모양을 출력한다.")
    void printBridge() {
        String bridgeState = String.format("[ O |   |   |   ]\n[   | O | O | X ]");
        Assertions.assertEquals(bridgeState, outputView.printMap(bridge));
    }

    @Test
    @DisplayName("최종 게임 결과를 출력한다.")
    void printTheEnd() {
        String expectedEnd = String.format("최종 게임 결과\n" +
                "[ O |   |   |   ]\n[   | O | O | X ]" +
                "\n\n" +
                "게임 성공 여부: 실패\n" +
                "총 시도한 횟수: 1\n");
        String actualEnd = outputView.printResult(bridge, false, 1);
        System.out.println(actualEnd);
        Assertions.assertEquals(expectedEnd, actualEnd);
    }
}
