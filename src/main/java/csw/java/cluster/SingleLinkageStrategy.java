package csw.java.cluster;

import java.util.Collection;

/**
 * 作用:
 *
 * @author chensw
 * @since 2019/7/26
 */

public class SingleLinkageStrategy implements LinkageStrategy {

    @Override
    public Double calculateDistance(Collection<Double> distances) {
        double min = Double.NaN;

        for (Double dist : distances) {
            if (Double.isNaN(min) || dist < min)
                min = dist;
        }
        return min;
    }
}
