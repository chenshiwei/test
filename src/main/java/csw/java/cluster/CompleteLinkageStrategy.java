package csw.java.cluster;

import java.util.Collection;

/**
 * 作用:
 *
 * @author chensw
 * @since 2019/7/26
 */

public class CompleteLinkageStrategy implements LinkageStrategy {

    @Override
    public Double calculateDistance(Collection<Double> distances) {
        double max = Double.NaN;

        for (Double dist : distances) {
            if (Double.isNaN(max) || dist > max)
                max = dist;
        }
        return max;
    }
}
