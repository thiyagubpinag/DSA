package dp;


class PyramidProgram
{

    // function to print spaces
    static void print_space(int space)
    {
        // base case
        if (space == 0)
            return;
        System.out.print(" ");

        // recursively calling print_space()
        print_space(space - 1);
    }

    // function to print asterisks
    static void print_asterisk(int asterisk)
    {
        // base case
        if (asterisk == 0)
            return;
        System.out.print("* ");

        // recursively calling asterisk()
        print_asterisk(asterisk - 1);
    }

    // function to print the pattern
    static void pattern(int n, int num)
    {
        // base case
        if (n == 0 || n>num)
            return;
        print_space(n - 1);
        print_asterisk(num - n + 1);
        System.out.println("");

        // recursively calling pattern()
        pattern(n - 1, num);

        print_space(n);
        print_asterisk(num-n);
        System.out.println("");


    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 5;
        pattern(n, n);

        //patternReverse(n,n);
    }

    private static void patternReverse(int n, int num) {
        // base case
        if (n == 0)
            return;
        print_space(num - n + 1);
        print_asterisk(n-1);
        System.out.println("");

        // recursively calling pattern()
        patternReverse(n - 1, num);
    }
}

// This code is contributed by 29AjayKumar
