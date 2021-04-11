package solutions;

import java.util.ArrayList;
import java.util.List;

public class FancySequence {
    class Operation {
        String command;
        int val;

        public Operation(String command, int val) {
            this.command = command;
            this.val = val;
        }
    }

    class Pair {
        int num;
        int opIndex;

        Pair(int num, int opIndex) {
            this.num = num;
            this.opIndex = opIndex;
        }
    }

    List<Pair> list = new ArrayList<>();
    List<Operation> operations = new ArrayList<>();

    public FancySequence() {
    }

    public void append(int val) {
        list.add(new Pair(val, operations.size()));
    }

    public void addAll(int inc) {
        operations.add(new Operation("ADD", inc));
    }

    public void multAll(int m) {
        operations.add(new Operation("MULTIPLY", m));
    }

    public int getIndex(int idx) {
        if(idx >= list.size()) {
            return -1;
        }

        Pair p = list.get(idx);
        int val = p.num;
        for(int i = p.opIndex; i < operations.size(); i++) {
            Operation o = operations.get(i);
            switch(o.command) {
                case "ADD":
                    val += o.val;
                    break;
                case "MULTIPLY" :
                    val = (int)((long)val*o.val % (1e9+7));
                    break;
            }
        }

        p.num = val;
        p.opIndex = operations.size();

        return p.num;
    }
}
