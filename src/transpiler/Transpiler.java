package transpiler;

import transpiler.helper.ClassFileLoader;

public class Transpiler {

    private LanguageTranspilerInterface transpilerMethod;
    private String fileName;
    private String pack;

    Transpiler(LanguageTranspilerInterface lt, String f, String p) {
        transpilerMethod = lt;
        fileName = f;
        pack = p;
    }

    public String exec() throws ClassNotFoundException {
        ClassFileLoader cfl = new ClassFileLoader();

        return transpilerMethod.exec(cfl.findClass(fileName, pack));
    }

    public Transpiler setMethod(LanguageTranspilerInterface method) {
        this.transpilerMethod = method;
        return this;
    }
}