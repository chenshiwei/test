package csw.java.cluster;

/**
 * 作用:
 *
 * @author chensw
 * @since 2019/7/26
 */
public class Test {
    public static void main(String[] args) {
        String[] names = new String[]{"KPI1", "KPI2", "KPI3", "KPI4", "KPI5", "KPI6"};
        double[][] distances = new double[][]{
            {0, 1, 9, 7, 11, 14},
            {1, 0, 4, 3, 8, 10},
            {9, 4, 0, 9, 2, 8},
            {7, 3, 9, 0, 6, 13},
            {11, 8, 2, 6, 0, 10},
            {14, 10, 8, 13, 10, 0}};

        ClusteringAlgorithm alg = new ClusteringAlgorithm();
        Cluster cluster = alg.performClustering(distances, names, new SingleLinkageStrategy());
//        cluster.toConsole(0);
        StringBuilder sb = new StringBuilder();
        cluster.toConsole(0, sb);
        System.out.println(sb);
        System.out.println(cluster.getTotalDistance());
    }
}
