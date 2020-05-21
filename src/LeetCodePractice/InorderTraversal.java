package LeetCodePractice;

import java.util.List;

public class InorderTraversal {

    List<Integer> inOrderTraversalList(TreeNode root, List<Integer> list){
        if(root != null){

            if(root.left != null){
                inOrderTraversalList(root.left,list);
            }

            list.add(root.value);

            if(root.right != null){
                inOrderTraversalList(root.right,list);
            }
        }
        return list;
    }
}
