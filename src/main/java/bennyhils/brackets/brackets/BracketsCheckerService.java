package bennyhils.brackets.brackets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BracketsCheckerService {
    public boolean checkBrackets(String input) {
        //Проверка на пустой текст
        if (input == null || input.length() == 0) {
            log.warn("Нет текста!");
            return false;
        }

        /*

        Логика основного алгоритма проверки

        В i считаем скобки так, что
        Открытая + 1
        Закрытая - 1

        Не должно никогда быть -1 - значит начинается с закрытой скобки, которую уже не открыть
        При обходе строки должно быть 0 - значит все скобки закрыты

        */

        char lastOpen = 0;

        int i = 0;

        //Проверяем все скобки, которые конфигурируются в Enum
        for (BracketsForCheckTypes b : BracketsForCheckTypes.values()) {
            //Проверка на пустые скобки
            //После открывающейся скобки обязательно буква, а не пробел, иначе скобка считается пустой
            if (input.contains(String.valueOf(b.getStart()) + " ") ||
                input.contains(String.valueOf(b.getStart()) + String.valueOf(b.getEnd()))) {
                log.warn("Пустые скобки: {}", String.valueOf(b.getStart()) + String.valueOf(b.getEnd()));
                return false;
            }

            for (char c : input.toCharArray()) {
                if (c == b.getEnd()) {
                    if (i > 0 && lastOpen != b.getStart()) {
                        log.error("Закрывается не той скобкой, которой открылось");
                        return false;
                    }
                    i--;
                }
                if (i < 0) {
                    log.warn("Начинается с закрытой скобки {}", String.valueOf(b.getEnd()));
                    return false;
                }
                if (c == b.getStart()) {
                    i++;
                    lastOpen = b.getStart();
                }
            }
        }
        if (i == 0) {
            log.info("Успешная проверка скобок всех типов");
            return true;
        } else {
            log.warn("Есть незакрытые скобки");
            return false;
        }
    }
}
