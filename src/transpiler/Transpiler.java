package transpiler;

import transpiler.helper.ClassFileLoader;

/**
 * Main class setup transpilerMethod, filename, package
 * read class file
 */
public class Transpiler {

    private LanguageTranspilerInterface transpilerMethod;
    private String fileName;
    private String pack;

    Transpiler(LanguageTranspilerInterface lt, String f, String p) {
        transpilerMethod = lt;
        fileName = f;
        pack = p;
    }

    /**
     * read class files
     * @return String
     * @throws ClassNotFoundException
     */
    public String exec() throws ClassNotFoundException {
        ClassFileLoader cfl = new ClassFileLoader();

        return transpilerMethod.exec(cfl.findClass(fileName, pack));
    }

    /**
     * Setup used language tranpiler
     * @param method
     * @return
     */
    public Transpiler setMethod(LanguageTranspilerInterface method) {
        this.transpilerMethod = method;
        return this;
    }
}