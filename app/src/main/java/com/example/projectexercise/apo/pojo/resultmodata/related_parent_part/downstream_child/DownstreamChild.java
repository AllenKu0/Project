package com.example.projectexercise.apo.pojo.resultmodata.related_parent_part.downstream_child;

import com.example.projectexercise.apo.pojo.resultmodata.related_parent_part.downstream_child.parent.Parent;

import java.io.Serializable;

public class DownstreamChild implements Serializable {
    private String unit_qty;
    private String unit_id;
    private String nuse_qty;
    private String item_id;
    private Parent parent;

    public String getUnit_id() {
        return unit_id;
    }

    public String getUnit_qty() {
        return unit_qty;
    }

    public String getItem_id() {
        return item_id;
    }

    public Parent getParent() {
        return parent;
    }

    public String getNuse_qty() {
        return nuse_qty;
    }
}
