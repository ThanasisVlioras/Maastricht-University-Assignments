import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class DFA {
    // I'm using a bit of object oriented programming, basically this block defines that all DFAs have a transitionTable and an acceptingStates array.

    /** This is essentially an array of maps. We have one map per state. A map is like an array but more flexible. In this case we can index the map with a character, such as 'w', and get the id of the new state we go to as a result. */
    private ArrayList<HashMap<Character, Integer>> transitionTable;

    /** This is a set, if a state id is a member then that state is considered accepting, else rejecting. */ 
    private HashSet<Integer> acceptingStates; 

    // Computers are silly, so we must tell Java to ask for these parameters every time we make a DFA. This is called a constructor.
    public DFA(ArrayList<HashMap<Character, Integer>> _transitionTable, HashSet<Integer> _acceptingStates) {
        transitionTable = _transitionTable;
        acceptingStates = _acceptingStates;
    }

    // This method is NOT marked as static. This means that we must first create a DFA (using the constructor) and then call it FROM that DFA.
    // In turn, this allows us to use fields that all DFAs contain such as transitionTable and acceptingStates
    // A scanner is also an object, and scanner.next() is a class method, like checkString is here.
    /** Checks whether the DFA accepts the given string. */
    public boolean checkString(String string) {
        Integer currentState = 0;

        for (char input : string.toCharArray()) { // This is a more concise version of "for (int i=0; ...".
            currentState = transitionTable.get(currentState).get(input); // First we index the transitionTable to get a map, then index the map with the current character.
            if(currentState == null) return false; // If we get an unknown character (not in the map) then we instantly decide that the string is invalid.
        }

        // if (acceptingStates.contains(currentState)) {
        //     return true;
        // } else {
        //     return false;
        // } We do not need to do it like this as acceptingStates.contains(currentState) is already a boolean

        return acceptingStates.contains(currentState);
    }


    /** Exports the transition table as csv, used for the report. */
    public String exportAsCSV() {
        String csv = "";

        for (int i=0; i < transitionTable.size(); i++) {
            HashMap<Character, Integer> map = transitionTable.get(i);

            csv += "S" + i + ",";
            for (Entry<Character,Integer> entrySet : map.entrySet()) {
                csv += entrySet.getKey() + ": S" + entrySet.getValue() + ",";
            }

            csv += "\n";
        }

        return csv;
    }

    // This method IS marked as static. This means that even though it is within the DFA class, we do not call it from a created DFA. Instead, we call it through: DFA.getSecretCodeDFA()
    /** Internally uses the constructor to create and return a DFA that accepts our secret code. */
    public static DFA getSecretCodeDFA() {
        //transitionTable.get(currentState); // Note that since this is static, it is not called from INSIDE a DFA, thus we do not have fields such as transitionTable available here.
        // Uncomment the above to check the error.

        ArrayList<HashMap<Character, Integer>> transitionTable = new ArrayList<HashMap<Character, Integer>>();
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(0).put('x', 5);
        transitionTable.get(0).put('y', 5);
        transitionTable.get(0).put('z', 5);
        transitionTable.get(0).put('w', 1);
        transitionTable.get(0).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(1).put('x', 5);
        transitionTable.get(1).put('y', 5);
        transitionTable.get(1).put('z', 5);
        transitionTable.get(1).put('w', 2);
        transitionTable.get(1).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(2).put('x', 5);
        transitionTable.get(2).put('y', 5);
        transitionTable.get(2).put('z', 5);
        transitionTable.get(2).put('w', 3);
        transitionTable.get(2).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(3).put('x', 5);
        transitionTable.get(3).put('y', 5);
        transitionTable.get(3).put('z', 5);
        transitionTable.get(3).put('w', 4);
        transitionTable.get(3).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(4).put('x', 8);
        transitionTable.get(4).put('y', 4);
        transitionTable.get(4).put('z', 4);
        transitionTable.get(4).put('w', 4);
        transitionTable.get(4).put('v', 6);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(5).put('x', 5);
        transitionTable.get(5).put('y', 5);
        transitionTable.get(5).put('z', 5);
        transitionTable.get(5).put('w', 5);
        transitionTable.get(5).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(6).put('x', 9);
        transitionTable.get(6).put('y', 6);
        transitionTable.get(6).put('z', 6);
        transitionTable.get(6).put('w', 6);
        transitionTable.get(6).put('v', 7);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(7).put('x', 10);
        transitionTable.get(7).put('y', 7);
        transitionTable.get(7).put('z', 7);
        transitionTable.get(7).put('w', 11);
        transitionTable.get(7).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(8).put('x', 4);
        transitionTable.get(8).put('y', 8);
        transitionTable.get(8).put('z',8);
        transitionTable.get(8).put('w', 8);
        transitionTable.get(8).put('v', 9);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(9).put('x', 6);
        transitionTable.get(9).put('y', 9);
        transitionTable.get(9).put('z', 9);
        transitionTable.get(9).put('w', 9);
        transitionTable.get(9).put('v', 10);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(10).put('x', 7);
        transitionTable.get(10).put('y', 10);
        transitionTable.get(10).put('z', 10);
        transitionTable.get(10).put('w', 10);
        transitionTable.get(10).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(11).put('x', 12);
        transitionTable.get(11).put('y', 7);
        transitionTable.get(11).put('z', 7);
        transitionTable.get(11).put('w', 11);
        transitionTable.get(11).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(12).put('x', 7);
        transitionTable.get(12).put('y', 10);
        transitionTable.get(12).put('z', 10);
        transitionTable.get(12).put('w', 13);
        transitionTable.get(12).put('v', 5);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(13).put('x', 7);
        transitionTable.get(13).put('y', 10);
        transitionTable.get(13).put('z', 10);
        transitionTable.get(13).put('w', 10);
        transitionTable.get(13).put('v', 5);

        HashSet<Integer> acceptingStates = new HashSet<Integer>();
        acceptingStates.add(13);

        return new DFA(transitionTable, acceptingStates);
    }
}

class DFATest {
    public static void testHeatwave() {
        // We initialize the DFA using this ugly monstrosity

        ArrayList<HashMap<Character, Integer>> transitionTable = new ArrayList<HashMap<Character, Integer>>();
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(0).put('0', 0);
        transitionTable.get(0).put('1', 1);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(1).put('0', 0);
        transitionTable.get(1).put('1', 2);
        transitionTable.add(new HashMap<Character, Integer>());
        transitionTable.get(2).put('0', 2);
        transitionTable.get(2).put('1', 2);

        HashSet<Integer> acceptingStates = new HashSet<Integer>();
        acceptingStates.add(2);

        DFA dfa = new DFA(transitionTable, acceptingStates);

        // Testing could be more automated
        
        System.out.println("Should be accepted:");
        System.out.println(dfa.checkString("11"));
        System.out.println(dfa.checkString("011"));
        System.out.println(dfa.checkString("110"));
        System.out.println(dfa.checkString("0101010101100"));

        System.out.println("\nShould be rejected:");
        System.out.println(dfa.checkString("0"));
        System.out.println(dfa.checkString("1"));
        System.out.println(dfa.checkString("00"));
        System.out.println(dfa.checkString("01"));
        System.out.println(dfa.checkString("10"));
        System.out.println(dfa.checkString("01010101"));
        System.out.println(dfa.checkString("10101010"));
    }

    public static void testCode() {
        DFA dfa = DFA.getSecretCodeDFA();

        System.out.println("Should be accepted:");
        System.out.println(dfa.checkString("wwwwvvwxw"));
        System.out.println(dfa.checkString("wwwwxyzvxyzvwxw"));
        System.out.println(dfa.checkString("wwwwxyzvxxxyzvwxw"));

        System.out.println("\nShould be rejected:");
        System.out.println(dfa.checkString("wwwwxyxvw"));
        System.out.println(dfa.checkString("wwwwxyzvxxyzvwxw"));
        System.out.println(dfa.checkString("wwwxyzvxyzvwxw"));
        System.out.println(dfa.checkString("wwwwxyzvxyzvwxwy"));
        System.out.println(dfa.checkString("wwwwxyzvxyzvwxwwwwwxyzvxyzvwxw"));
    }

    public static void main(String[] args) {
        //testHeatwave();
        testCode();
    }
}