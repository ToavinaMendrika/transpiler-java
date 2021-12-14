package transpiler;

public class TranspilerFactory {
    public static Transpiler getTranspiler(LanguageTranspilerInterface lt, String filename) {
        return new Transpiler(lt, filename);
    }
}