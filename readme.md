# java and php class transpiler

this project allow to transple .class file into java or php class language

## How to use

```bash
    
    java -cp target/classes Main [language: php|java] [path to class file] [classfile namespace]
    #exemple
    java -cp target/classes Main php src/resources/Personne entity
```

## How to setup project

```bash
    
    git clone https://github.com/ToavinaMendrika/transpiler-java.git

    #to compile
    make compile
    #or
    javac -d target/classes @sources.txt 

    #to run
    java -cp target/classes Main php src/resources/Personne entity
```