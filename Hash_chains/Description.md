Problem Description

Task. In this task your goal is to implement a hash table with lists chaining. You are already given the
number of buckets 𝑚 and the hash function. It is a polynomial hash function
ℎ(𝑆) =
⎛
⎝
|𝑆Σ︁|−1
𝑖=0
𝑆[𝑖]𝑥𝑖 mod 𝑝
⎞
⎠ mod 𝑚,

where 𝑆[𝑖] is the ASCII code of the 𝑖-th symbol of 𝑆, 𝑝 = 1 000 000 007 and 𝑥 = 263. Your program
should support the following kinds of queries:
∙ add string — insert string into the table. If there is already such string in the hash table, then
just ignore the query.
∙ del string — remove string from the table. If there is no such string in the hash table, then
just ignore the query.
∙ find string — output “yes" or “no" (without quotes) depending on whether the table contains
string or not.
∙ check 𝑖 — output the content of the 𝑖-th list in the table. Use spaces to separate the elements of
the list. If 𝑖-th list is empty, output a blank line.
When inserting a new string into a hash chain, you must insert it in the beginning of the chain.
Input Format. There is a single integer 𝑚 in the first line — the number of buckets you should have. The
next line contains the number of queries 𝑁. It’s followed by 𝑁 lines, each of them contains one query
in the format described above.

Constraints. 1 ≤ 𝑁 ≤ 105; 𝑁
5 ≤ 𝑚 ≤ 𝑁. All the strings consist of latin letters. Each of them is non-empty
and has length at most 15.

Output Format. Print the result of each of the find and check queries, one result per line, in the same
order as these queries are given in the input.

Sample 1.
Input:
5
12
add world
add HellO
check 4
find World
find world
del world
check 4
del HellO
add luck
add GooD
check 2
del good
Output:
HellO world
no
yes
HellO
GooD luck
