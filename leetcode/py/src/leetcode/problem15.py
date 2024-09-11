from typing import List


def three_sum(nums: List[int]) -> List[List[int]]:
    nums = sorted(nums)
    result = set()
    for i in range(len(nums) - 2):
        # If two adjacent values are the same, no point if re-checking
        if i > 0 and nums[i - 1] == nums[i]:
            continue

        j = i + 1
        k = len(nums) - 1
        while k - j > 0:
            sum_ = nums[i] + nums[j] + nums[k]
            if sum_ == 0:
                result.add((nums[i], nums[j], nums[k]))
            if sum_ <= 0:
                j += 1
            else:
                k -= 1

    return result
