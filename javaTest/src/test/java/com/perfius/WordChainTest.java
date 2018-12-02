package com.perfius;

import org.junit.Test;
import perfius.Dictionary;
import perfius.ResultNotFoundException;
import perfius.WordChain;
import java.util.List;

public class WordChainTest {

  @Test
  public void basicTest(){
    List<String> result = new WordChain(Dictionary.getInstance()).printChain("coins","money");
    assert result.size() == 5;
    assert result.get(0).equals("corns");
    assert result.get(1).equals("cores");
    assert result.get(2).equals("cones");
    assert result.get(3).equals("coney");
    assert result.get(4).equals("money");
  }

  @Test
  public void whenTrackingPathHas2OptionsThenBacktrackingForRightResult(){
    Dictionary dictionary = Dictionary.getInstance();
    dictionary.add("conez");
    List<String> result = new WordChain(dictionary).printChain("coins","conez");
    System.out.println(result);
    assert result.size() == 5;
    assert result.get(0).equals("corns");
    assert result.get(1).equals("cores");
    assert result.get(2).equals("cones");
    assert result.get(3).equals("coney");
    assert result.get(4).equals("conez");
  }

  @Test
  public void whenStartAndEndAreSameResultIsEmpty(){
    Dictionary dictionary = Dictionary.getInstance();
    List<String> result = new WordChain(dictionary).printChain("coins","coins");
    System.out.println(result);
    assert result.size() == 0;
  }

  @Test(expected = IllegalArgumentException.class)
  public void whenLengthOfWordsAreNotSamethrowException(){
    Dictionary dictionary = Dictionary.getInstance();
    new WordChain(dictionary).printChain("coins","coin");
  }

  @Test(expected = IllegalArgumentException.class)
  public void whenDictionaryIsThrowException(){
    new WordChain(null).printChain("coins","money");
  }

  @Test(expected = ResultNotFoundException.class)
  public void whenResultIsNotPossibleThenException(){
    new WordChain(Dictionary.getInstance()).printChain("coins","monep");
  }

}
