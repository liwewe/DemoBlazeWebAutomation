package utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static final ThreadLocal<Map<String, Object>> scenarioData = ThreadLocal.withInitial(HashMap::new);

    public static void set(String key, Object value) {
        scenarioData.get().put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) scenarioData.get().get(key);
    }

    public static void clear() {
        scenarioData.get().clear();
    }
}
