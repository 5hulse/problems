from typing import List, Tuple, Set

from leetcode import problem18


def process(result: Set[Tuple[int, int, int, int]]) -> List[List[int]]:
    return sorted([sorted(list(x)) for x in result])


def assert_eq(l1: Set[Tuple[int, int, int, int]], l2: List[List[int]]) -> bool:
    assert process(l1) == l2


def test_1() -> None:
    assert_eq(
        process(problem18.four_sum([1, 0, -1, 0, -2, 2], 0)),
        [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]],
    )


def test_2() -> None:
    assert_eq(
        process(problem18.four_sum([2, 2, 2, 2, 2], 8)),
        [[2, 2, 2, 2]],
    )
