#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

pub fn add_two_numbers(
    mut l1: Option<Box<ListNode>>,
    mut l2: Option<Box<ListNode>>,
) -> Option<Box<ListNode>> {
    let mut v1;
    let mut v2;
    let mut sum;
    let mut carry: i32 = 0;

    let mut dummy_head = Box::new(ListNode::new(0));
    let mut current = &mut dummy_head;

    while l1.is_some() || l2.is_some() {
        match l1 {
            Some(list_node) => {
                v1 = list_node.val;
                l1 = list_node.next;
            }
            None => {
                v1 = 0;
            }
        }

        match l2 {
            Some(list_node) => {
                v2 = list_node.val;
                l2 = list_node.next;
            }
            None => {
                v2 = 0;
            }
        }

        sum = v1 + v2 + carry;

        current.next = Some(Box::new(ListNode::new(sum % 10)));
        current = current.next.as_mut().unwrap();

        carry = sum / 10;
    }

    if carry > 0 {
        current.next = Some(Box::new(ListNode::new(carry)));
    }

    dummy_head.next
}

#[cfg(test)]
pub mod tests {
    use crate::problem0002::*;

    #[test]
    pub fn test1() {
        let l1: Option<Box<ListNode>> = Some(Box::new(ListNode {
            val: 2,
            next: Some(Box::new(ListNode {
                val: 4,
                next: Some(Box::new(ListNode { val: 3, next: None })),
            })),
        }));

        let l2: Option<Box<ListNode>> = Some(Box::new(ListNode {
            val: 5,
            next: Some(Box::new(ListNode {
                val: 6,
                next: Some(Box::new(ListNode { val: 4, next: None })),
            })),
        }));

        let l3: Option<Box<ListNode>> = Some(Box::new(ListNode {
            val: 7,
            next: Some(Box::new(ListNode {
                val: 0,
                next: Some(Box::new(ListNode { val: 8, next: None })),
            })),
        }));

        assert_eq!(add_two_numbers(l1, l2), l3)
    }

    #[test]
    pub fn test2() {
        let l1: Option<Box<ListNode>> = Some(Box::new(ListNode::new(0)));
        let l2: Option<Box<ListNode>> = Some(Box::new(ListNode::new(0)));
        let l3: Option<Box<ListNode>> = Some(Box::new(ListNode::new(0)));

        assert_eq!(add_two_numbers(l1, l2), l3)
    }

    #[test]
    pub fn test3() {
        let l1: Option<Box<ListNode>> = Some(Box::new(ListNode {
            val: 9,
            next: Some(Box::new(ListNode {
                val: 9,
                next: Some(Box::new(ListNode {
                    val: 9,
                    next: Some(Box::new(ListNode {
                        val: 9,
                        next: Some(Box::new(ListNode {
                            val: 9,
                            next: Some(Box::new(ListNode {
                                val: 9,
                                next: Some(Box::new(ListNode::new(9))),
                            })),
                        })),
                    })),
                })),
            })),
        }));

        let l2: Option<Box<ListNode>> = Some(Box::new(ListNode {
            val: 9,
            next: Some(Box::new(ListNode {
                val: 9,
                next: Some(Box::new(ListNode {
                    val: 9,
                    next: Some(Box::new(ListNode::new(9))),
                })),
            })),
        }));

        let l3: Option<Box<ListNode>> = Some(Box::new(ListNode {
            val: 8,
            next: Some(Box::new(ListNode {
                val: 9,
                next: Some(Box::new(ListNode {
                    val: 9,
                    next: Some(Box::new(ListNode {
                        val: 9,
                        next: Some(Box::new(ListNode {
                            val: 0,
                            next: Some(Box::new(ListNode {
                                val: 0,
                                next: Some(Box::new(ListNode {
                                    val: 0,
                                    next: Some(Box::new(ListNode::new(1))),
                                })),
                            })),
                        })),
                    })),
                })),
            })),
        }));

        assert_eq!(add_two_numbers(l1, l2), l3)
    }
}
