package lab.enumeration;

public class UserStatusTest {

    public enum UsrSts {PENDING, ACTIVE, INACTIVE, DELETED}

    public static void main(String[] args) {
        System.out.println(UsrSts.PENDING);             // prints PENDING
        System.out.println(UsrSts.PENDING.name());      // prints PENDING
        System.out.println(UsrSts.PENDING.ordinal());   // prints 0
        System.out.println();
        System.out.println(UsrSts.ACTIVE);              // prints ACTIVE
        System.out.println(UsrSts.ACTIVE.name());       // prints ACTIVE
        System.out.println(UsrSts.ACTIVE.ordinal());    // prints 1
        System.out.println();
        System.out.println(UsrSts.INACTIVE);            // prints INACTIVE
        System.out.println(UsrSts.INACTIVE.name());     // prints INACTIVE
        System.out.println(UsrSts.INACTIVE.ordinal());  // prints 2
        System.out.println();
        System.out.println(UsrSts.DELETED);             // prints DELETED
        System.out.println(UsrSts.DELETED.name());      // prints DELETED
        System.out.println(UsrSts.DELETED.ordinal());   // prints 3
    }
}
/* Prints:
PENDING
ACTIVE
INACTIVE
DELETED
*/
