package csw.java.cluster;


import java.util.Collection;

/**
 * 作用:
 *
 * @author chensw
 * @since 2019/7/26
 */

public interface LinkageStrategy {

    Double calculateDistance(Collection<Double> distances);
}