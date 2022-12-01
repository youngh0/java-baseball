package baseball.domain;

public class BaseballRule {
    private final RandomBaseballNumberGenerator randomBaseballNumberGenerator = new RandomBaseballNumberGenerator();
    private final Referee referee = new Referee();

    public BaseballNumbers createComputerAnswer() {
        return new BaseballNumbers(randomBaseballNumberGenerator.createBaseballNumbers());
    }

    public BaseballResult playOneGame(BaseballNumbers computerAnswer, BaseballNumbers playerAnswer) {
        return referee.judgeBaseballGame(computerAnswer, playerAnswer);
    }
}
