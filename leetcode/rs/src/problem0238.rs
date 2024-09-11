pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
    let mut left_prod: Vec<i32> = vec![1; nums.len()];
    left_prod[0] = 1;
    let mut right_prod: Vec<i32> = vec![1; nums.len()];
    right_prod[nums.len() - 1] = 1;

    // iterate up to the last element
    // Filter behaves like skip from the back
    for (i, num) in nums
        .iter()
        .enumerate()
        .filter(|(i, _)| *i != nums.len() - 1)
    {
        left_prod[i + 1] = num * left_prod[i];
    }

    for (i, num) in nums.iter().enumerate().rev().filter(|(i, _)| *i != 0) {
        right_prod[i - 1] = num * right_prod[i];
    }

    let mut result: Vec<i32> = Vec::with_capacity(nums.len());
    for (left, right) in left_prod.iter().zip(right_prod.iter()) {
        result.push(left * right);
    }
    result
}

#[cfg(test)]
pub mod tests {
    use crate::problem0238::*;

    #[test]
    pub fn test1() {
        assert_eq!(product_except_self(vec![1, 2, 3, 4]), vec![24, 12, 8, 6]);
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            product_except_self(vec![-1, 1, 0, -3, 3]),
            vec![0, 0, 9, 0, 0]
        );
    }
}
