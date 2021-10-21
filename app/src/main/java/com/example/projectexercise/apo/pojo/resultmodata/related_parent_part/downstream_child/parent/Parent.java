package com.example.projectexercise.apo.pojo.resultmodata.related_parent_part.downstream_child.parent;

import java.io.Serializable;

public class Parent implements Serializable {
    private String id;
    private String material_id;
    private String bomkey_name;
    private String unit_id;

    public String getId() {
        return id;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public String getBomkey_name() {
        return bomkey_name;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public String getFetch_type() {
        return fetch_type;
    }

    private String fetch_type;
}
