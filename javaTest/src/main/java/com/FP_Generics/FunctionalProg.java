package com.FP_Generics;

import java.io.File;
import java.io.FileFilter;

public class FunctionalProg {

  public static void main(String[] args) {
    //Basic Functions

    //prior to java 8
    File[] directories = new File(".").listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    });


    //Java 8
    File[] directories1 = new File(".").listFiles(File::isDirectory);
  }

}
