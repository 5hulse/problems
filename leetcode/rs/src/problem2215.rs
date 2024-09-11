use std::collections::HashSet;

pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
    let nums1_set: HashSet<i32> = HashSet::from_iter(nums1.into_iter());
    let nums2_set: HashSet<i32> = HashSet::from_iter(nums2.into_iter());
    vec![
        nums1_set.difference(&nums2_set).cloned().collect(),
        nums2_set.difference(&nums1_set).cloned().collect(),
    ]
}

#[cfg(test)]
pub mod tests {
    use crate::problem2215::*;
    use crate::util::sort_vec_vec_elems;

    #[test]
    pub fn test1() {
        let mut result = find_difference(vec![1, 2, 3], vec![2, 4, 6]);
        sort_vec_vec_elems(&mut result);
        assert_eq!(result, vec![vec![1, 3], vec![4, 6]]);
    }

    #[test]
    pub fn test2() {
        let mut result = find_difference(vec![1, 2, 3, 3], vec![1, 1, 2, 2]);
        sort_vec_vec_elems(&mut result);
        assert_eq!(result, vec![vec![3], vec![]]);
    }
}
