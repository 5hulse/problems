use std::collections::HashMap;

pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map: HashMap<i32, usize> = HashMap::new();
    for (index, num) in nums.iter().enumerate() {
        if let Some(&loc) = map.get(&num) {
            return vec![loc as i32, index as i32];
        } else {
            map.insert(target - num, index);
        }
    }
    vec![]
}

#[cfg(test)]
pub mod tests {
    use crate::problem0001::*;

    #[test]
    pub fn test1() {
        assert_eq!(two_sum(vec![2, 7, 11, 15], 9), vec![0, 1]);
    }

    #[test]
    pub fn test2() {
        assert_eq!(two_sum(vec![3, 2, 4], 6), vec![1, 2]);
    }

    #[test]
    pub fn test3() {
        assert_eq!(two_sum(vec![3, 3], 6), vec![0, 1]);
    }
}
