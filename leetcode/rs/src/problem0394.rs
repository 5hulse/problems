pub fn decode_string(s: String) -> String {
    let mut result = String::new();
    let mut num: u32 = 0;
    let mut stack: Vec<(u32, String)> = Vec::new();

    for c in s.chars() {
        if c.is_ascii_digit() {
            num = 10 * num
                + u32::from_str_radix(&c.to_string(), 10).expect("Numerical value is guaranteed");
        } else if c == '[' {
            stack.push((num, result.clone()));
            result = String::new();
            num = 0;
        } else if c == ']' {
            let (x, mut st) = stack.pop().unwrap();
            st.push_str(&multiply_string(result.clone(), x));
            result = st
        } else {
            // Alphabetical
            result.push(c);
        }
    }

    result
}

fn multiply_string(s: String, x: u32) -> String {
    let mut result = String::new();
    for _ in 0..x {
        result.push_str(&s);
    }
    result
}

#[cfg(test)]
pub mod tests {
    use crate::problem0394::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            decode_string(String::from("3[a]2[bc]")),
            String::from("aaabcbc")
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            decode_string(String::from("3[a2[c]]")),
            String::from("accaccacc")
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            decode_string(String::from("2[abc]3[cd]ef")),
            String::from("abcabccdcdcdef")
        );
    }
}
