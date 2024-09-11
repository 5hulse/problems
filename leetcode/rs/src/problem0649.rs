use std::collections::VecDeque;

pub fn predict_party_victory(senate: String) -> String {
    let length: usize = senate.len();
    let mut radiant_queue: VecDeque<usize> = VecDeque::new();
    let mut dire_queue: VecDeque<usize> = VecDeque::new();
    for (i, c) in senate.chars().enumerate() {
        if c == 'R' {
            radiant_queue.push_back(i);
        } else {
            dire_queue.push_back(i);
        }
    }

    let mut rpos: usize;
    let mut dpos: usize;

    loop {
        println!("radiant_queue: {:?}", radiant_queue);
        println!("dire_queue: {:?}", dire_queue);
        match radiant_queue.pop_front() {
            Some(x) => {
                rpos = x;
            }
            None => {
                return String::from("Dire");
            }
        }

        match dire_queue.pop_front() {
            Some(x) => {
                dpos = x;
            }
            None => {
                return String::from("Radiant");
            }
        }

        if rpos < dpos {
            radiant_queue.push_back(rpos + length);
        } else {
            dire_queue.push_back(dpos + length);
        }
    }
}

#[cfg(test)]
pub mod tests {
    use crate::problem0649::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            predict_party_victory(String::from("RD")),
            String::from("Radiant")
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            predict_party_victory(String::from("RDD")),
            String::from("Dire")
        );
    }

    #[test]
    pub fn test3() {
        assert_eq!(
            predict_party_victory(String::from("DDRRR")),
            String::from("Dire")
        );
    }
}
