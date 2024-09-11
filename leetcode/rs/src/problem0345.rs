use std::collections::HashSet;

pub fn reverse_vowels(s: String) -> String {
    let mut chars: Vec<u8> = Vec::from(s);
    let mut left: usize = 0;
    let mut right: usize = chars.len() - 1;
    let vowel_set: HashSet<u8> = HashSet::from([65, 69, 73, 79, 85, 97, 101, 105, 111, 117]);
    while left < right {
        match (
            vowel_set.contains(&chars[left]),
            vowel_set.contains(&chars[right]),
        ) {
            (true, true) => {
                (chars[left], chars[right]) = (chars[right], chars[left]);
                left += 1;
                right -= 1;
            }
            (false, true) => {
                left += 1;
            }
            _ => {
                right -= 1;
            }
        }
    }
    String::from_utf8(chars).expect("Invalid UTF-8")
}

#[cfg(test)]
pub mod tests {
    use crate::problem0345::*;

    #[test]
    pub fn test1() {
        assert_eq!(reverse_vowels(String::from("hello")), String::from("holle"));
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            reverse_vowels(String::from("leetcode")),
            String::from("leotcede")
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(reverse_vowels(String::from(" ")), String::from(" "));
    }

    #[test]
    pub fn test4() {
        assert_eq!(reverse_vowels(String::from("aA")), String::from("Aa"));
    }
}
