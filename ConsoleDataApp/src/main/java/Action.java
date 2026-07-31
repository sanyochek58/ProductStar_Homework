import java.util.Objects;
import java.util.stream.Stream;

/**
 *  Представляет собой вариант, выбранный пользователем
 */

public enum Action {
    EXIT(0, false),
    CREATE(1, true),
    UPDATE(2, true),
    DELETE(3, true),
    STATISTICS_BY_COURSES(4, false),
    SEARCH(5, true),
    STATISTICS_BY_CITY(6, false),
    ERROR(-1, false);

    private Integer code;

    private Boolean requireAdditionalData;

    Action(Integer code, Boolean requireAdditionalData) {
        this.code = code;
        this.requireAdditionalData = requireAdditionalData;
    }

    public Integer getCode() {
        return code;
    }

    public Boolean isRequireAdditionalData() {
        return requireAdditionalData;
    }

    public static Action fromCode(Integer code) {
        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный код действия " + code);
                    return Action.ERROR;
                });
    }
}
