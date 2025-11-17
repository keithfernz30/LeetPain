class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        last_occ = {c: i for i, c in enumerate(s)}
        stack = []
        visited = set()

        for i, c in enumerate(s):
            # skip if already in result
            if c in visited:
                continue

            # maintain lexicographically smallest order
            while stack and c < stack[-1] and last_occ[stack[-1]] > i:
                removed = stack.pop()
                visited.remove(removed)

            stack.append(c)
            visited.add(c)

        return "".join(stack)
