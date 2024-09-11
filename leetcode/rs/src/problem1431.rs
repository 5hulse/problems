pub fn kids_with_candies(candies: Vec<i32>, extra_candies: i32) -> Vec<bool> {
    let target: i32 = candies.iter().max().expect("Always at least 1 element") - extra_candies;
    let result: Vec<bool> = candies.iter().map(|&x| x >= target).collect();
    result
}

#[cfg(test)]
pub mod tests {
    use crate::problem1431::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            kids_with_candies(vec![2, 3, 5, 1, 3], 3),
            vec![true, true, true, false, true]
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            kids_with_candies(vec![4, 2, 1, 1, 2], 1),
            vec![true, false, false, false, false]
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            kids_with_candies(vec![12, 1, 12], 10),
            vec![true, false, true]
        );
    }
}
