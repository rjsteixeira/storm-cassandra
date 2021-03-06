package com.hmsonline.storm.cassandra.bolt.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import storm.trident.tuple.TridentTuple;
import backtype.storm.tuple.Values;

/**
 * Interface for mapping a Cassandra row(s) to Trident tuples.
 * 
 * @author tgoetz
 * 
 * @param <K> - Cassandra row key type
 * @param <C> - Cassandra column name (column key) type
 * @param <V> - Cassandra column value tupe
 */
public interface TridentColumnMapper<K, C, V> extends Serializable {

    /**
     * 
     * Given a row key (K), a <code>java.util.Map</code> of column
     * names(C)/values(V) associated with that key, return a list of values to
     * emit.
     * 
     * The <code>input</code> parameter is provided as a convenience for special
     * cases where the implementation class may need to inspect the incoming
     * <code>TridentTuple</code>, for example to perform some
     * implementation-specific logic.
     * 
     * In most cases, the <code>input</code> parameter will be ignored.
     * 
     * Examples of using the <code>input</code> parameter might include
     * situations where values in the incoming <code>TridentTuple</code> need to
     * be passed through to the emitted value, but would not be included in the
     * Cassandra row.
     * 
     * 
     * 
     * @param rowKey 
     * @param columns
     * @param input
     * @return
     */
    public List<Values> mapToValues(K rowKey, Map<C, V> columns, TridentTuple input);
}
