Problem Description

Input Format. The first line contains an integer 𝑛. The second line contains integers 𝑣1, 𝑣2, . . . , 𝑣𝑛 separated
by spaces.

Constraints. 1 ≤ 𝑛 ≤ 20, 1 ≤ 𝑣𝑖 ≤ 30 for all 𝑖.

Output Format. Output 1, if it possible to partition 𝑣1, 𝑣2, . . . , 𝑣𝑛 into three subsets with equal sums, and
0 otherwise.

Sample 1.
Input:
4
3 3 3 3
Output:
0
Sample 2.

Input:
1
40
Output:
0

Sample 3.
Input:
11
17 59 34 57 17 23 67 1 18 2 59
Output:
1
34 + 67 + 17 = 23 + 59 + 1 + 17 + 18 = 59 + 2 + 57.
