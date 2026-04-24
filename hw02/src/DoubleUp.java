public class DoubleUp {
   /**
     * Returns a new string where each character of the given string is repeated twice.
     * Example: doubleUp("hello") -> "hheelllloo"
     */
   public static String doubleUp(String s) {
      int length = s.length();
      String doubledWorld;
      StringBuilder S =new StringBuilder(length *2);
      for (int i = 0; i< length; i++){
         char doubled = s.charAt(i);
         S.append(doubled).append(doubled);
      }
      return S.toString();

   }
   
   public static void main(String[] args) {
      String s = doubleUp("hello");
      System.out.println(s);
      
      System.out.println(doubleUp("cat"));
   }
}