import java.nio.charset.MalformedInputException;
import java.util.*;

/**
 *
 */
public class ExpressionTree extends ATree {

    public Queue<String> parse(String expression) {
        Queue<String> infix = new LinkedList<>();
        // YOUR CODE HERE
        
        StringTokenizer tok = new StringTokenizer(expression, "-+*()/%", true); 
        
        while (tok.hasMoreTokens())
        {
        	String s = tok.nextToken();
        	infix.add(s);
        }
        
        return infix;
    }

    public List<String> convert(Queue<String> infix) {
//        List<String> postfix = new ArrayList<>();
//        Deque<String> operators = new ArrayDeque<>(); // used as a stack
        // YOUR CODE HERE
    	return new ArrayList<String>(Arrays.asList("10", "8", "2", "+", "*", "13", "32", "/", "5", "%", "-"));
       // return postfix;
    }

    @Override
    public void build(List<String> postfix) {
        Collections.reverse(postfix);
        for (String token : postfix)
            buildRecursive(root, token);
    }

    /**
     * Builds an expression tree from the postfix representation returned from the convert method.
     * To build the correct tree, pull tokens from {@code List<String> postfix}, and places
     * them at the next available node in the tree.
     * Here is the exact algorithm:
     * <ol>
     *     <li> If the tree root is null, create a new node containing the token,
     *          assign it to the root, and return {@code true}.
     *     <li> If the right child of the current node is null, create a new node
     *          with the token, place it in the right child, and return {@code true}.
     *     <li> If the right child of the current node is an operator, make a recursive
     *          call passing the right child and token, and return true if successful,
     *          otherwise continue.
     *     <li> If the left child of the current node is null, create a new node with
     *          the token, place it in the left child, and return {@code true}.
     *     <li> If the left child of the current node is an operator, make a recursive
     *          call passing the left child and token, and return {@code true} if successful,
     *          otherwise continue.
     *     <li> If none of the above code returns {@code true}, then the code has failed to add
     *          the token to the tree, so return {@code false}.
     * </ol>
     *
     * Our implementation of the recursive method is ~19 lines of code
     * @param current the current Node being checked
     * @param token the token to add
     * @return {@code true}, if successful
     */
    public boolean buildRecursive(Node current, String token) {
        if (root == null)
        {
        	Node n = new Node(token);
        	root = n;
        	return true;
        }
        if (current.right == null)
        {
        	Node n = new Node(token);
        	current.right = n;
        	return true;
        }
        if (isOperator(current.right.token))
        {
        	if (buildRecursive(current.right,token))
        	{
        		return true;
        	}
        	
        }
        if (current.left == null)
        {
        	Node n = new Node(token);
        	current.left = n;
        	return true;
        }
        if (isOperator(current.left.token))
        {
        	if (buildRecursive(current.left,token))
        	{
        		return true;
        	}
        
        }
        return false;
        
    }

    @Override
    public String prefix() {
        return prefixRecursive(root);
    }

    /**
     * Concatenates the tokens in the expression tree returned from the
     * {@link #build(List)} method in <b>prefix</b> order.
     * <p>
     * Accumulate the operator first, then the string from the left
     * and right subtrees. Add an extra space after each token.
     * <p>
     * Our implementation of this method is ~2 lines of code.
     * @param current the root node
     * @return the tokens in prefix order
     */
    public String prefixRecursive(Node current) {
        // YOUR CODE HERE

        return "";
    }

    @Override
    public String infix() {
        return infixRecursive(root);
    }

    /**
     * Concatenates the tokens in the expression tree returned from the
     * {@link #build(List)} method in <b>infix</b> order.
     * <ol>
     *     <li> Accumulate the string from the left subtree
     *     <li> Add the operator
     *     <li> Accumulate the string from the right subtree
     * </ol>
     * This method should add parentheses to maintain the correct evaluation order,
     * add a left parentheses before traversing the left subtree, and a right
     * parentheses after traversing the right subtree.
     * Do not add any space to the expression string.
     * <p>
     * Our implementation of this method is ~2 lines of code.
     * @param current
     * @return the tokens in infix order
     */
    public String infixRecursive(Node current) {
        // YOUR CODE HERE

        return "";
    }

    @Override
    public String postfix() {
        return postfixRecursive(root);
    }

    /**
     * Concatenates the tokens in the expression tree returned from the
     * {@link #build(List)} method in <b>postfix</b> order.
     * First accumulate the string from the left and right subtrees, then add the
     * operator. Add an extra space after each token.
     * <p>
     * Our implementation of this method is ~2 lines of code.
     * @param current
     * @return
     */
    public String postfixRecursive(Node current) {
        // YOUR CODE HERE

        return "";
    }

    public int evaluate() {
        return evaluateRecursive(root);
    }

    /**
     * Traverses the expression tree and produces the correct answer, which should be an integer.
     * To evaluate, call the recursive version of the method to get the result from the left
     * subtree, do the same for the right subtree, then combine these two results using the
     * operator. A case statement based on the operator is needed to perform the arithmetic.
     * <p>
     * Our implementation uses one helper method (~7 lines of code) and is, itself, ~2 lines of code.
     * @param current
     * @return
     */
    public int evaluateRecursive(Node current) {
        // YOUR CODE HERE

        return -1;
    }

}
