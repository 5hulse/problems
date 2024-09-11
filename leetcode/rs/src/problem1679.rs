pub fn max_operations(mut nums: Vec<i32>, k: i32) -> i32 {
    nums.sort();
    // can remove any values greater that k as all values in nums are >0.
    let mut trunc: usize = nums.len();
    while nums[trunc - 1] >= k {
        trunc -= 1;
        if trunc == 1 {
            // all values in nums >= k: no chance of pair summing to k existing
            return 0;
        }
    }
    nums.truncate(trunc);
    println!("nums: {:?}", nums);

    let mut left: usize = 0;
    let mut right: usize = nums.len() - 1;
    let mut sum: i32;
    let mut ops: i32 = 0;

    while left < right {
        sum = nums[left] + nums[right];
        if sum == k {
            ops += 1;
            left += 1;
            right -= 1;
        } else if sum < k {
            left += 1;
        } else {
            right -= 1;
        }
    }
    ops
}

#[cfg(test)]
pub mod tests {
    use crate::problem1679::*;

    #[test]
    pub fn test1() {
        assert_eq!(max_operations(vec![1, 2, 3, 7], 5), 1);
    }

    #[test]
    pub fn test2() {
        assert_eq!(max_operations(vec![3, 1, 3, 4, 3], 6), 1);
    }
}
