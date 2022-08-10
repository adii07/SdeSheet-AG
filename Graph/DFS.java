// DFS of a graph

/**
 * There are 2 possible ways, recursion and using a stack
 * In recursion, when calling the child node, make an recursive dfs call on the child till the last root node, then retrun the back
 * When using the stack, do the same as done with queue in bfs just add the right most child first and the left child last, as the stack removes the first added element at last.
*/