import transpiler.Transpiler;
import transpiler.TranspilerFactory;
import transpiler.languages.JavaTranspiler;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        JavaTranspiler lt = new JavaTranspiler();
        Transpiler tp = TranspilerFactory.getTranspiler(lt, "src/resources/Transpiler");
        tp.exec();
    }
}