package baseball;

import baseball.service.GameSettingService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final static int PLAYER_ANSWER_CORRECT_SIZE = 3;
    private final static String PLAYER_ANSWER_REGEX = "^[1-9]*$";
    private GameSettingService gameSettingService;

    public GameController() {
        gameSettingService = new GameSettingService();
    }

    public void startGame() {
        boolean replayGame = true;
        while(replayGame){
            List<Integer> computerAnswer = gameSettingService.generateRandomThreeNumbers();
            playGame(computerAnswer);
            replayGame = askReplayBaseball();
        }
    }

    private void playGame(List<Integer> computerAnswer) {
        List<Integer> baseballResult;
        boolean correctAnswer = false;
        while (!correctAnswer) {
            String playerInput = Console.readLine();
            List<Integer> playerInputAnswer = inputAnswer(playerInput);
            baseballResult = judgeBaseballResult(computerAnswer, playerInputAnswer);
            showResult(baseballResult.get(0), baseballResult.get(1));
            correctAnswer = isThreeStrike(baseballResult.get(0));
        }
    }

    private List<Integer> inputAnswer(String inputAnswer) {
        validatePlayerInput(inputAnswer);
        List<Integer> inputToIntegers = convertStringToIntegerList(inputAnswer);
        validateIsNonDuplicateNums(inputToIntegers);
        return inputToIntegers;
    }

    public void validatePlayerInput(String inputNumbers) {
        validateThreeLength(inputNumbers);
        validateSatisfiedRange(inputNumbers);
    }

    private List<Integer> convertStringToIntegerList(String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }

    private static void validateThreeLength(String inputNumbers) {
        if (inputNumbers.length() != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSatisfiedRange(String inputNumbers) {
        if (!inputNumbers.matches(PLAYER_ANSWER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsNonDuplicateNums(List<Integer> input) {
        long individualNumberCount = input.stream()
                .distinct()
                .count();
        if (individualNumberCount != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> judgeBaseballResult(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        List<Integer> result = new ArrayList<>(List.of(0, 0));
        for (int num = 0; num < 3; num++) {
            if (computerAnswer.get(num).equals(playerAnswer.get(num))) {
                result.set(0, result.get(0)+1);
                continue;
            }
            if (computerAnswer.contains(playerAnswer.get(num))) {
                result.set(1, result.get(1)+1);
            }
        }
        return result;
    }

    public boolean isThreeStrike(int strikeCount) {
        final String finishGame = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        final int MAX_STRIKE_COUNT = 3;
        if (strikeCount == MAX_STRIKE_COUNT) {
            System.out.println(finishGame);
            return true;
        }
        return false;
    }

    public void showResult(int strikeCount, int ballCount) {
        StringBuilder resultString = new StringBuilder();
        if (ballCount > 0) {
            resultString.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            resultString.append(strikeCount).append("스트라이크");
        }
        if (ballCount + strikeCount == 0) {
            resultString.append("낫싱");
        }
        System.out.println(resultString);
    }

    private boolean askReplayBaseball() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerReplayInput = Console.readLine();
        validateReplayInputValidation(playerReplayInput);
        return playerReplayInput.equals("1");
    }

    private void validateReplayInputValidation(String replayInput) {
        if (!(replayInput.equals("1") || replayInput.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }


}
