package csw.java.python;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloPython {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Process proc;
    try {
      proc = Runtime.getRuntime().exec("python E:\\Pyworkspace\\python\\lect04\\test1.py");// 执行py文件
      //用输入输出流来截取结果
      BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
      String line = null;
      while ((line = in.readLine()) != null) {
        System.out.println(line);
      }
      in.close();
      proc.waitFor();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}