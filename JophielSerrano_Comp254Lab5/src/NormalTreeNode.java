import java.util.ArrayList;
import java.util.List;

public class NormalTreeNode {
    public int val;
    public List<NormalTreeNode> children;

    public NormalTreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

