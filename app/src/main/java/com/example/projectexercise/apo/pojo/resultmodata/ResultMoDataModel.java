package com.example.projectexercise.apo.pojo.resultmodata;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.projectexercise.apo.pojo.resultmodata.related_parent_part.RelatedParentPart;
import com.example.projectexercise.apo.pojo.resultmodata.related_tech_route.RelatedTechRoute;

import java.io.Serializable;

public class ResultMoDataModel implements Serializable {
    private String mo_id;
    private String so_id;
    private String item_name;
    private String item_id;
    private String customer;
    private String qty;
    private String complete_date;
    private String online_date;
    private RelatedTechRoute related_tech_route;
    private RelatedParentPart related_parent_part;


    public RelatedTechRoute getRelated_tech_route() {
        return related_tech_route;
    }


    public String getMo_id() {
        return mo_id;
    }

    public RelatedParentPart getRelated_parent_part() {
        return related_parent_part;
    }

    public String getSo_id() {
        return so_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getComplete_date() {
        return complete_date;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getQty() {
        return qty;
    }


    public String getOnline_date() {
        return online_date;
    }
}

/*
{
        "id": 29,
        "mo_id": "1MO1911200082",
        "item_id": "LF-F2671CP-2",
        "item_name": "2671CP 地蓋 0.8*539*712M/M-雷射組(M1-F2671CP-2)",
        "qty": 10,
        "techroutekey_id": "1000-00-0",
        "online_date": "2019-12-09",
        "complete_date": "2019-12-17",
        "so_id": "1SOA1911180001",
        "batch": 4,
        "created_at": "2019-12-25 01:06:38",
        "updated_at": "2019-12-25 10:46:12",
        "customer": "臺灣明昌",
        "demand_complete_date": "2019-12-09",
        "bill_date": "2019-11-20",
        "related_tech_route": {
            "id": 1,
            "tech_routing_id": "1000-00-0",
            "tech_routing_name": "一群-雷射",
            "factory": "1000",
            "factory_id": "1000",
            "internal_code": "001",
            "status": "2",
            "org_id": "10",
            "transfer_factory": "0",
            "factory_type": "10",
            "routing_level": "11",
            "aps_id": "1110",
            "assign_work": null,
            "standard_time": null,
            "standard_pre_time": null,
            "standard_tct": null,
            "change_time": null,
            "device_multiple": null,
            "min_unable_order_time": null,
            "default_resource": null,
            "created_at": "2019-08-30 15:18:49",
            "updated_at": "2019-08-30 15:18:49"
        },
        "related_parent_part": {
            "id": 136,
            "material_id": "LF-F2671CP-2",
            "bomkey_id": "LF-F2671CP-2",
            "bomkey_name": "2671CP 地? 0.8*539*712M/M-雷射?(M1-F2671CP-2)",
            "unit_id": "PCS",
            "techroutekey_id": "1000-00-0",
            "fetch_type": 1,
            "created_at": "2019-12-25 01:06:42",
            "updated_at": "2019-12-25 01:06:43",
            "downstream_child": [
                {
                    "id": 168,
                    "top_id": 136,
                    "down_id": 140,
                    "row_no": 1,
                    "row_id": 1,
                    "unit_id": "KG",
                    "unit_qty": 2.38,
                    "nuse_qty": 2.38,
                    "base_qty": 1,
                    "remark": "",
                    "item_id": "ATC26271-06C",
                    "level": 5,
                    "created_at": "2019-12-25 01:06:43",
                    "updated_at": "2019-12-25 01:06:43",
                    "parent": {
                        "id": 140,
                        "material_id": "01C-0801120C",
                        "bomkey_id": null,
                        "bomkey_name": "雷射機用料 0.8*1120*C  用量以公斤計",
                        "unit_id": null,
                        "techroutekey_id": null,
                        "fetch_type": 0,
                        "created_at": "2019-12-25 01:06:43",
                        "updated_at": "2019-12-25 01:06:46"
                    }
                }
            ]
        }
    }
}
 */
