# BrainFuckInterpreter

[![Version](https://img.shields.io/badge/version-v1.0-informational)](https://img.shields.io/badge/version-v1.0-informational)

A BrainFuck interpreter written in java

## What is BrainFuck?

<p>Brainfuck is an esoteric programming language created in 1993 by Urban Müller, and is notable for its extreme minimalism.</p>
<p>The language consists of only eight simple commands and an instruction pointer.</p>

## BrainFuck Commands
```brainfuck
+------+----------------------------------------------------------------------+
| char | definition                                                           |
+------+----------------------------------------------------------------------+
|  >   | Move the pointer to the right                                        |
|  <   | Move the pointer to the left                                         |
|  +   | Increment the memory cell under the pointer                          |
|  -   | Decrement the memory cell under the pointer                          |
|  .   | Output the character signified by the cell at the pointer            |
|  ,   | Input a character and store it in the cell at the pointer            |
|  [   | Jump past the matching ] if the cell under the pointer is 0          |
|  ]   | Jump back to the matching [ if the cell under the pointer is nonzero |
+------+----------------------------------------------------------------------+
```

## Usage
```css
Java BrainFuck Interpreter v1.0
-------------------------------
Enter File Name:
$> hello_world.b
Output: 
Hello World!
```

<b>Example:</b>
Here is an example of "Hello World" in BrainFuck:
```brainfuck
 1 +++++ +++               Set Cell #0 to 8
 2 [
 3     >++++               Add 4 to Cell #1; this will always set Cell #1 to 4
 4     [                   as the cell will be cleared by the loop
 5         >++             Add 4*2 to Cell #2
 6         >+++            Add 4*3 to Cell #3
 7         >+++            Add 4*3 to Cell #4
 8         >+              Add 4 to Cell #5
 9         <<<<-           Decrement the loop counter in Cell #1
10     ]                   Loop till Cell #1 is zero
11     >+                  Add 1 to Cell #2
12     >+                  Add 1 to Cell #3
13     >-                  Subtract 1 from Cell #4
14     >>+                 Add 1 to Cell #6
15     [<]                 Move back to the first zero cell you find; this will
16                         be Cell #1 which was cleared by the previous loop
17     <-                  Decrement the loop Counter in Cell #0
18 ]                       Loop till Cell #0 is zero
19 
20 The result of this is:
21 Cell No :   0   1   2   3   4   5   6
22 Contents:   0   0  72 104  88  32   8
23 Pointer :   ^
24 
25 >>.                     Cell #2 has value 72 which is 'H'
26 >---.                   Subtract 3 from Cell #3 to get 101 which is 'e'
27 +++++ ++..+++.          Likewise for 'llo' from Cell #3
28 >>.                     Cell #5 is 32 for the space
29 <-.                     Subtract 1 from Cell #4 for 87 to give a 'W'
30 <.                      Cell #3 was set to 'o' from the end of 'Hello'
31 +++.----- -.----- ---.  Cell #3 for 'rl' and 'd'
32 >>+.                    Add 1 to Cell #5 gives us an exclamation point
33 >++.                    And finally a newline from Cell #6
```

Here is the same program in minimized form:
```brainfuck
++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>
```

## Author

Chad Humphries - <a href="https://grunclepug.com/" title="Go to my website">My Website</a>
<p>Check out some of my other projects: <a href="https://github.com/GrunclePug?tab=repositories" title="Other projects of mine">here</a>
