# Family Tree Prolog Program

## Getting Started

To run this Prolog program and explore the family tree, follow the steps below:

1. Go to the [SWI-Prolog PPA Repository](https://www.swi-prolog.org/build/PPA.txt) site.

2. Follow the installation instructions provided on the site based on your operating system.

3. After successful installation, open your terminal.

4. Type `swipl` in the terminal and press Enter to launch the SWI-Prolog interactive shell.

## Compiling and Running the Program

1. Save your Prolog code in a file, for example, `family_tree.pl`.

2. In the terminal, navigate to the directory where the `family_tree.pl` file is located.

3. To compile the code, type `[family_tree].` in the Prolog shell and press Enter. Make sure to replace `family_tree` with the actual name of your Prolog file.

4. Once the code is compiled without any errors, you can start querying the family tree.

## Running Queries and Viewing Output

With the Prolog code compiled and loaded, you can now query the family tree to get various information about relationships.

For example, you can run queries like:

- `parent(X, Y).` to find the parent of a person.
- `sibling(X, Y).` to find if two people are siblings.
- `grandparent(X, Y).` to find the grandparents of a person.

Replace `X` and `Y` with specific names to get relevant results.

## Sample Output

For example, the output for the query `parent(john, mary).` would be:

```
true
```

This indicates that John is the parent of Mary, based on the family tree defined in the `family_tree.pl` file.

Feel free to explore and modify the Prolog code to define your own family tree and run different queries. Enjoy!
