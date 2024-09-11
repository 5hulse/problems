use std::cmp;
use std::collections::HashSet;

pub fn length_of_longest_substring(s: String) -> i32 {
    let mut set: HashSet<char> = HashSet::new();
    let mut left: usize = 0;
    let mut right: usize = 0;
    let mut result: usize = 0;
    let mut curr_str: Vec<char> = Vec::new();

    for c in s.chars() {
        if set.contains(&c) {
            loop {
                let pop_c: char = curr_str.remove(0);
                set.remove(&pop_c);
                left += 1;
                if pop_c == c {
                    break;
                }
            }
        } else {
            result = cmp::max(right - left + 1, result);
        }
        curr_str.push(c);
        set.insert(c);
        right += 1;
    }
    cmp::max(right - left, result) as i32
}

#[cfg(test)]
pub mod tests {
    use crate::problem0003::*;

    #[test]
    pub fn test1() {
        assert_eq!(length_of_longest_substring(String::from("abcabcbb")), 3);
    }

    #[test]
    pub fn test2() {
        assert_eq!(length_of_longest_substring(String::from("bbbbb")), 1);
    }

    #[test]
    pub fn test3() {
        assert_eq!(length_of_longest_substring(String::from("pwwkew")), 3);
    }

    #[test]
    pub fn test4() {
        assert_eq!(length_of_longest_substring(String::from("dvdf")), 3);
    }
}
