package leetcode.simple

object SolutionsK {
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val map = HashMap<Int, Int>()
        for(i in nums.indices) {
            val value = map[nums[i]]
            if (value != null) {
                return intArrayOf(value, i)
            }
            map[target - nums[i]] = i
        }
        return null
    }
}