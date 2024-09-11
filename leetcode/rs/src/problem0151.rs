pub fn reverse_words(s: String) -> String {
    // No direct implementation of `VecDeque::from(String)`
    let mut s_vec: Vec<u8> = Vec::from(s);

    // Remove initial whitespace
    while s_vec[0] == 32 {
        s_vec.remove(0);
    }

    // Remove trailing whitespace
    while s_vec[s_vec.len() - 1] == 32 {
        s_vec.remove(s_vec.len() - 1);
    }

    // Reverse order of characters, and then flip each word in-place
    s_vec.reverse();

    let mut left: usize = 0;
    let mut right: usize = 0;

    loop {
        if s_vec[right] == 32 {
            s_vec[left..right].reverse();
            while s_vec[right + 1] == 32 {
                s_vec.remove(right + 1);
            }
            right += 1;
            left = right;
        } else if right == s_vec.len() - 1 {
            s_vec[left..right + 1].reverse();
            break;
        } else {
            right += 1;
        }
    }
    String::from_utf8(s_vec).expect("UTF-8 parsing error")
}

#[cfg(test)]
pub mod tests {
    use crate::problem0151::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            reverse_words(String::from("the sky is blue")),
            String::from("blue is sky the")
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            reverse_words(String::from("  hello world  ")),
            String::from("world hello")
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            reverse_words(String::from("a good   example")),
            String::from("example good a")
        );
    }
}
