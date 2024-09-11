pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
    // number of values is fixed, so just need to keep track of max sum, and divide by k at the end
    let k_usize = k as usize;

    let mut max_sum: i32 = 0;
    for i in 0..k_usize {
        max_sum += nums[i];
    }

    if nums.len() > k_usize {
        let mut curr_sum: i32 = max_sum;
        for left in 1..nums.len() - k_usize + 1 {
            curr_sum -= nums[left - 1];
            curr_sum += nums[left + k_usize - 1];
            if curr_sum > max_sum {
                max_sum = curr_sum;
            }
        }
    }

    (max_sum as f64) / (k as f64)
}

#[cfg(test)]
pub mod tests {
    use crate::problem0643::*;

    #[test]
    pub fn test1() {
        assert_eq!(find_max_average(vec![1, 12, -5, -6, 50, 3], 4), 12.75);
    }

    #[test]
    pub fn test2() {
        assert_eq!(find_max_average(vec![5], 1), 5.0);
    }
}
