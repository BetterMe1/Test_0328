package Test_0328;

/*
分苹果
题目描述
n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，
每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
输入描述:
每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
输出描述:
输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
示例1
输入
4
7 15 9 5
输出
3
 */
/*
 * 分析：
 * 第一行输入的数字记为n,第二行用数组存入输入的数字，存入的过程计算苹果数之和sum,
 * 计算分完后每个奶牛多分到的苹果d=sum/n,检验d*n是否等于sum,不等于返回-1，
 * res存最后返回的值，遍历数组，若遍历到的数字大于d,判断nums[i]-d是否是2的倍数，不是返回-1，
 * 是，则将(nums[i]-d)/2累加到res中，最终返回res。
 */
//import java.util.Scanner;
//public class Test{
//    public static void main(String[] args){
//        System.out.println(divideApple());
//    }
//    private static int divideApple(){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        int sum = 0;
//        for(int i=0;i<n; i++){
//            nums[i] = sc.nextInt();
//            sum += nums[i];
//        }
//        int d = sum / n;
//        if(d * n != sum){
//            return -1;
//        }
//        int res = 0;
//        for(int i=0; i<n; i++){
//            int k = nums[i] - d;
//            if(k > 0){
//                if(k % 2 == 0){
//                    res += k/2;
//                }else{
//                    return -1;
//                }
//            } 
//        }
//        return res;
//    } 
//}
/*
星际穿越
题目描述
航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，科学家根据实验数据估计，如果在发射过程中，产生了 x 程度的损耗，那么在降落的过程中就会产生 x2 程度的损耗，如果飞船的总损耗超过了它的耐久度，飞行器就会爆炸坠毁。问一艘耐久度为 h 的飞行器，假设在飞行过程中不产生损耗，那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程中可以承受多少程度的损耗？
输入描述:
每个输入包含一个测试用例。每个测试用例包含一行一个整数 h （1 <= h <= 10^18）。
输出描述:
输出一行一个整数表示结果。
示例1
输入
10
输出
2
 */
//import java.util.Scanner;
//public class Test{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        long h = sc.nextLong();
//        long r = (long)Math.sqrt(h);
//        while(r*r + r > h){
//            r--;
//        }
//        System.out.println(r);
//    }
//}
/*
338. 比特位计数
 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:
输入: 2
输出: [0,1,1]
示例 2:
输入: 5
输出:
 [0,1,1,2,1,2]
进阶:
•给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
•要求算法的空间复杂度为O(n)。
•你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
/*
 * 分析：
要在O(n)的时间复杂度下一次性扫描做到，那就必然得找出这组数的联系，从二进制数字的进位中可以发现：
如果此二进制数字末位为1，那么它的比特位计数就比和它小1的二进制数字刚好多了一个比特位，
如：整数3--->二进制011，整数2（3-1）--->二进制010，整数3比特位计数 = 整数2比特位计数 + 1（末位0变1式进位），
如果此二进制数字末位不为1，那么它的比特位计数就等于比和它小1的二进制数字的比特位计数，
如：整数2--->二进制010，整数1（2-1）--->二进制001，整数2比特位计数 = 整数1比特位计数 （末位1向前进位），
此时，若数字 i 与（i-1）作&运算，若i末位是1，相当于抹去的是i 末位0变1的1，
若i末位不是1，则抹去的是i 中向前进位的1，即 i的比特位计数 = i&（i-1）的比特位计数 + 1。
因为i&（i-1）小于i,所以我们可以使用前面的数计算出后面的数，基数也就是0的比特位基数是0.
 */
public class Test {
	public static void main(String[] args) {
		Solution So = new Solution();
		int num = 5;
		int[] res = So.countBits(num);
		for(int i=0; i<num+1; i++){
			System.out.print(res[i]+" ");
		}
	}
}
class Solution {
    public int[] countBits(int num) {
        int res[] = new int[num+1];
        for(int i=0; i<=num; i++){
            if(i == 0){
                res[i] = 0;
            }else{
                res[i] = res[i&(i-1)]+1;
            }
        }
        return res;
    }
}