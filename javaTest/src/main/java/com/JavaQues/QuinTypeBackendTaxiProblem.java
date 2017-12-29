package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/*Taxi Please!
Max. Marks 100
Today, you have been given the task of handling the entire Taxi Network of Berland City. Berland city has a huge number of taxi travellers, and you need to help them in transportation in the most efficient manner.

To be precise, this city consists of
N
N users who want to travel via a Taxi today. You have a total of
M
M taxis and need to cater to the users using these taxis. Each user has two parameters associated with them,
S
i
Si and
J
i
Ji, denoting the time at which a user requests a taxi and the travel time required to reach the destination of this particular user. Each taxi can be used by a maximum of
1
1 user at each point in time.

If, at any point in time a user requests a taxi and all
M
M taxis are busy, then this user's request is rejected. If multiple taxis are available at the time of the request of a user, the taxi with the lowest index that is available is alloted to them. Now, you need to find for each user, the index of the taxi alloted to them. If a particular user's request is rejected, print "-1" (without quotes) for them.

Note: For the purpose of the problem, we consider a user gets their taxi immediately if their request is accepted. The taxi's are enumerated from
1
1 to
M
M. A taxi is considered to be free as soon as the previous user's journey ends. It is guaranteed that the request time of each user is unique.

Input Format:

The first line contains two integers
N
N and
M
M denoting the number of users and the number of taxis respectively. Each of the next
N
N lines contains
2
2 space separated integers
S
i
Si and
J
i
Ji denoting the request and journey time of the
i
t
h
ith user.

Output Format:

For each user from
1
1 to
N
N, print the index number of the taxi alloted to them. If a user's request is rejected , print "-1"(without quotes) for them.

Constraints:

1
≤
N
≤
10
5
Sample Input(Plaintext Link)
5 5
1 100
2 100
3 100
4 100
5 100
Sample Output(Plaintext Link)
 1 2 3 4 5
Explanation
Here, user
1
1 is given taxi
1
1, user
2
2 is given taxi
2
2, user
3
3 is given taxi
3
3 and so on for user
4
4and
5
5.

 *
 */

public class QuinTypeBackendTaxiProblem {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sd=br.readLine().split("\\s+");

		int numberOfTaxi=Integer.parseInt(sd[1]);
		int numberOfReq=Integer.parseInt(sd[0]);

		Map<Integer,Integer> iMap=new TreeMap<>();

		for(int i=0;i<numberOfReq;i++){
			String[] ss=br.readLine().split("\\s+");
			int j=Integer.parseInt(ss[0]);
			int k=Integer.parseInt(ss[1]);
			iMap.put(j,k);
		}

		ArrayList<Integer> res=getIndexOfTaxiAlloted(iMap,numberOfTaxi);

		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+" ");
		}
	}

	public static ArrayList<Integer> getIndexOfTaxiAlloted(
			Map<Integer, Integer> iMap, int numberOfTaxi) {

		Map<Integer,Integer> taxiIndexMap=new LinkedHashMap<Integer,Integer>();
		ArrayList<Integer> res=new ArrayList<Integer>();

		for(Entry<Integer,Integer> e:iMap.entrySet()){

			int taxiNumber=-1;
			for(int i=1;i<=numberOfTaxi;i++){
				if(!taxiIndexMap.containsKey(i) || taxiIndexMap.get(i)<e.getKey()){
					taxiNumber=i;
					break;
				}
			}
			taxiIndexMap.put(taxiNumber,e.getKey()+e.getValue());
			res.add(taxiNumber);
		}

		return res;
	}
}