package com.example.projectexercise.apo.pojo.resultmodata.related_parent_part;

import com.example.projectexercise.apo.pojo.resultmodata.related_parent_part.downstream_child.DownstreamChild;

import java.io.Serializable;
import java.util.List;

public class RelatedParentPart implements Serializable {
    private int id;
    private String material_id;
    private String bomkey_name;
    private String unit_id;
    private String techroutekey_id;
    private int  fetch_type;
    //@SerializedName("downstream_child")
    private List<DownstreamChild> downstream_child =null;

    public int getId() {
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

    public String getTechroutekey_id() {
        return techroutekey_id;
    }

    public int getFetch_type() {
        return fetch_type;
    }

    public List<DownstreamChild> getDownstream_child() {
        return downstream_child;
    }
}
