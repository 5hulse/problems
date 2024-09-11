use std::collections::HashSet;

pub fn gcd_of_strings(str1: String, str2: String) -> String {
    let div1: HashSet<String> = divisors(&str1);
    let div2: HashSet<String> = divisors(&str2);
    let mut gcd: String = String::new();
    for s in div1.intersection(&div2) {
        if s.len() > gcd.len() {
            gcd = s.to_string();
        }
    }
    gcd
}

fn divisors(s: &str) -> HashSet<String> {
    let mut divisors: HashSet<String> = HashSet::new();
    divisors.insert(s.to_string());
    let length: usize = s.len();
    for i in 1..length / 2 + 1 {
        // Check for multiple of string length
        if length % i == 0 {
            let mut is_divisor: bool = true;
            let first_chunk = &s[..i];
            for j in 1..length / i {
                if first_chunk != &s[j * i..(j + 1) * i] {
                    is_divisor = false;
                    break;
                }
            }
            if is_divisor {
                divisors.insert(first_chunk.to_string());
            }
        }
    }
    divisors
}

#[cfg(test)]
pub mod tests {
    use crate::problem1071::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            gcd_of_strings(String::from("ABCABC"), String::from("ABC")),
            String::from("ABC")
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            gcd_of_strings(String::from("ABABAB"), String::from("ABAB")),
            String::from("AB")
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            gcd_of_strings(String::from("LEET"), String::from("CODE")),
            String::from("")
        );
    }
}
