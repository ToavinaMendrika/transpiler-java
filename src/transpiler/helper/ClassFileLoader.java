package transpiler.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringJoiner;

/**
 * Load class file
 */
public class ClassFileLoader extends ClassLoader {

    private String fileName;
    
    public Class findClass(String name, String pack) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
       
        StringJoiner sj = new StringJoiner(".");
        sj.add(pack);
        sj.add(fileName);
        
        return defineClass(sj.toString(), b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName)  {
        byte[] data=null;
        
        try{
            File file = new File(fileName+".class");

            this.fileName = file.getName().replace(".class", "");
    
            try (FileInputStream fis = new FileInputStream(file)) {
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                int ch=0;
                while((ch=fis.read())!=-1){
                    baos.write(ch);
                }
                data=baos.toByteArray();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }
}