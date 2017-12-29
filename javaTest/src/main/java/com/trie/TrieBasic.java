package com.trie;

public class TrieBasic {

  private static TrieNode root;

  static class TrieNode {

    Boolean isEnd;
    char c;

    TrieNode[] childNodes = new TrieNode[100];

    TrieNode() {
      this.isEnd = false;
    }

    TrieNode(char c) {
      this.isEnd = false;
      this.c = c;
    }

  }

  private static boolean search(String key) {
    TrieNode temp = root;

    for (char c : key.toCharArray()) {
      if (temp.childNodes[c - 50] == null) {
        return false;
      }
      temp = temp.childNodes[c - 50];
    }
    if (temp.isEnd) {
      return true;
    }
    return false;
  }

  private static void insert(String key) {
    TrieNode temp = root;

    for (char c : key.toCharArray()) {
      if (temp.childNodes[c - 50] == null) {
        temp.childNodes[c - 50] = new TrieNode(c);
      }
      temp = temp.childNodes[c - 50];
    }
    temp.isEnd = true;
  }


  private static void delete(String key) {
    TrieNode temp = root;
    char c = key.toCharArray()[0];
    if (temp.childNodes[c - 50] == null) {
      return;
    }
    deleteHelper(temp.childNodes[c - 50], key, 0);
  }

  private static boolean deleteHelper(TrieNode childNode, String key, int index) {
    if (key.toCharArray().length == index) {
      childNode.isEnd = false;
      for (TrieNode node1 : childNode.childNodes) {
        if (node1 != null) {
          return false;
        }
      }
      childNode = null;
      return true;
    }
    if (deleteHelper(childNode.childNodes[key.toCharArray()[index] - 50], key, index + 1)) {
      for (TrieNode node1 : childNode.childNodes) {
        if (node1 != null) {
          return false;
        }
      }
      childNode = null;
      return true;
    }
    return false;
  }


  public static void main(String[] args) {
    // Input keys (use only 'a' through 'z' and lower case)
    String keys[] = {"the", "a", "there", "answer", "any",
      "by", "bye", "their"};

    String output[] = {"Not present in trie", "Present in trie"};


    root = new TrieNode();

    // Construct trie
    int i;
    for (i = 0; i < keys.length; i++)
      insert(keys[i]);

    // Search for different keys
    if (search("the"))
      System.out.println("the --- " + output[1]);
    else System.out.println("the --- " + output[0]);

    if (search("these"))
      System.out.println("these --- " + output[1]);
    else System.out.println("these --- " + output[0]);

    if (search("their"))
      System.out.println("their --- " + output[1]);
    else System.out.println("their --- " + output[0]);

    if (search("thaw"))
      System.out.println("thaw --- " + output[1]);
    else System.out.println("thaw --- " + output[0]);

    delete("the");

    // Search for different keys
    if (search("the"))
      System.out.println("the --- " + output[1]);
    else System.out.println("the --- " + output[0]);

    if (search("there"))
      System.out.println("there --- " + output[1]);
    else System.out.println("there --- " + output[0]);

  }


}
