use std::collections::HashMap;

pub fn close_strings(word1: String, word2: String) -> bool {
    if word1.len() != word2.len() {
        return false;
    }

    let map1 = build_map(word1);
    let map2 = build_map(word2);

    // Check that maps have the same set of keys
    // i.e. the words comprise the same set of characters
    if !(map1.keys().len() == map2.keys().len() && map1.keys().all(|c| map2.contains_key(c))) {
        return false;
    }

    map_to_values(map1) == map_to_values(map2)
}

fn build_map(word: String) -> HashMap<char, u32> {
    let mut map: HashMap<char, u32> = HashMap::new();
    for c in word.chars() {
        match map.get_mut(&c) {
            None => {
                map.insert(c, 1);
            }
            Some(count) => {
                *count += 1;
            }
        }
    }
    map
}

fn map_to_values(map: HashMap<char, u32>) -> Vec<u32> {
    let mut values = map.values().cloned().collect::<Vec<u32>>();
    values.sort();
    values
}

#[cfg(test)]
pub mod tests {
    use crate::problem1657::*;

    #[test]
    pub fn test1() {
        assert!(close_strings(String::from("abc"), String::from("bca")));
    }

    #[test]
    pub fn test2() {
        assert!(!close_strings(String::from("a"), String::from("aa")));
    }

    #[test]
    pub fn test3() {
        assert!(close_strings(
            String::from("cabbba"),
            String::from("abbccc")
        ));
    }
}
