package perfius;

import java.util.ArrayList;
import java.util.List;

/**
 * Assumption:
 *
 * All Characters are in small letter only, in dictionary/ input/ output
 */
public class WordChain {

  private Dictionary dictionary;

  public static void main(String[] args) {
    String sword = args[0];
    String eword = args[1];

    Dictionary dictionary = Dictionary.getInstance();

    List<String> result = new WordChain(dictionary).printChain(sword,eword);
    System.out.println(result);
  }

  public WordChain(Dictionary dictionary){
    this.dictionary = dictionary;
  }

  public List<String> printChain(String sword, String eword){
    if(sword.length()!=eword.length()){
      throw new IllegalArgumentException("Length is not same");
    }
    if(dictionary == null){
      throw new IllegalArgumentException("Dictionary is not instantiated");
    }

    dictionary.validate();
    List<String> result = new ArrayList<>();
    if(this.printChain(sword,eword,result)){
      return result;
    }
    throw new ResultNotFoundException("Result in not available");
  }

  private boolean printChain(String sword, String eword, List<String> oldResult){
    if(sword.equals(eword)){
      return true;
    }
    for(int i=0; i<sword.length(); i++){
      for(int j=97 ; j<= 122; j++){
        String temp = sword;
        sword = replace(sword,i,(char)j);
        if(dictionary.contains(sword) && !oldResult.contains(sword)) {
          oldResult.add(sword);
          if(printChain(sword,eword,oldResult)){
            return true;
          }
          oldResult.remove(sword);
        }
        sword = temp;
      }
    }
    return false;
  }

  private static String replace(String str, int index, char replace){
    if(index<0 || index>=str.length()){
      return str;
    }
    char[] chars = str.toCharArray();
    chars[index] = replace;
    return String.valueOf(chars);
  }

}
