package bennyhils.brackets.brackets;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
class BracketsCheckerApplicationTests {

    final BracketsCheckerService bracketsCheckerService = new BracketsCheckerService();

    @Test
    void bracketsCheckerOKTests() {
        log.info("Проверка успешного кейса");
        Assert.isTrue(
                bracketsCheckerService.checkBrackets("{Рандомный} [текст] с (правильными) скобками"),
                "Успешный кейс ПРОВАЛЕН!"
        );
        log.info("Успешный кейс пройден успешно");
    }

    @Test
    void bracketsCheckerEmptyTests() {
        log.info("Проверка пустых скобок");
        for (BracketsForCheckTypes b : BracketsForCheckTypes.values()) {
            Assert.isTrue(
                    !bracketsCheckerService.checkBrackets("Пустые скобки "
                                                          + String.valueOf(b.getStart()) + String.valueOf(b.getEnd())),
                    "Проверка пустых скобок ПРОВАЛЕНА!"
            );
        }
        log.info("Успешная проверка пустых скобок");
    }

    @Test
    void bracketsCheckerNoOpenTests() {
        log.info("Проверка неоткрытой скобки");
        Assert.isTrue(
                !bracketsCheckerService.checkBrackets("Текст с ) открытой скобкой"),
                "Проверка незакрытой скобки ПРОВАЛЕНА!"
        );
        log.info("Успешная проверка с неоткрытой скобкой");
    }

    @Test
    void bracketsCheckerNoClosedTests() {
        log.info("Проверка незакрытой скобки");
        Assert.isTrue(
                !bracketsCheckerService.checkBrackets("Текст с (незакрытой скобкой"),
                "Проверка открытой скобки ПРОВАЛЕНА!"
        );
        log.info("Успешная проверка с открытой скобкой");
    }

    @Test
    void bracketsCheckerEmptyTextTests() {
        log.info("Проверка пустого текста");
        Assert.isTrue(
                !bracketsCheckerService.checkBrackets(""),
                "Проверка пустого текста ПРОВАЛЕНА!"
        );
        log.info("Успешная проверка пустого скобкой");
    }
}
