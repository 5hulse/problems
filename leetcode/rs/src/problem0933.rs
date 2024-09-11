use std::collections::VecDeque;

#[allow(dead_code)]
struct RecentCounter {
    queue: VecDeque<i32>,
}

#[allow(dead_code)]
impl RecentCounter {
    pub fn new() -> Self {
        RecentCounter {
            queue: VecDeque::new(),
        }
    }

    pub fn ping(&mut self, t: i32) -> i32 {
        loop {
            match self.peek() {
                Some(x) => {
                    if t > x + 3000 {
                        self.queue.pop_front();
                    } else {
                        break;
                    }
                }
                None => {
                    break;
                }
            }
        }
        self.queue.push_back(t);
        self.queue.len() as i32
    }

    pub fn peek(&self) -> Option<i32> {
        match self.queue.len() {
            0 => None,
            _ => Some(self.queue[0] as i32),
        }
    }
}

#[cfg(test)]
pub mod tests {
    use crate::problem0933::*;

    #[test]
    pub fn test1() {
        let mut counter = RecentCounter::new();
        let mut result: Vec<i32> = Vec::new();
        for t in [1, 100, 3001, 3002] {
            result.push(counter.ping(t));
        }
    }
}
