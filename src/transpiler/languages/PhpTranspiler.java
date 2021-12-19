package transpiler.languages;

import java.util.*;
import java.util.Map.Entry;

import transpiler.LanguageTranspilerInterface;
import transpiler.languages.meta.ClassMeta;
import transpiler.languages.meta.MethodMeta;
import transpiler.languages.meta.PropertyMeta;

/**
 * Php language transpiler
 */
public class PhpTranspiler implements LanguageTranspilerInterface {

    private ClassMeta classMeta;

    public PhpTranspiler() {
        classMeta = new ClassMeta();
    }

    @Override
    public String exec(Class c) {
        if (c.getPackage() != null) {
            classMeta.setClassPackage(c.getPackage().toString());
        }
        String type = c.isInterface() ? "interface" : "class";
        classMeta.setClassType(type);
        classMeta.setClassName(c.getSimpleName());
        classMeta.setClassModifier(c.getModifiers());
        classMeta.setClassProperties(c.getDeclaredFields());
        classMeta.setClassMethods(c.getDeclaredMethods());
        classMeta.setClassImplements(c.getInterfaces());

        System.out.println(
            setupPackage() + 
            setupClassDeclaration() +
            setupProperties() + 
            setupMethods() + 
            setupEndOfLine()
        );

        return null;
    }

    public String setupPackage() {
        if (classMeta.getClassPackage() == null) {
            return "";
        }
        return classMeta.getClassPackage().replace("package", "namespace") + ";\n";
    }

    public String setupClassDeclaration() {
        if (classMeta.getClassType() == "class") {
            StringJoiner cl = new StringJoiner("");
            cl.add(classMeta.getClassModifier() + " " + classMeta.getClassType() + " " + classMeta.getClassName());
            if (classMeta.getClassImplements().size() > 0 ) {
                cl.add(" implements " + classMeta.getClassImplements().get(0));
            } 
            if (classMeta.getClassImplements().size() > 1 ) {
                for (String impl : classMeta.getClassImplements()) {
                    cl.add(", " + impl);
                }
            }
            cl.add(" {\n");
            return cl.toString();
        } else {
            return "public interface " + classMeta.getClassName() + " {\n";
        }
        
    }

    public String setupProperties() {
        StringJoiner properties = new StringJoiner("");
        List<PropertyMeta> props = classMeta.getClassProperties();
        for (int i = 0; i < props.size(); i++) {
            PropertyMeta prop = props.get(i);
            properties.add(prop.propModifier + " $" + prop.propName);
            if (prop.propValue != null) {
                properties.add(" = " + prop.propValue + ";\n");
            } else {
                properties.add(";\n");
            }
        }
        return properties.toString();
    }

    public String setupMethods() {
        StringJoiner methods = new StringJoiner("");
        List<MethodMeta> meths = classMeta.getClassMethods();
        for (int i = 0; i < meths.size(); i++) {
            MethodMeta meth = meths.get(i);
            methods.add(meth.methodModifier + " " + meth.methodName + "(");
            for (Entry<String, String> methodParam : meth.methodParams.entrySet()) {
                methods.add("$" + methodParam.getKey() );
                if ( meth.methodParams.higherEntry(methodParam.getKey()) != null) {
                    methods.add(", ");
                }
            }
            methods.add(") { } \n");
        }
        return methods.toString();
    }

    public String setupEndOfLine() {
        return "}\n";
    }
    
}