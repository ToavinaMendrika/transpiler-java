package transpiler;

import transpiler.languages.JavaTranspiler;
import transpiler.languages.PhpTranspiler;

public class TranspilerFactory {

    static LanguageTranspilerInterface languageTranspiler;

    public static Transpiler getTranspiler(String lt, String filename) throws Exception {
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
        return new Transpiler(languageTranspiler, filename);
    }
}