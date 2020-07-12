Problem Description

Task. Your friend is making a text editor for programmers. He is currently working on a feature that will
find errors in the usage of different types of brackets. Code can contain any brackets from the set
[]{}(), where the opening brackets are [,{, and ( and the closing brackets corresponding to them
are ],}, and ).

Input Format. Input contains one string 𝑆 which consists of big and small latin letters, digits, punctuation
marks and brackets from the set []{}().

Constraints. The length of 𝑆 is at least 1 and at most 105.

Output Format. If the code in 𝑆 uses brackets correctly, output “Success" (without the quotes). Otherwise,
output the 1-based index of the first unmatched closing bracket, and if there are no unmatched closing
brackets, output the 1-based index of the first unmatched opening bracket.

Sample 1.
Input:
[]
Output:
Success
Explanation:
The brackets are used correctly: there is just one pair of brackets [ and ], they correspond to each
other, the left bracket [ goes before the right bracket ], and no two pairs of brackets intersect, because
there is just one pair of brackets.
