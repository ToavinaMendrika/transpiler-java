package transpiler;

/**
 * interface to transpile programing language
 */
public interface LanguageTranspilerInterface {
    
    /**
     * this method setup ClassMeta member
     * @param c setupt class Meta object
     * @return String 
     */
    public String exec(Class c);

    /**
     * this method setup package/namespace each language
     * @return String
     */
    public String setupPackage();

    /**
     * this method setup class declaration
     * @return String
     */
    public String setupClassDeclaration();

    /**
     * this method setup class properties
     * @return String
     */
    public String setupProperties();

    /**
     * this method setup class methods
     * @return String
     */
    public String setupMethods();
    
    /**
     * this method setup class end of line
     * @return String
     */
    public String setupEndOfLine();
}