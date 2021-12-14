package transpiler.languages;

import transpiler.LanguageTranspilerInterface;

public class JavaTranspiler implements LanguageTranspilerInterface {

    @Override
    public String exec(Class c) {
        System.out.println(c.getModifiers());
        return null;
    }
    
}