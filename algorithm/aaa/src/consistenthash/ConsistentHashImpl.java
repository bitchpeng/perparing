package consistenthash;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class ConsistentHashImpl implements ConsistentHash {


    /**
     * 真实节点对应虚拟节点
     */
    private SortedMap<String, List<String>> realNodeToVirtualNode;
    /**
     * 虚拟节点名称模板
     */
    private static final String virtualNodeFormat = "%s&&VN%s";
    /**
     * hash值对应节点
     */
    private SortedMap<Integer, String> hashToNodes;

    /**
     * 节点对应数据
     */
    private Map<String, List<String>> nodeToData;
    /**
     * 每个节点对应虚拟节点数量
     */
    private int virtualNodeNum;

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值
     *
     * @param data
     * @return
     */
    private int getHash(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++)
            hash = (hash ^ data.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    @Override
    public boolean addNode(String node) {
        //添加node
        int hash = getHash(node);
        if (hashToNodes.isEmpty()) {
            hashToNodes.put(hash, node);
            nodeToData.put(node, new LinkedList<>());
            //添加虚拟节点
        } else {
            SortedMap<Integer, String> greatServers = hashToNodes.tailMap(hash);
            //前一个节点的hash
            int preHash=greatServers.firstKey();
            //前一个节点的node
            String preNode = greatServers.isEmpty() ? hashToNodes.get(hashToNodes.firstKey()) : greatServers.get(greatServers.firstKey());





        }


        return false;
    }

    @Override
    public boolean delNode(String node) {
        return false;
    }

    @Override
    public boolean putData(String datas) {
        return false;
    }

    @Override
    public void printNodes() {

    }
}
