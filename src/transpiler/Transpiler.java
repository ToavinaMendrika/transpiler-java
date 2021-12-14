package transpiler;

import transpiler.helper.ClassFileLoader;

public class Transpiler {

    LanguageTranspilerInterface transpilerMethod;
    String fileName;

    Transpiler(LanguageTranspilerInterface lt, String f) {
        transpilerMethod = lt;
        fileName = f;
    }

    public String exec() throws ClassNotFoundException {
        ClassFileLoader cfl = new ClassFileLoader();

        return transpilerMethod.exec(cfl.findClass(fileName));
    }

    public Transpiler setMethod(LanguageTranspilerInterface method) {
        this.transpilerMethod = method;
        return this;
    }
}