from typing import List


def two_sum(nums: List[int], target: int) -> List[int]:
    hashmap = {}
    for i, num in enumerate(nums):
        if (j := hashmap.get(num, None)) is not None:
            return [j, i]
        hashmap[target - num] = i
    return []
