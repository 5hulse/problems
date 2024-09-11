def length_of_longest_substring(s: str) -> int:
    left = 0
    right = 0
    result = 0
    curr_chars = set()

    for right in range(len(s)):
        while (s[right] in curr_chars):
            curr_chars.remove(s[left])
            left += 1

        curr_chars.add(s[right])
        result = max(result, right - left + 1)

    return result
