pub mod util;
pub mod y2023_d01;

pub fn main() {
    let y2023_d01_input = util::load_input(2023, 1).expect("Error getting input");
    y2023_d01::part1(&y2023_d01_input);
    y2023_d01::part2(&y2023_d01_input);
}
