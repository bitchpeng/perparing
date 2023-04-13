package consistenthash;

import java.util.List;

public interface ConsistentHash {

    //插入节点
    boolean addNode(String node);
    //删除节点
    boolean delNode(String node);

    //批量删除
    boolean putData(String datas);



    //打印节点
    void printNodes();


}
