package transpiler;

import transpiler.languages.JavaTranspiler;
import transpiler.languages.PhpTranspiler;

public class TranspilerFactory {

    static LanguageTranspilerInterface languageTranspiler;

    /**
     * Transpiler class factory
     * @param String lt Language translator
     * @param String filename sources
     * @param String pack class package
     */
    public static Transpiler getTranspiler(String lt, String filename, String pack) throws Exception {
        switch (lt) {
            case "php":
                languageTranspiler = new PhpTranspiler();
                break;
            case "java":
                languageTranspiler = new JavaTranspiler();
                break;
            default:
                throw new Exception("LanguageTranspiler not found");
        }
        return new Transpiler(languageTranspiler, filename, pack);
    }
}