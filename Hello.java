public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
    if (args != null && args.length > 0) {
      for (int i = 0; i < args.length; i++) {
        System.out.println("args[i]=" + args[i]);
      }
    }
  }
}