pub fn max_vowels(s: String, k: i32) -> i32 {
    let s: &[u8] = s.as_bytes();
    let k_usize = k as usize;

    let mut curr: i32 = 0;
    let mut max: i32 = 0;

    for (i, &c) in s.iter().enumerate() {
        curr += is_vowel(c);

        if i < k_usize {
            if i == k_usize - 1 {
                max = curr;
            }
            continue;
        }

        curr -= is_vowel(s[i - k_usize]);

        if curr > max {
            max = curr;
        }
    }

    max
}

#[inline]
fn is_vowel(c: u8) -> i32 {
    (c == b'a' || c == b'e' || c == b'i' || c == b'o' || c == b'u') as i32
}

#[cfg(test)]
pub mod tests {
    use crate::problem1456::*;

    #[test]
    pub fn test1() {
        assert_eq!(max_vowels(String::from("abciiidef"), 3), 3);
    }

    #[test]
    pub fn test2() {
        assert_eq!(max_vowels(String::from("aeiou"), 2), 2);
    }

    #[test]
    pub fn test3() {
        assert_eq!(max_vowels(String::from("leetcode"), 3), 2);
    }

    #[test]
    pub fn test4() {
        assert_eq!(max_vowels(String::from("weallloveyou"), 7), 4);
    }

    #[test]
    pub fn test5() {
        assert_eq!(
            max_vowels(String::from("ibpbhixfiouhdljnjfflpapptrxgcomvnb"), 33),
            7
        );
    }
}
