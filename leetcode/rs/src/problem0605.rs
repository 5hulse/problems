pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
    if flowerbed == vec![1] {
        return n == 0;
    } else if flowerbed == vec![0] {
        return n <= 1;
    }

    let mut total: i32 = 0;
    let mut past_was_one: bool = flowerbed[0] == 1;
    let mut curr_is_one: bool = flowerbed[1] == 1;

    // Account for first element
    if !past_was_one && !curr_is_one {
        total = 1;
        past_was_one = true;
    }

    for i in 1..flowerbed.len() - 1 {
        if past_was_one {
            past_was_one = curr_is_one;
        } else {
            if curr_is_one {
                past_was_one = true;
            } else {
                if flowerbed[i + 1] == 0 {
                    // flowerbed[0] is a 0 is adjaceent to two 0s
                    // this will be planted i.e. converted to 1
                    // so it is marked as 1
                    past_was_one = true;
                    total += 1;
                }
            }
        }
        curr_is_one = flowerbed[i + 1] == 1;
    }

    // Account for the last element
    if !past_was_one && !curr_is_one {
        total += 1;
    }

    total >= n
}

#[cfg(test)]
pub mod tests {
    use crate::problem0605::*;

    #[test]
    pub fn test1() {
        assert_eq!(can_place_flowers(vec![1, 0, 0, 0, 1], 1), true);
    }

    #[test]
    pub fn test2() {
        assert_eq!(can_place_flowers(vec![1, 0, 0, 0, 1], 2), false);
    }

    // Below are edge cases that failed after initial submissions
    #[test]
    pub fn test3() {
        assert_eq!(can_place_flowers(vec![0, 0, 1, 0, 1], 1), true);
    }

    #[test]
    pub fn test4() {
        assert_eq!(can_place_flowers(vec![1], 0), true);
    }

    #[test]
    pub fn test5() {
        assert_eq!(can_place_flowers(vec![0, 0], 2), false);
    }
}
