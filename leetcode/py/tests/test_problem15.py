from typing import List, Tuple, Set

from leetcode import problem15


def process(result: Set[Tuple[int, int, int]]) -> List[List[int]]:
    return sorted([sorted(list(x)) for x in result])


def assert_eq(l1: Set[Tuple[int, int, int]], l2: List[List[int]]) -> bool:
    assert process(l1) == l2


def test_1() -> None:
    assert_eq(
        process(problem15.three_sum([-1, 0, 1, 2, -1, -4])),
        [[-1, -1, 2], [-1, 0, 1]],
    )


def test_2() -> None:
    assert_eq(
        problem15.three_sum([0, 1, 1]),
        [],
    )


def test_3() -> None:
    assert_eq(
        problem15.three_sum([0, 0, 0]),
        [[0, 0, 0]],
    )
