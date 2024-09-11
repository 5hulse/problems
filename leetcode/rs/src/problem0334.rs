pub fn increasing_triple(nums: Vec<i32>) -> bool {
    let mut low = i32::MAX;
    let mut high = i32::MAX;
    for num in nums {
        if low > num {
            low = num;
        }

        if high > num && low != num {
            high = num;
        }

        if high < num {
            return true;
        }
    }
    false
}

#[cfg(test)]
pub mod tests {
    use crate::problem0334::*;

    #[test]
    pub fn test1() {
        assert_eq!(increasing_triple(vec![1, 2, 3, 4, 5]), true);
    }

    #[test]
    pub fn test2() {
        assert_eq!(increasing_triple(vec![5, 4, 3, 2, 1]), false);
    }

    #[test]
    pub fn test3() {
        assert_eq!(increasing_triple(vec![2, 1, 5, 0, 4, 6]), true);
    }

    #[test]
    pub fn test4() {
        assert_eq!(increasing_triple(vec![5, 1, 6]), false);
    }

    #[test]
    pub fn test5() {
        assert_eq!(increasing_triple(vec![20, 100, 10, 12, 5, 13]), true);
    }

    #[test]
    pub fn test6() {
        assert_eq!(increasing_triple(vec![1, 5, 0, 4, 1, 3]), true);
    }

    #[test]
    pub fn test7() {
        assert_eq!(increasing_triple(vec![4, 6, 3, 4, 5]), true);
    }

    #[test]
    pub fn test8() {
        let mut input: Vec<i32> = vec![0; 10];
        input[0] = 1;
        input[5] = -1;
        input[9] = 1_000_000_000;
        assert_eq!(increasing_triple(input), true);
    }

    #[test]
    pub fn test9() {
        assert_eq!(increasing_triple(vec![1, 2, 1, 2, 1, 2, 1, 2]), false);
    }
}
