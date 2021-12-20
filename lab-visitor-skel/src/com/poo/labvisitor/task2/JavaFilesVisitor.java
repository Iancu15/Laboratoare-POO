package com.poo.labvisitor.task2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles;

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }
    
    public JavaFilesVisitor() {
        this.javaFiles = new ArrayList<Path>();
    }

    // TODO - override the visitFile(Path file, BasicFileAttributes attr) method of the SimpleFileVisitor
    // add to javaFiles all the Java related files: the ones with .java and .class extensions
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".class") || file.toString().endsWith(".java"))
            this.javaFiles.add(file);
        
        return CONTINUE;
    }

    public static void main(String[] args) throws IOException {

        Path startingDir = Paths.get(".");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();
        Files.walkFileTree(startingDir, filesVisitor);
        ArrayList<Path> javaFiles = filesVisitor.getJavaFiles();
        for (Path javaFile : javaFiles) {
            System.out.println(javaFile.getParent() + "/" + javaFile.getFileName());
            System.out.println("Name elements number: " + javaFile.getNameCount());
        }

        // TODO
        // use Files.walkFileTree
        // obtain the list of files and print some info about them (e.g. size and path)
    }
}
