use std::cmp::Ordering;

pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
    let mut result: Vec<i32> = Vec::new();
    for asteroid in asteroids {
        loop {
            match peek(&result) {
                None => {
                    result.push(asteroid);
                    break;
                }
                Some(&top) => {
                    if top > 0 && asteroid < 0 {
                        // opposite directions
                        match asteroid.abs().cmp(&top.abs()) {
                            Ordering::Less => {
                                break;
                            }
                            Ordering::Greater => {
                                result.pop();
                            }
                            Ordering::Equal => {
                                result.pop();
                                break;
                            }
                        }
                    } else {
                        result.push(asteroid);
                        break;
                    }
                }
            }
        }
    }
    result
}

fn peek(stack: &Vec<i32>) -> Option<&i32> {
    match stack.len() {
        0 => None,
        n => Some(&stack[n - 1]),
    }
}

#[cfg(test)]
pub mod tests {
    use crate::problem0735::*;

    #[test]
    pub fn test1() {
        assert_eq!(asteroid_collision(vec![5, 10, -5]), vec![5, 10]);
    }

    #[test]
    pub fn test2() {
        assert_eq!(asteroid_collision(vec![8, -8]), vec![]);
    }

    #[test]
    pub fn test3() {
        assert_eq!(asteroid_collision(vec![10, 2, -5]), vec![10]);
    }

    #[test]
    pub fn test4() {
        assert_eq!(asteroid_collision(vec![-2, -1, 1, 2]), vec![-2, -1, 1, 2]);
    }
}
