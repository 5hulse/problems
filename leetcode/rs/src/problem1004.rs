pub fn longest_ones(nums: Vec<i32>, k: i32) -> i32 {
    let mut n_zeros_used: i32 = 0;
    let mut left: usize = 0;
    let mut max: i32 = 0;
    let mut curr: i32;
    let mut is_zero: bool;

    for (right, &num) in nums.iter().enumerate() {
        is_zero = num == 0;
        if is_zero {
            if n_zeros_used < k {
                n_zeros_used += 1;
            } else {
                while nums[left] != 0 {
                    left += 1;
                }
                left += 1;
            }
        }

        curr = right as i32 - left as i32 + 1;
        if curr > max {
            max = curr;
        }
    }
    max
}

#[cfg(test)]
pub mod tests {
    use crate::problem1004::*;

    #[test]
    pub fn test1() {
        assert_eq!(longest_ones(vec![1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], 2), 6);
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            longest_ones(
                vec![0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1],
                3
            ),
            10
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            longest_ones(
                vec![0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1],
                0
            ),
            4
        );
    }
}
