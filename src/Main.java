import transpiler.Transpiler;
import transpiler.TranspilerFactory;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Transpiler tp;
        try {
            tp = TranspilerFactory.getTranspiler(args[0], args[1], args[2]);
            tp.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}