/**
 * COPYRIGHT (C) 2016 Vamsi. 
 * 
 * @author Vamsi Dharmavarapu
 */
package com.jda.codehub.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public abstract class AbstractDTO<T> {

	protected T id;

    /**
     * The Constructor.
     */
    public AbstractDTO() {
    }

    /**
     * The Constructor.
     * 
     * @param id
     *            the id
     */
    public AbstractDTO(T id) {
        this.id = id;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    protected T getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id
     */
    protected void setId(T id) {
        this.id = id;
    }
}
