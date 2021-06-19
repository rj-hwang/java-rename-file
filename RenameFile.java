import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;

public class RenameFile {
  public static void main(String[] args) {
    System.out.println("Start Replace FileName...");
    if (args != null && args.length > 0) {
      for (int i = 0; i < args.length; i++) {
        System.out.println("args[" + i + "]=" + args[i]);
      }

      boolean debug = "true".equalsIgnoreCase(args[0]);
      String dir = args[1];
      String type = args[2];
      String from;
      if (args.length > 3) from = args[3];
      else from = "";
      String to;
      if (args.length > 4) to = args[4];
      else to = "";
      System.out.println("debug=" + debug + ", dir=" + dir + ", type=" + type + ", from=" + from + ", to=" + to);

      File[] files_ = new File(dir).listFiles();
      // 过滤文件
      List<File> files = new ArrayList<File>();
      for (int i = 0; i < files_.length; i++) {
        if (files_[i].isFile() && files_[i].getName().endsWith("." + type)) {
          files.add(files_[i]);
        }
      }
      System.out.println("Found " + files.size() + " match files");

      // 更名
      String oldFileName, newFileName, fileType;
      int index;
      File oldFile, newFile;
      boolean result;
      for (int i = 0; i < files.size(); i++) {
        oldFile= files.get(i);
        oldFileName = oldFile.getName();
        newFileName = oldFileName.replace(from, to);
        newFile = new File(oldFile.getParent(), newFileName);
        if (debug) System.out.println("newFile=" + newFile);
        else {
          if (oldFileName.equals(newFileName)) {
            System.out.println("ignore " + i + ": old name is equals to new name");
          } else {
            System.out.println(i + ":");
            System.out.println("  old=" + oldFileName);
            System.out.println("  new=" + newFileName);
            try {
              Files.move(oldFile.toPath(), newFile.toPath());
            } catch (IOException e) {
              System.out.println("  e=" + e.getMessage());
            }
            //result = oldFile.renameTo(newFile);
            //System.out.println("  success=" + result);
          }
        }
      }
    }
    System.out.println("End Replace FileName");
  }
}