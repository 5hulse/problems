use std::collections::HashSet;

pub fn four_sum(mut nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
    nums.sort();
    if nums.len() < 4 {
        return Vec::<Vec<i32>>::new();
    }

    let mut result: HashSet<Vec<i32>> = HashSet::new();
    let mut sum: i64;

    let mut k: usize;
    let mut l: usize;
    for i in 0..nums.len() - 3 {
        for j in i + 1..nums.len() - 2 {
            if i > 0 && j > 1 && nums[i - 1] == nums[i] && nums[j - 1] == nums[j] {
                continue;
            }

            k = j + 1;
            l = nums.len() - 1;

            while k < l {
                sum = (nums[i] as i64) + (nums[j] as i64) + (nums[k] as i64) + (nums[l] as i64);
                if sum == target as i64 {
                    result.insert(vec![nums[i], nums[j], nums[k], nums[l]]);
                }
                if sum <= target as i64 {
                    k += 1;
                } else {
                    l -= 1;
                }
            }
        }
    }
    result.into_iter().collect::<Vec<Vec<i32>>>()
}

#[cfg(test)]
pub mod tests {
    use crate::problem0018::*;
    use crate::util::sort_vec_vec_deep;

    #[test]
    pub fn test1() {
        let mut result = four_sum(vec![1, 0, -1, 0, -2, 2], 0);
        sort_vec_vec_deep(&mut result);
        assert_eq!(
            result,
            vec![vec![-2, -1, 1, 2], vec![-2, 0, 0, 2], vec![-1, 0, 0, 1]]
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(four_sum(vec![2, 2, 2, 2, 2], 8), vec![vec![2, 2, 2, 2]]);
    }

    #[test]
    pub fn test3() {
        assert_eq!(four_sum(vec![0], 0), Vec::<Vec<i32>>::new())
    }

    #[test]
    pub fn test4() {
        // The bastards included an example where i32 aritmetic overflows
        assert_eq!(
            four_sum(
                vec![1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000],
                -294967296
            ),
            Vec::<Vec<i32>>::new()
        );
    }
}
