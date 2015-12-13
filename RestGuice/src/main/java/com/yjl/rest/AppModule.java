package com.yjl.rest;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.yjl.rest.core.Container;
import com.yjl.rest.core.GlobalContainer;
import com.yjl.rest.resources.CollectionResource;

public class AppModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(CollectionResource.class);
        binder.bind(Container.class).toInstance(new GlobalContainer());
    }
}
