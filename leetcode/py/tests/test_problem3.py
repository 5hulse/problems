from leetcode import problem3


def test_1() -> None:
    assert problem3.length_of_longest_substring("abcabcbb") == 3


def test_2() -> None:
    assert problem3.length_of_longest_substring("bbbbb") == 1


def test_3() -> None:
    assert problem3.length_of_longest_substring("pwwkew") == 3


def test_4() -> None:
    assert problem3.length_of_longest_substring("dvdf") == 3
