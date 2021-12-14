package transpiler.languages.meta;

import java.util.List;
import java.util.Map;

public abstract class ClassMeta {
    private String className;
    private String classVisibility;
    private String classPackage;
    private String classImplement;
    private String classInherance;
    private Map<String, String> classProprieties;
    private List<MethodMeta> classmethods;

}