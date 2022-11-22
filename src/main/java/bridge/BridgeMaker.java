package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */


    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        String[] pathOptions = {"D", "U"};
        for (int i = 0; i < size; i++) {
            int rndNum = bridgeNumberGenerator.generate(); // size, 즉 다리의 길이만큼 무작위 번호가 필요하다.
            bridge.add(pathOptions[rndNum]);
        }
        return bridge;
    }
}

/*
 * [U110, D001] ???
 * 정보를 어떻게 저장할까?
 * 힌트: U와 D 를 사용한다.
 * U를 사용할 때 - 윗 부분을 나타낼 때
 * D를 사용할 때 - 아랫 부분을 나타낼 때
 * 예) 다리의 길이: 4 -> 윗 부분 4 아랫 부분 4
 * 리스트 내에서는 자료들이 선형적으로 저장된다.
 * [위, 위, 위, 위, 아래, 아래, 아래, 아래] -> 이렇게?
 * [위, 아래, 위, 아래, 위, 아래, 위, 아래] -> 이렇게?
 * 짝수 번째는 위를 나타낸다.
 * 아니면 1이 나오면 U, 0이 나오면 D 을 저장해서
 * 위가 갈 수 있는 길이면 U 만 놓고 아래가 갈 수 있는 길이면 D 만 놓으면 된다.
 * 이후 하나하나 돌면서 U / D 가 일치하면 O, 불일치하면 X 를 출력하면 된다.
 * 즉, [U, D, U, D] -> 이 말은 위 아래 위 아래 순으로 가능한 길이라는 것이고,
 * [U, U, U, U] -> 이 말은 위 위 위 위 순으로 가능한 길이라는 것이다.
 *
 */
