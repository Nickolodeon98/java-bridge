package bridge.controller;

import bridge.service.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class Application {
    private final InputView inputView;
    private final int bridgeSize;
    private final BridgeGame bridgeGame;
    private final OutputView outputView;

    public Application() {
        this.inputView = new InputView();
        this.bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize);
        this.outputView = new OutputView(bridgeGame);
    }

    public void run() {
        boolean quit = false;
        while(!quit) {
            String command = inputView.readMoving();
            boolean gameState = bridgeGame.move(command);
            System.out.println(outputView.printMap(bridgeGame.getFeasibility()));
            quit = checkCondition(gameState);
            if (!quit) quit = passCondition();
        }
    }

    private boolean checkCondition(boolean gameState) {
        if (!gameState) {
            String retryOrQuit = inputView.readGameCommand();
            return outputView.printEndingOptions(false, retryOrQuit);
        }
        return false;
    }

    private boolean passCondition() {
        if (bridgeGame.getPointer() == bridgeSize) {
            outputView.printResult(bridgeGame.getFeasibility(), true, bridgeGame.getCounter());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();
    }
}
