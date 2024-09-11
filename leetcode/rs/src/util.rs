pub fn sort_vec_vec_elems(result: &mut Vec<Vec<i32>>) {
    for v in result.iter_mut() {
        v.sort();
    }
}

pub fn sort_vec_vec_deep(result: &mut Vec<Vec<i32>>) {
    sort_vec_vec_elems(result);
    result.sort();
}
