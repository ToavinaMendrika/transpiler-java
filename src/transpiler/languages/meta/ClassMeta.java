package transpiler.languages.meta;

import java.lang.reflect.*;
import java.util.*;

public class ClassMeta {
    protected String classType;
    protected String className;
    protected String classModifier;
    protected String classPackage;
    protected String classImplement;
    protected String classInherance;
    protected List<PropertyMeta> classProperties = new ArrayList<PropertyMeta>();
    protected List<MethodMeta> classMethods =  new ArrayList<MethodMeta>();


    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassModifier(int mod) {
        this.classModifier = getModifiers(mod);
    }

    public String getClassModifier() {
        return classModifier;
    }

    public void setClassPackage(String classPackage) {
        this.classPackage = classPackage;
    }

    public String getClassPackage() {
        return classPackage;
    }

    public void setClassProperties(Field[] fields) {
        for (Field field : fields) {
            PropertyMeta prop = new PropertyMeta();
            prop.propName = field.getName();
            prop.propModifier = getModifiers(field.getModifiers());
            prop.propType = field.getType().getSimpleName();
            this.classProperties.add(prop);
        }
    }

    public List<PropertyMeta> getClassProperties() {
        return classProperties;
    }

    public void setClassMethods(Method[] methods) {
        for (Method method : methods) {
            MethodMeta met = new MethodMeta();
            met.methodName = method.getName();
            met.methodReturn = method.getReturnType().getSimpleName();
            met.methodModifier =  getModifiers(method.getModifiers());
    

            Parameter[] ps = method.getParameters();
            for (Parameter p : ps) {
                met.methodParams.put(p.getName(), p.getType().getSimpleName());
            }
            this.classMethods.add(met);
        }
    }

    public List<MethodMeta> getClassMethods() {
        return classMethods;
    }

    private String getModifiers(int mod) {
        return Modifier.toString(mod);
    }
}