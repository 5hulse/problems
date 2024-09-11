pub fn remove_stars(s: String) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        // Don't need to check for empty string:
        // pop on empty string simply returns None instead of Some(char)
        if c == '*' {
            result.pop();
        } else {
            result.push(c);
        }
    }
    result
}

#[cfg(test)]
pub mod tests {
    use crate::problem2390::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            remove_stars(String::from("leet**cod*e")),
            String::from("lecoe")
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(remove_stars(String::from("erase*****")), String::from(""));
    }
}
