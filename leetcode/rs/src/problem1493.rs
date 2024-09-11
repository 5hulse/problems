pub fn longest_subarray(nums: Vec<i32>) -> i32 {
    let mut left: usize = 0;
    let mut hit_zero: bool = false;
    let mut curr: i32;
    let mut max: i32 = 0;

    for (right, &x) in nums.iter().enumerate() {
        if x == 0 {
            if !hit_zero {
                hit_zero = true;
            } else {
                while nums[left] != 0 {
                    left += 1;
                }
                left += 1;
            }
        }
        curr = right as i32 - left as i32;
        if curr > max {
            max = curr;
        }
    }
    max
}

#[cfg(test)]
pub mod tests {
    use crate::problem1493::*;

    #[test]
    pub fn test1() {
        assert_eq!(longest_subarray(vec![1, 1, 0, 1]), 3);
    }

    #[test]
    pub fn test2() {
        assert_eq!(longest_subarray(vec![0, 1, 1, 1, 0, 1, 1, 0, 1]), 5);
    }

    #[test]
    pub fn test3() {
        assert_eq!(longest_subarray(vec![1, 1, 1]), 2);
    }

    #[test]
    pub fn test4() {
        assert_eq!(longest_subarray(vec![0, 0, 0]), 0);
    }
}
