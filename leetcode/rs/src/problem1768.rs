pub fn merge_alternately(word1: String, word2: String) -> String {
    let mut result: String = String::with_capacity(word1.len() + word2.len());
    let mut chars1 = word1.chars();
    let mut chars2 = word2.chars();
    loop {
        match (chars1.next(), chars2.next()) {
            (Some(c1), Some(c2)) => {
                result.push(c1);
                result.push(c2);
            }
            (Some(c1), None) => {
                result.push(c1);
            }
            (None, Some(c2)) => {
                result.push(c2);
            }
            (None, None) => {
                break;
            }
        }
    }
    result
}

#[cfg(test)]
pub mod tests {
    use crate::problem1768::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            merge_alternately(String::from("abc"), String::from("pqr")),
            String::from("apbqcr")
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            merge_alternately(String::from("ab"), String::from("pqrs")),
            String::from("apbqrs")
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            merge_alternately(String::from("abcd"), String::from("pq")),
            String::from("apbqcd")
        );
    }
}
