Problem Description

Task. Given an integer 𝑛, compute the minimum number of operations needed to obtain the number 𝑛
starting from the number 1.

Input Format. The input consists of a single integer 1 ≤ 𝑛 ≤ 106.

Output Format. In the first line, output the minimum number 𝑘 of operations needed to get 𝑛 from 1.
In the second line output a sequence of intermediate numbers. That is, the second line should contain
positive integers 𝑎0, 𝑎2, . . . , 𝑎𝑘−1 such that 𝑎0 = 1, 𝑎𝑘−1 = 𝑛 and for all 0 ≤ 𝑖 < 𝑘 − 1, 𝑎𝑖+1 is equal to
either 𝑎𝑖 + 1, 2𝑎𝑖, or 3𝑎𝑖. If there are many such sequences, output any one of them.

Sample 1.
Input:
1
Output:
0
1

Sample 2.
Input:
5
Output:
3
1 2 4 5
Here, we first multiply 1 by 2 two times and then add 1. Another possibility is to first multiply by 3
and then add 1 two times. Hence “1 3 4 5” is also a valid output in this case.
