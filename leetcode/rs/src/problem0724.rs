pub fn pivot_index(nums: Vec<i32>) -> i32 {
    let mut left: i32 = 0;
    let mut right: i32 = nums.iter().sum();
    for i in 0..nums.len() {
        right -= nums[i];
        if i != 0 {
            left += nums[i - 1];
        }
        if left == right {
            return i as i32;
        }
    }
    -1
}

#[cfg(test)]
pub mod tests {
    use crate::problem0724::*;

    #[test]
    pub fn test1() {
        assert_eq!(pivot_index(vec![1, 7, 3, 6, 5, 6]), 3);
    }

    #[test]
    pub fn test2() {
        assert_eq!(pivot_index(vec![1, 2, 3]), -1);
    }

    #[test]
    pub fn test3() {
        assert_eq!(pivot_index(vec![2, 1, -1]), 0);
    }
}
