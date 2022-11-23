package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private String[] feasibility;
    private int pointer;
    private int counter;

    public BridgeGame(int size) {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
        this.feasibility = new String[size];
        this.pointer = 0;
        this.counter = 1;
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.pointer = 4;
    }

    public BridgeMaker getBridgeMaker() {
        return bridgeMaker;
    }

    public List<String> getBridge() {
        return bridge;
    }


    public int getPointer() {
        return pointer;
    }

    public String[] getFeasibility() {
        return feasibility;
    }

    public int getCounter() {
        return counter;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        if (pointer == bridge.size()) throw new IllegalArgumentException(); // 끝에 도달했으면 예외로 처리한다.
        String currentStep = bridge.get(pointer);
        if (currentStep.equals(direction)) { // 만약에 이동한 칸이 U 인데 U 로 이동한 것이었다면 O 를 저장한다.
            feasibility[pointer++] = "O";
            return true;
        }
        feasibility[pointer++] = "X";
        return false;
        //        return bridge.get(pointer++).equals(direction); // 이동할 수 있는 곳으로 갔으면 true, 아니면 false 를 반환한다.
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        counter++;
        pointer = 0;
    }


}
