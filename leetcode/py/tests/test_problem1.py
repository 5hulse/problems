from leetcode import problem1


def test_1() -> None:
    assert problem1.two_sum([2, 7, 11, 15], 9) == [0, 1]


def test_2() -> None:
    assert problem1.two_sum([3, 2, 4], 6) == [1, 2]


def test_3() -> None:
    assert problem1.two_sum([3, 3], 6) == [0, 1]
