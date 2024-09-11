pub fn move_zeroes(nums: &mut Vec<i32>) {
    let mut first_zero: Option<usize> = None;
    let mut num: i32;
    for i in 0..nums.len() {
        num = nums[i];
        if num == 0 {
            match first_zero {
                Some(_) => (),
                None => first_zero = Some(i),
            }
        } else {
            match first_zero {
                Some(j) => {
                    nums.swap(i, j);
                    first_zero = Some(j + 1);
                }
                None => (),
            }
        }
    }
}

#[cfg(test)]
pub mod tests {
    use crate::problem0283::*;

    #[test]
    pub fn test1() {
        let mut vec: Vec<i32> = vec![0, 1, 0, 3, 12];
        move_zeroes(&mut vec);
        assert_eq!(vec, vec![1, 3, 12, 0, 0]);
    }

    #[test]
    pub fn test2() {
        let mut vec: Vec<i32> = vec![0];
        move_zeroes(&mut vec);
        assert_eq!(vec, vec![0]);
    }
}
