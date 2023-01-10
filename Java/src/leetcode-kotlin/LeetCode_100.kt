package `leetcode-kotlin`

// https://leetcode.com/problems/same-tree/


fun main() {
    
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    val pp = ArrayList<Int?>()
    val qq = ArrayList<Int?>()
    checkTree(p, pp)
    checkTree(q, qq)
    return pp == qq
}

fun checkTree(t: TreeNode?, list: ArrayList<Int?>) {
    list.add(t?.`val`)
    if(t == null) return
    checkTree(t.left, list)
    checkTree(t.right, list)
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}