import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binarytreerightside {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> n = new ArrayList<Integer>();
		if (root == null)
			return n;
		LinkedList<TreeNode> x = new LinkedList<TreeNode>();
		LinkedList<TreeNode> y = new LinkedList<TreeNode>();
		x.add(root);

		while (!x.isEmpty()) {
			TreeNode z = x.remove();
			int val = z.val;
			if (z.left != null)
				y.add(z.left);
			if (z.right != null)
				y.add(z.right);

			if (x.isEmpty()) {
				x = y;
				y = new LinkedList<TreeNode>();
				n.add(val);
			}
		}
		return n;
	}
}
