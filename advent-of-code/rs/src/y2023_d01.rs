fn get_digits(chars: &[u8]) -> Vec<u8> {
    let mut digits: Vec<u8> = Vec::new();
    for i in 0..chars.len() {
        if chars[i].is_ascii_digit() {
            digits.push(chars[i]);
        }
    }
    digits
}

fn get_digits_2(chars: &[u8]) -> Vec<u8> {
    let mut digits: Vec<u8> = Vec::new();
    for i in 0..chars.len() {
        if chars[i].is_ascii_digit() {
            digits.push(chars[i]);
            continue;
        }
        if i + 3 < chars.len() {
            match &chars[i..i + 3] {
                b"one" => {
                    digits.push(b'1');
                    continue;
                }
                b"two" => {
                    digits.push(b'2');
                    continue;
                }
                b"six" => {
                    digits.push(b'6');
                    continue;
                }
                _ => (),
            }
        }
        if i + 4 < chars.len() {
            match &chars[i..i + 4] {
                b"four" => {
                    digits.push(b'4');
                    continue;
                }
                b"five" => {
                    digits.push(b'5');
                    continue;
                }
                b"nine" => {
                    digits.push(b'9');
                    continue;
                }
                _ => (),
            }
        }
        if i + 5 < chars.len() {
            match &chars[i..i + 5] {
                b"three" => {
                    digits.push(b'3');
                    continue;
                }
                b"seven" => {
                    digits.push(b'7');
                    continue;
                }
                b"eight" => {
                    digits.push(b'8');
                    continue;
                }
                _ => (),
            }
        }
    }
    digits
}

fn u8_ascii_to_u32(c: u8) -> u32 {
    (c as char).to_digit(10).unwrap()
}

pub fn part1(input: &String) -> i32 {
    let mut result: u32 = 0;
    for line in input.lines() {
        let bytes: &[u8] = line.as_bytes();
        let digits: Vec<u8> = get_digits(bytes);
        result += 10 * u8_ascii_to_u32(digits[0]) + u8_ascii_to_u32(digits[digits.len() - 1]);
    }
    result as i32
}

pub fn part2(input: &String) -> i32 {
    let mut result: u32 = 0;
    for line in input.lines() {
        let bytes: &[u8] = line.as_bytes();
        let digits: Vec<u8> = get_digits_2(bytes);
        println!("digits: {:?}", digits);
        result += 10 * u8_ascii_to_u32(digits[0]) + u8_ascii_to_u32(digits[digits.len() - 1]);
    }
    result as i32
}

#[cfg(test)]
pub mod tests {
    use crate::util::load_example;
    use crate::y2023_d01::*;

    #[test]
    pub fn test_example1() {
        let (input, output) = load_example(2023, 1, 1).expect("Error loading example");
        assert_eq!(part1(&input), output);
    }

    #[test]
    pub fn test_example2() {
        let (input, output) = load_example(2023, 1, 2).expect("Error loading example");
        assert_eq!(part2(&input), output);
    }
}
