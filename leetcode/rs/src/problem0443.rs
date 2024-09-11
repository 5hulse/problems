pub fn compress(chars: &mut Vec<char>) -> i32 {
    let mut prev = chars[0];
    let mut curr: char;
    let mut count: i32 = 1;
    let mut left: usize = 0;
    let mut right: usize = 1;

    // dummy character
    if chars[chars.len() - 1] != 'X' {
        chars.push('X');
    } else {
        chars.push('x');
    }

    while right < chars.len() {
        curr = chars[right];
        if curr == prev && right < chars.len() - 1 {
            count += 1;
            right += 1;
        } else {
            if count == 1 {
                left += 1;
                right += 1;
            } else {
                for _ in 0..count - 1 {
                    chars.remove(left + 1);
                }
                for c in count.to_string().chars().rev() {
                    chars.insert(left + 1, c);
                }
                left += count.ilog10() as usize + 2;
                right = left + 1;
                count = 1;
            }
            prev = curr;
        }
    }
    chars.pop();
    chars.len() as i32
}

#[cfg(test)]
pub mod tests {
    use crate::problem0443::*;

    #[test]
    pub fn test1() {
        let mut s: Vec<char> = vec!['a', 'a', 'b', 'b', 'c', 'c', 'c'];
        let length: i32 = compress(&mut s);
        assert_eq!(length, 6);
        assert_eq!(s, vec!['a', '2', 'b', '2', 'c', '3']);
    }

    #[test]
    pub fn test2() {
        let mut s: Vec<char> = vec!['a'];
        let length: i32 = compress(&mut s);
        assert_eq!(length, 1);
        assert_eq!(s, vec!['a']);
    }

    #[test]
    pub fn test3() {
        let mut s: Vec<char> = vec![
            'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c',
        ];
        let length: i32 = compress(&mut s);
        assert_eq!(length, 6);
        assert_eq!(s, vec!['a', 'b', '1', '2', 'c', '2']);
    }
}
