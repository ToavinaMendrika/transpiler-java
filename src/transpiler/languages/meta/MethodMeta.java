package transpiler.languages.meta;

import java.util.*;

public class MethodMeta {
    public String methodModifier;
    public String methodName;
    public NavigableMap<String, String> methodParams = new TreeMap<String, String>();
    public String methodReturn;
}