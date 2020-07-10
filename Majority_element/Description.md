Problem Description

Task. The goal in this code problem is to check whether an input sequence contains a majority element.
Input Format. The first line contains an integer 𝑛, the next one contains a sequence of 𝑛 non-negative
integers 𝑎0, 𝑎1, . . . , 𝑎𝑛−1.
Constraints. 1 ≤ 𝑛 ≤ 105; 0 ≤ 𝑎𝑖 ≤ 109 for all 0 ≤ 𝑖 < 𝑛.

Output Format. Output 1 if the sequence contains an element that appears strictly more than 𝑛/2 times,
and 0 otherwise.

Sample 1.
Input:
5
2 3 9 2 2
Output:
1
2 is the majority element.

Sample 2.
Input:
4
1 2 3 4
Output:
0
There is no majority element in this sequence.
