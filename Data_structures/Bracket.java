import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        int result = 0;
        int tempRes = 0;
        STACKFOR:
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position));
                // Process opening bracket, write your code here
                result = position + 1;
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (opening_brackets_stack.size() < 1) {
                    if (tempRes != 0) {
                        System.out.println(tempRes + 1);
                    } else
                        System.out.println(position+1);
                    System.exit(0);
                }
                if (opening_brackets_stack.lastElement().Match(next)) {
                    tempRes += 2;
                    opening_brackets_stack.remove(opening_brackets_stack.lastElement());
                    if (!opening_brackets_stack.empty()) {
                        result = text.indexOf(opening_brackets_stack.peek().type) + 1;
                    }
                    continue STACKFOR;
                } else {
                    result = position + 1;
                    System.out.println(result);
                    System.exit(0);
                }
            }

        }
        if (opening_brackets_stack.empty()) {
            System.out.println("Success");
        } else
            System.out.println(result);
    }

    // Printing answer, write your code here
}
