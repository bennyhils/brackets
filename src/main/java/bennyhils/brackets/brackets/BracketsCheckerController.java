package bennyhils.brackets.brackets;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BracketsCheckerController {

    final BracketsCheckerService bracketsCheckerService;

    public BracketsCheckerController(BracketsCheckerService bracketsCheckerService) {
        this.bracketsCheckerService = bracketsCheckerService;
    }

    @PostMapping(value = "/api/checkBrackets")
    public String check(@RequestBody @Nullable String request) {
        if (request == null || request.length() == 0) {
            log.warn("Пустое тело запроса при обращении к сервису проверки скобок");
            return "{\"isCorrect\" : " + false + "}";
        }
        String text;
        try {
            text = new JSONObject(request).getString("text");
        } catch (final JSONException e) {
            log.warn("Неправильное тело запроса при обращении к сервису проверки скобок");
            return "{\"isCorrect\" : " + false + "}";
        }

        boolean result = bracketsCheckerService.checkBrackets(text);
        return "{\"isCorrect\" : " + result + "}";
    }
}
