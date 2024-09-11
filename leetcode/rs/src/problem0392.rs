pub fn is_subsequence(s: String, t: String) -> bool {
    if s.len() == 0 {
        return true;
    }

    let s_len: usize = s.len();
    let mut s_chars = s.chars();
    let mut target: char = s_chars.next().unwrap();
    let mut count: usize = 0;

    for c in t.chars() {
        if c == target {
            count += 1;
            if count == s_len {
                return true;
            }
            target = s_chars.next().unwrap();
        }
    }
    false
}

#[cfg(test)]
pub mod tests {
    use crate::problem0392::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            is_subsequence(String::from("abc"), String::from("ahbgdc")),
            true
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            is_subsequence(String::from("axc"), String::from("ahbgdc")),
            false
        );
    }
}
