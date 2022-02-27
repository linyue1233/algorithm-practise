package amazone;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class DesignEpressionTree {

    // 1628

    abstract class Node {
        public abstract int evaluate();
        // define your fields here

    };

    interface Operation{
        int performOperation(int a, int b);
    }

    class NumberNode extends Node{
        private int value;

        public NumberNode(int value){
            this.value = value;
        }

        @Override
        public int evaluate(){
            return this.value;
        }
    }

    class OperationNode extends Node{
        private final Node left;
        private final Node right;
        private final Operation op;

        public OperationNode (Node right, Node left, Operation operation){
            this.left = left;
            this.right = right;
            this.op = operation;
        }

        @Override
        public int evaluate(){
            return op.performOperation(left.evaluate(),right.evaluate());
        }
    }

    class TreeBuilder {
        private final Map<String, Operation> ops = Map.ofEntries(
                Map.entry("+", (a, b) -> a + b),
                Map.entry("-", (a, b) -> a - b),
                Map.entry("*", (a, b) -> a * b),
                Map.entry("/", (a, b) -> a / b)
        );


        Node buildTree(String[] postfix) {
            Deque<Node> deque = new LinkedList<>();
            for(String item : postfix){
                Node node;
                if( ops.containsKey(item) ){
                    node = new OperationNode(deque.pollLast(),deque.pollLast(), ops.get(item));
                }else{
                    node = new NumberNode(Integer.parseInt(item));
                }
                deque.offerLast(node);
            }
            return deque.pollLast();
        }
    };
}
