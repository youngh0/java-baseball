package baseball.view;

public class OutputView {
    private static OutputView outputView = new OutputView();
    private OutputView(){

    }

    public static OutputView getOutViewInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printGameResult(StringBuffer gameResult) {
        System.out.println(gameResult);
    }
}
