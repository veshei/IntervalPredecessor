# IntervalPredecessor
Consider a family of n arbitrary intervals I = { [s1, f1], ..., [sn, fn] }. For a given 1 ≤ j ≤ n, let p(j) denote the index of the right most interval to the left of the interval Ij = [sj, fj]. Formally, p(j) is the index of the interval [s, f] with the property that f < sj, and there is no interval [s', f'] in I satisfying f < f' < sj. If such interval does not exist, set p(j)=-1.
Implement an algorithm which given the family I produces the whole list (p(1), p(2), ..., p(n)). 
