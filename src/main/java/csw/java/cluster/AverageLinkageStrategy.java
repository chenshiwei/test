package csw.java.cluster;

import java.util.Collection;

/**
 * 作用:
 *
 * @author chensw
 * @since 2019/7/26
 */

public class AverageLinkageStrategy implements LinkageStrategy {

    @Override
    public Double calculateDistance(Collection<Double> distances) {
        double sum = 0;
        double result;

        for (Double dist : distances) {
            sum += dist;
        }
        if (distances.size() > 0) {
            result = sum / distances.size();
        } else {
            result = 0.0;
        }
        return result;
    }
}