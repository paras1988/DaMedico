package com.FP_Generics;

import java.util.ArrayList;
import java.util.List;

public class BasicFP {

  public static void main(String[] args) {

    List<User> users = createUsers();
    UserList userList = getUserList(users);

    //Basic Way to user UserFilter prior to Java8
    //Create class when we just want to use one method of MALE or FEMALE
    UserFilter maleAndAgeFilter = new UserFilter() {

      @Override
      public boolean accept(User user) {
        return user.isMaleAndAge18();
      }
    };

    UserFilter maleFilter = new UserFilter() {

      @Override
      public boolean accept(User user) {
        return user.isMale();
      }
    };

    System.out.println("Users filtered as " + userList.applyFilter(maleAndAgeFilter).size());
    System.out.println("Users filtered as " + userList.applyFilter(maleFilter).size());


    //JAVA8
    System.out.println("Users filtered as " + userList.applyFilter(User::isMaleAndAge18).size());
    System.out.println("Users filtered as " + userList.applyFilter(User::isMale).size());
    System.out.println("Users filtered as " + userList.applyFilter(User::isFemale).size());


    System.out.println("Users filtered as " + userList.applyFilter(user -> user.sex == Sex.MALE).size());
    System.out.println("Users filtered as " + userList.applyFilter(user -> user.age > 18).size());

  }


  private static UserList getUserList(List<User> users) {
    return new UserList(users);
  }

  private static List<User> createUsers() {
    User user1 = new User("RANA", 19, Sex.MALE);
    User user2 = new User("RANI", 12, Sex.FEMALe);
    User user3 = new User("RAKA", 12, Sex.MALE);

    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);
    users.add(user3);
    return users;
  }
}

@FunctionalInterface
interface UserFilter {

  boolean accept(User user);

}

class User {
  String name;
  int age;
  Sex sex;

  public User(String name, int age, Sex sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  Boolean isMaleAndAge18() {
    return this.sex == Sex.MALE && age >= 18;
  }

  Boolean isMale() {
    return this.sex == Sex.MALE;
  }

  Boolean isFemale() {
    return this.sex == Sex.FEMALe;
  }
}

class UserList {

  List<User> users;

  public UserList(List<User> users) {
    this.users = users;
  }

  public List<User> applyFilter(UserFilter userFilter) {
    List<User> res = new ArrayList<>();
    for (User user : this.users) {
      if (userFilter.accept(user)) {
        res.add(user);
      }
    }
    return res;
  }
}

enum Sex {
  MALE, FEMALe;
}
