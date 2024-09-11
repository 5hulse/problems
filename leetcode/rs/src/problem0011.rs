use std::cmp;

pub fn max_area(height: Vec<i32>) -> i32 {
    let mut left: usize = 0;
    let mut right: usize = height.len() - 1;
    let mut max: i32 = 0;

    while left < right {
        if height[left] <= height[right] {
            max = cmp::max(max, (right - left) as i32 * height[left]);
            left += 1;
        } else {
            max = cmp::max(max, (right - left) as i32 * height[right]);
            right -= 1;
        }
    }
    max
}

#[cfg(test)]
pub mod tests {
    use crate::problem0011::*;

    #[test]
    pub fn test1() {
        assert_eq!(max_area(vec![1, 8, 6, 2, 5, 4, 8, 3, 7]), 49);
    }

    #[test]
    pub fn test2() {
        assert_eq!(max_area(vec![1, 1]), 1);
    }
}
