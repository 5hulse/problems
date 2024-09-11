use std::collections::{HashMap, HashSet};

pub fn unique_occurrences(arr: Vec<i32>) -> bool {
    let mut occurences: HashMap<i32, i32> = HashMap::new();
    for num in arr {
        match occurences.get_mut(&num) {
            None => {
                occurences.insert(num, 1);
            }
            Some(count) => *count += 1,
        }
    }

    occurences.len() == occurences.into_values().collect::<HashSet<i32>>().len()
}

#[cfg(test)]
pub mod tests {
    use crate::problem1207::*;

    #[test]
    pub fn test1() {
        assert_eq!(unique_occurrences(vec![1, 2, 2, 1, 1, 3]), true);
    }

    #[test]
    pub fn test2() {
        assert_eq!(unique_occurrences(vec![1, 2]), false);
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            unique_occurrences(vec![-3, 0, 1, -3, 1, 1, 1, -3, 10, 0]),
            true
        );
    }
}
