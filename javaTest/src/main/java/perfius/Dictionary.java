package perfius;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

  private final Set<String> words;
  private static Dictionary dictionary = null;

  private Dictionary(Set<String> words){
    this.words = words;
  }

  public static Dictionary getInstance() {
    if(dictionary != null){
      return dictionary;
    }
    String[] strings = {"corns", "cores","cones","coney","money"};
    Set<String> strings1 = new HashSet<>(Arrays.asList(strings));
    dictionary = new Dictionary(strings1);
    return dictionary;
  }

  public Dictionary add(String str){
    this.words.add(str);
    return this;
  }

  public boolean contains(String word){
    return words.contains(word);
  }

  public int size(){
    return words.size();
  }

  public void validate() {
    if(this.size() == 0){
      throw new IllegalArgumentException("Dictionary cant be empty");
    }
  }

}
