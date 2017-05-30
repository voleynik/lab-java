package lab.util;
import java.util.ArrayList;

public class Polindrom {

	static String s 	= "abcacdrfasdsaf";
	static ArrayList al = new ArrayList();

	public static void main(String[] args){
		String s1 = null;
		String s2 = null;
		StringBuffer sb = null;
		for (int i = 0; i < s.length(); i++ ) {
			for (int j = 2; j < (s.length() - i + 1); j++) {
				s1 = s.substring(i, i + j);
				System.out.println(s1 + " i: " + i + ", j: " + j);
				sb = new StringBuffer(s1);
				s2 = sb.reverse().toString();
				if(s1.equals(s2)){
					al.add(s1);
				}
			}
		}
		System.out.println(al);
	}
}
/* Output
ab i: 0, j: 2
abc i: 0, j: 3
abca i: 0, j: 4
abcac i: 0, j: 5
abcacd i: 0, j: 6
abcacdr i: 0, j: 7
abcacdrf i: 0, j: 8
abcacdrfa i: 0, j: 9
abcacdrfas i: 0, j: 10
abcacdrfasd i: 0, j: 11
abcacdrfasds i: 0, j: 12
abcacdrfasdsa i: 0, j: 13
abcacdrfasdsaf i: 0, j: 14
bc i: 1, j: 2
bca i: 1, j: 3
bcac i: 1, j: 4
bcacd i: 1, j: 5
bcacdr i: 1, j: 6
bcacdrf i: 1, j: 7
bcacdrfa i: 1, j: 8
bcacdrfas i: 1, j: 9
bcacdrfasd i: 1, j: 10
bcacdrfasds i: 1, j: 11
bcacdrfasdsa i: 1, j: 12
bcacdrfasdsaf i: 1, j: 13
ca i: 2, j: 2
cac i: 2, j: 3
cacd i: 2, j: 4
cacdr i: 2, j: 5
cacdrf i: 2, j: 6
cacdrfa i: 2, j: 7
cacdrfas i: 2, j: 8
cacdrfasd i: 2, j: 9
cacdrfasds i: 2, j: 10
cacdrfasdsa i: 2, j: 11
cacdrfasdsaf i: 2, j: 12
ac i: 3, j: 2
acd i: 3, j: 3
acdr i: 3, j: 4
acdrf i: 3, j: 5
acdrfa i: 3, j: 6
acdrfas i: 3, j: 7
acdrfasd i: 3, j: 8
acdrfasds i: 3, j: 9
acdrfasdsa i: 3, j: 10
acdrfasdsaf i: 3, j: 11
cd i: 4, j: 2
cdr i: 4, j: 3
cdrf i: 4, j: 4
cdrfa i: 4, j: 5
cdrfas i: 4, j: 6
cdrfasd i: 4, j: 7
cdrfasds i: 4, j: 8
cdrfasdsa i: 4, j: 9
cdrfasdsaf i: 4, j: 10
dr i: 5, j: 2
drf i: 5, j: 3
drfa i: 5, j: 4
drfas i: 5, j: 5
drfasd i: 5, j: 6
drfasds i: 5, j: 7
drfasdsa i: 5, j: 8
drfasdsaf i: 5, j: 9
rf i: 6, j: 2
rfa i: 6, j: 3
rfas i: 6, j: 4
rfasd i: 6, j: 5
rfasds i: 6, j: 6
rfasdsa i: 6, j: 7
rfasdsaf i: 6, j: 8
fa i: 7, j: 2
fas i: 7, j: 3
fasd i: 7, j: 4
fasds i: 7, j: 5
fasdsa i: 7, j: 6
fasdsaf i: 7, j: 7
as i: 8, j: 2
asd i: 8, j: 3
asds i: 8, j: 4
asdsa i: 8, j: 5
asdsaf i: 8, j: 6
sd i: 9, j: 2
sds i: 9, j: 3
sdsa i: 9, j: 4
sdsaf i: 9, j: 5
ds i: 10, j: 2
dsa i: 10, j: 3
dsaf i: 10, j: 4
sa i: 11, j: 2
saf i: 11, j: 3
af i: 12, j: 2
[cac, fasdsaf, asdsa, sds] 
*/