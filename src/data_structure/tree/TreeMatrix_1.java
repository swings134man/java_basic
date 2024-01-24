package data_structure.tree;

import java.util.Arrays;

/************
 * @info : Java Tree Matrix
 * @name : TreeMatrix_1
 * @date : 11/16/23 12:02 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 1차원 배열 Tree
 *
 * 각 부모 노드를 출력함.
 *
 *
 *          1
 *        /   \
 *       2     3
 *      / \   /
 *     3   4 5
 ************/
public class TreeMatrix_1 {

    // 1차원 배열 Tree 구현
    public static int[] makeTree(int n) {
        int[] res = new int[n + 1];

        /**
         * index 1은 root node 이므로, 2부터 시작한다.
         * 정렬되어있다고 가정했을때 기준
         */
        for(int i=2; i< n; i++){
            res[i] = i/2; // node i의 부모 노드는 i/2
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6;

        int[] res = makeTree(n);
        System.out.println("Res = " + Arrays.toString(res));
    }

}
