use std::collections::HashMap;

pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
    let length: usize = grid.len();

    let mut rows: HashMap<String, i32> = HashMap::new();
    let mut row: String;
    let mut row_str: String;

    let mut cols: HashMap<String, i32> = HashMap::new();
    let mut col: String;
    let mut col_str: String;

    for i in 0..length {
        row = String::new();
        col = String::new();

        for j in 0..length {
            row_str = grid[i][j].to_string();
            col_str = grid[j][i].to_string();

            if j != length - 1 {
                row_str.push('_');
                col_str.push('_');
            }

            row.push_str(&row_str);
            col.push_str(&col_str);
        }

        match rows.get_mut(&row) {
            Some(x) => {
                *x += 1;
            }
            None => {
                rows.insert(row, 1);
            }
        }

        match cols.get_mut(&col) {
            Some(x) => {
                *x += 1;
            }
            None => {
                cols.insert(col, 1);
            }
        }
    }
    let mut result: i32 = 0;

    for (row, row_count) in rows.iter() {
        match cols.get(row) {
            Some(col_count) => {
                result += row_count * col_count;
            }
            None => (),
        }
    }

    result
}

#[cfg(test)]
pub mod tests {
    use crate::problem2352::*;

    #[test]
    pub fn test1() {
        assert_eq!(
            equal_pairs(vec![vec![3, 2, 1], vec![1, 7, 6], vec![2, 7, 7]]),
            1
        );
    }

    #[test]
    pub fn test2() {
        assert_eq!(
            equal_pairs(vec![
                vec![3, 1, 2, 2],
                vec![1, 4, 4, 5],
                vec![2, 4, 2, 2],
                vec![2, 4, 2, 2]
            ]),
            3
        );
    }
}
