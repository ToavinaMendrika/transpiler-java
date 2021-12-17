import transpiler.Transpiler;
import transpiler.TranspilerFactory;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Transpiler tp;
        try {
            tp = TranspilerFactory.getTranspiler("java", "src/resources/Personne");
            tp.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}