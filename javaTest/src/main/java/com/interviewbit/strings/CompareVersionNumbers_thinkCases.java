package com.interviewbit.strings;

public class CompareVersionNumbers_thinkCases {

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("1.13","1.13.4"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("1.13","1.1"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("1.13",".13"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("1.13","1.4"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("1.13","0.1"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("01","1"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("13.0","13.0.8"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("4444371174137455","13"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("44443711741374551","44443711741374552"));
        System.out.println(new CompareVersionNumbers_thinkCases().compareVersion("00044443711741374551","44443711741374552"));

    }

    public int compareVersion(String A, String B) {
        String[] str1 = A.split("\\.");
        String[] str2 = B.split("\\.");

        if(A.equals(B)){
            return 0;
        }
        int i =0;
        while (true){
            if(i>str1.length && i>str2.length){
                break;
            }
            String a = this.getNextStr(str1,i);
            String b = this.getNextStr(str2,i);

            if(a.equals(b)){
                i++;
                continue;
            }
            return compare2Strings(a,b);
        }
        return 0;
    }

    private int compare2Strings(String a, String b) {
        int c = 0;
        if(a.length() != b.length()){
            c = Math.abs(a.length() - b.length());
        }
        String z ="";
        for(int i=0;i<c;i++){
            z = z.concat("0");
        }

        if(a.length() < b.length()){
            a = z.concat(a);
        }
        else{
            b = z.concat(b);
        }

        for(int i=0;i<a.length();i++){
            if(Integer.parseInt(String.valueOf(a.charAt(i))) > Integer.parseInt(String.valueOf(b.charAt(i)))){
                return 1;
            }
            if(Integer.parseInt(String.valueOf(a.charAt(i))) < Integer.parseInt(String.valueOf(b.charAt(i)))){
                return -1;
            }
        }
        return 0;
    }

    private String getNextStr(String[] str1, int i) {
        if(i>=str1.length){
            return "0";
        }
        if(str1[i].trim().equals("")){
            return "0";
        }
        else{
            return str1[i];
        }

    }

}

/*Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
*/