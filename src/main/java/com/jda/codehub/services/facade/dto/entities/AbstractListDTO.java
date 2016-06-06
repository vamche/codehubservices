/**
 * COPYRIGHT (C) 2016 Vamsi. 
 * 
 * @author Vamsi Dharmavarapu
 */

package com.jda.codehub.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * Abstract class for all list DTOs. All sub-classes should provide json order
 * themselves, otherwise "count" field will be first.
 * 
 * @param <T>
 */
public abstract class AbstractListDTO<T extends AbstractDTO> extends
        AbstractDTO<Object> {
    private List<T> list;
    private long count;

    /**
     * Gets the count.
     * 
     * @return the count
     */
    public long getCount() {
        return count;
    }

    /**
     * Sets the count.
     * 
     * @param count
     *            the count
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * Gets the list.
     * 
     * @return the list
     */
   
    protected List<T> getList() {
        return list;
    }

    /**
     * Sets the list.
     * 
     * @param list
     *            the list
     */
    protected void setList(List<T> list) {
        this.list = list;
    }
}
