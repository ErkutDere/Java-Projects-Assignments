import java.util.Stack;

public class Homework4 {

    public static class Username {
        private String username;

        /**
         * Constructor for Username class
         * 
         * @param username
         */
        public Username(String username) {
            this.username = username;
        }

        /**
         * Returns username
         * 
         * @return username
         */
        public String getUsername() {
            return username;
        }

        /**
         * This method checks for username validity.
         * 
         * @param username
         * @return true if username is valid, otherwise return false.
         */
        public boolean checkIfValidUsername(String username) {
            if (username == null || username.isEmpty()) {
                System.out.println("The username is not entered. You should enter your username.");
                return false;
            }

            if (Character.isDigit(username.charAt(0))) {
                System.out.println("The username is invalid. It should have letters only.");
                return false;
            }
            if (!Character.isLetter(username.charAt(0))) {
                System.out.println("The username is invalid. It should have at least 1 character.");
                return false;
            }
            // System.out.println(username.charAt(0));
            String rest = username.substring(1);
            return rest.isEmpty() || checkIfValidUsername(username.substring(1));
        }
    }

    public static class Password1 {
        private String password1;

        /**
         * Constructor for password1
         * 
         * @param p1
         */
        public Password1(String p1) {
            this.password1 = p1;
        }

        /**
         * Returns password1
         * 
         * @return password1
         */
        public String getPassword1() {
            return password1;
        }

        /**
         * Returns the length of the password1
         * 
         * @return password1 length
         */
        public int getLength() {
            return password1.length();
        }

        /**
         * This method checks that password1 includes more than 2 bracket, if it is not
         * then it returns false.
         * 
         * @return true if includes two or more brackets otherwise return false.
         */
        public boolean isBracketPassword1() {
            int brackets = 0;
            for (int i = 0; i < password1.length(); i++) {
                if (password1.charAt(i) == '{' || password1.charAt(i) == '[' || password1.charAt(i) == '('
                        || password1.charAt(i) == '}' || password1.charAt(i) == ']' || password1.charAt(i) == ')') {
                    brackets++;
                }
            }
            if (brackets < 2) {
                return false;
            }
            return true;
        }

        /**
         * This method checks that password1 includes any letters.
         * 
         * @return true if there is at least 1 letter otherwise return false.
         */
        public boolean isLetterContainPassword1() {
            int letter = 0;
            for (int i = 0; i < password1.length(); i++) {
                if (Character.isLetter(password1.charAt(i))) {
                    letter++;
                }
            }
            if (letter > 0)
                return true;
            else
                return false;
        }

        /**
         * This method removes brackets inside of the password
         * 
         * @param password
         * @return password without brackets
         */
        public String removeBrackets(String password) {
            String newString = "";
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == '{' || password.charAt(i) == '[' || password.charAt(i) == '('
                        || password.charAt(i) == '}' || password.charAt(i) == ']' || password.charAt(i) == ')') {
                    continue;
                }
                newString += password.charAt(i);
            }
            newString = newString.toLowerCase(); // Convert all letters to lowercase for easier comparison
            return newString;
        }

        /**
         * This method gets parameter as username and password and it checks whether
         * password contains any letter that is in username.
         * 
         * @param username
         * @param password
         * @return true if there are any letter otherwise returns false and prints the
         *         error message.
         */
        public boolean containsUserNameSpirit(String username, String password) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < password.length(); i++) {
                if (Character.isLetter(password.charAt(i))) {
                    stack.push(password.charAt(i));
                }
            }
            for (int index = 0; index < username.length(); index++) {
                if (stack.contains(username.charAt(index))) {
                    return true;
                }
            }
            System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
            return false;

        }

        /**
         * This method checks whether password includes balanced password.
         * 
         * @param Password1
         * @return true if it contains balanced password otherwise returns false and
         *         prints the error message
         */
        public boolean isBalancedPassword(String Password1) {
            Stack<Character> stack = new Stack<>();
            // In this for loop we push all brackets to the stack
            for (int i = 0; i < password1.length(); i++) {
                if (password1.charAt(i) == '{' || password1.charAt(i) == '[' || password1.charAt(i) == '('
                        || password1.charAt(i) == '}' || password1.charAt(i) == ']' || password1.charAt(i) == ')') {
                    stack.push(password1.charAt(i));
                }
            }
            /*
             * In this while loop we check each element in the stack first and last or first
             * and second element
             * of the stack if they are match we remove that elements(pair of brackets, open
             * and closed)
             * from the stack otherwise returns false and prints the error message
             */
            while (stack.size() > 0) {

                if (stack.elementAt(0) == '{') {
                    if (stack.lastElement() == '}') {
                        stack.remove(stack.firstElement());
                        stack.remove(stack.lastElement());
                    } else if (stack.elementAt(1) == '}') {
                        stack.remove(stack.firstElement());
                        stack.remove(stack.firstElement());
                    } else {
                        System.out.println("The password1 is invalid. It should be balanced.");
                        return false;
                    }
                } else if (stack.elementAt(0) == '[') {
                    if (stack.lastElement() == ']') {
                        stack.remove(stack.firstElement());
                        stack.remove(stack.lastElement());
                    } else if (stack.elementAt(1) == ']') {
                        stack.remove(stack.firstElement());
                        stack.remove(stack.firstElement());
                    } else {
                        System.out.println("The password1 is invalid. It should be balanced.");
                        return false;
                    }
                } else if (stack.elementAt(0) == '(') {
                    if (stack.lastElement() == ')') {
                        stack.remove(stack.firstElement());
                        stack.remove(stack.lastElement());
                    } else if (stack.elementAt(1) == ')') {
                        stack.remove(stack.firstElement());
                        stack.remove(stack.firstElement());
                    } else {
                        System.out.println("The password1 is invalid. It should be balanced.");
                        return false;
                    }
                } else {
                    System.out.println("The password1 is invalid. It should be balanced.");
                    return false;
                }
            }
            /* If we successfully get out from the loop method returns true */
            return true;

        }

        static int odd = 0;
        static int[] count = new int[26];

        /**
         * This is a helper function for isPalindromePossible method. It uses count
         * array to check array indexes of each letter in the
         * alphabet to count recurrence of the odd number of letters.
         * 
         * @return odd numbered letters
         */
        public int checkOdd() {
            for (int i = 0; i < 26; i++) {
                if (count[i] % 2 != 0) {
                    odd++;
                }
            }
            return odd;
        }

        /**
         * This recursive method increments every character's index by one and checks
         * whether an odd numbered characters being less than 1.
         * 
         * @param password1
         * @return true if odd numbered letters is less than 1, if it is more
         *         than 1 than it returns false and prints the error message
         */
        public boolean isPalindromePossible(String password1) {
            if (password1.length() == 0) {
                int a = checkOdd(); // Using checkOdd method to check whether an odd numbered of characters being less
                                    // than 1.
                if (a > 1) {
                    System.out.println(
                            "The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
                    return false;
                } else
                    return true;
            }
            count[password1.charAt(0) - 'a']++; // Incrementing every character's index by one
            String restString = password1.substring(1);
            return isPalindromePossible(restString);
        }
    }

    public static class Password2 {
        private int password2;

        public Password2(int p2) {
            this.password2 = p2;
        }

        /**
         * Get method for password2
         * 
         * @return password2
         */
        public int getPassword2() {
            return password2;

        }

        int[] denominations = { 4, 17, 29 };

        /**
         * This method checks whether it is possible to get the password2 by the
         * denominations.
         * 
         * @param password2
         * @param denominations
         * @return true if it is possible to get the password2 by the denominations
         *         otherwise returns false
         */
        public boolean isExactDivison(int password2, int[] denominations) {
            if (password2 == 0) {
                return true;
            }
            if (password2 < 0) {
                return false;
            }
            boolean isExact = false;
            for (int j = 0; j < denominations.length; j++) {
                // If password2 is less than the denomination we continue to the next
                // denomination for simplicity of recursion
                if (password2 - denominations[j] < 0) {
                    isExact = isExact || false;
                    continue;
                }
                isExact = isExact || isExactDivison(password2 - denominations[j], denominations);
            }
            return isExact;
        }
    }

    public static void main(String[] args) {

        Username u = new Username("sibelgulmez");
        Password1 p = new Password1("[rac()ecar]");
        Password2 p2 = new Password2(74);

        Username u2 = new Username("\"");
        Password1 p1_2 = new Password1("[rac()ecar]");
        Password2 p2_2 = new Password2(74);

        Username u3 = new Username("sibel1");
        Password1 p1_3 = new Password1("[rac()ecar]");
        Password2 p2_3 = new Password2(74);

        Username u4 = new Username("sibel");
        Password1 p1_4 = new Password1("pass[]");
        Password2 p2_4 = new Password2(74);

        Username u5 = new Username("sibel");
        Password1 p1_5 = new Password1("abcdabcd");
        Password2 p2_5 = new Password2(74);

        Username u6 = new Username("sibel");
        Password1 p1_6 = new Password1("[[[[]]]]");
        Password2 p2_6 = new Password2(74);

        Username u7 = new Username("sibel");
        Password1 p1_7 = new Password1("[no](no)");
        Password2 p2_7 = new Password2(74);

        Username u8 = new Username("sibel");
        Password1 p1_8 = new Password1("[rac()ecar]]");
        Password2 p2_8 = new Password2(74);

        Username u9 = new Username("sibel");
        Password1 p1_9 = new Password1("[rac()ecars]");
        Password2 p2_9 = new Password2(74);

        Username u10 = new Username("sibel");
        Password1 p1_10 = new Password1("[rac()ecar]");
        Password2 p2_10 = new Password2(5);

        Username u11 = new Username("sibel");
        Password1 p1_11 = new Password1("[rac()ecar]");
        Password2 p2_11 = new Password2(35);

        Test1(u, p, p2);
        Test2(u2, p1_2, p2_2);
        Test3(u3, p1_3, p2_3);
        Test4(u4, p1_4, p2_4);
        Test5(u5, p1_5, p2_5);
        Test6(u6, p1_6, p2_6);
        Test7(u7, p1_7, p2_7);
        Test8(u8, p1_8, p2_8);
        Test9(u9, p1_9, p2_9);
        Test10(u10, p1_10, p2_10);
        Test11(u11, p1_11, p2_11);
    }

    /**
     * Test1
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test1(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test1---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test2
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test2(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test2---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test3
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test3(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test3---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test4
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test4(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test4---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test5
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test5(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test5---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test6
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test6(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test6---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test7
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test7(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test7---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test8
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test8(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test8---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test9
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test9(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test9---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test10
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test10(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test10---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

    /**
     * Test11
     * 
     * @param s1
     * @param p1
     * @param p2
     */
    public static void Test11(Username s1, Password1 p1, Password2 p2) {
        System.out.println("---Test11---");
        if (p1.getPassword1().length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return;
        } else if (!p1.isLetterContainPassword1()) {
            System.out.println("The password1 is invalid. It should have letters too.");
        } else if (!p1.isBracketPassword1()) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return;
        } else if (p2.getPassword2() < 10 || p2.getPassword2() > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
        } else {
            boolean n = s1.checkIfValidUsername(s1.getUsername());
            if (n == false)
                return;
            boolean p = p1.containsUserNameSpirit(s1.getUsername(), p1.removeBrackets(p1.getPassword1()));
            if (p == false)
                return;
            boolean b = p1.isBalancedPassword(p1.getPassword1());
            if (b == false)
                return;
            boolean palin = p1.isPalindromePossible(p1.removeBrackets(p1.getPassword1()));
            if (palin == false)
                return;
            boolean div = p2.isExactDivison(p2.getPassword2(), p2.denominations);
            if (div == false)
                System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            /* System.out.println(div); */
            if (b && n && p && palin && div) {
                System.out.println("The username and passwords are valid. The door is opening, please wait..");
            }
        }
    }

}
