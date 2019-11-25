package com.lugowoy.tasks.determineSuitabilityOfComponent;

import java.util.Collection;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class BatchOfComponents {

    private final Collection<Component> componentsCollection;

    public BatchOfComponents(Collection<Component> componentsCollection) {
        this.componentsCollection = componentsCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BatchOfComponents)) return false;

        BatchOfComponents that = (BatchOfComponents) o;

        return componentsCollection != null ? componentsCollection.equals(that.componentsCollection) : that.componentsCollection == null;
    }

    @Override
    public int hashCode() {
        return componentsCollection != null ? componentsCollection.hashCode() : 0;
    }

    public Collection<Component> getComponentsCollection() {
        return componentsCollection;
    }

}
