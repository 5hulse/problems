from typing import List, Set, Tuple


def four_sum(nums: List[int], target: int) -> Set[Tuple[int, int, int, int]]:
    nums = sorted(nums)
    result = set()
    for i in range(len(nums) - 3):
        for j in range(i + 1, len(nums) - 2):
            if i == 0 and j == 1:
                pass
            else:
                if nums[i - 1] == nums[i] and nums[j - 1] == nums[j]:
                    continue
            k = j + 1
            l = len(nums) - 1
            while k < l:
                sum_ = nums[i] + nums[j] + nums[k] + nums[l]
                if sum_ == target:
                    result.add((nums[i], nums[j], nums[k], nums[l]))
                    k += 1
                    l -= 1
                elif sum_ < target:
                    k += 1
                else:
                    l -= 1

    return result
