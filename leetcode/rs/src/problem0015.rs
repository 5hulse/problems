use std::collections::HashSet;

pub fn three_sum(mut nums: Vec<i32>) -> Vec<Vec<i32>> {
    nums.sort();
    let mut result: HashSet<Vec<i32>> = HashSet::new();
    let mut sum: i32;

    let mut j: usize;
    let mut k: usize;
    for i in 0..nums.len() - 2 {
        if i > 0 && nums[i - 1] == nums[i] {
            continue;
        }

        j = i + 1;
        k = nums.len() - 1;

        while j < k {
            sum = nums[i] + nums[j] + nums[k];
            if sum == 0 {
                result.insert(vec![nums[i], nums[j], nums[k]]);
            }
            if sum <= 0 {
                j += 1;
            } else {
                k -= 1;
            }
        }
    }
    result.into_iter().collect::<Vec<Vec<i32>>>()
}

#[cfg(test)]
pub mod tests {
    use crate::problem0015::*;
    use crate::util::sort_vec_vec_deep;

    #[test]
    pub fn test1() {
        let mut result = three_sum(vec![-1, 0, 1, 2, -1, -4]);
        sort_vec_vec_deep(&mut result);
        assert_eq!(result, vec![vec![-1, -1, 2], vec![-1, 0, 1]]);
    }

    #[test]
    pub fn test2() {
        let mut result = three_sum(vec![0, 1, 1]);
        sort_vec_vec_deep(&mut result);
        assert_eq!(result, Vec::<Vec<i32>>::new());
    }

    #[test]
    pub fn test3() {
        let mut result = three_sum(vec![0, 0, 0]);
        sort_vec_vec_deep(&mut result);
        assert_eq!(result, vec![vec![0, 0, 0]]);
    }
}
