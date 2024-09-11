pub fn largest_altitude(gain: Vec<i32>) -> i32 {
    let mut curr: i32 = 0;
    let mut max: i32 = 0;
    for x in gain {
        curr += x;
        if curr > max {
            max = curr;
        }
    }
    max
}

#[cfg(test)]
pub mod tests {
    use crate::problem1732::*;

    #[test]
    pub fn test1() {
        assert_eq!(largest_altitude(vec![-5, 1, 5, 0, -7]), 1);
    }

    #[test]
    pub fn test2() {
        assert_eq!(largest_altitude(vec![-4, -3, -2, -1, 4, 3, 2]), 0);
    }
}
