package org.study.mytest;

public class EmailProductTarget {
    private long kws_rank;

    private long productid;

    private long kw_prod_rnk;

    public EmailProductTarget(long kws_rank, long productid, long kw_prod_rnk) {
        this.kws_rank = kws_rank;
        this.productid = productid;
        this.kw_prod_rnk = kw_prod_rnk;
    }

    public long getKws_rank() {
        return kws_rank;
    }

    public void setKws_rank(long kws_rank) {
        this.kws_rank = kws_rank;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public long getKw_prod_rnk() {
        return kw_prod_rnk;
    }

    public void setKw_prod_rnk(long kw_prod_rnk) {
        this.kw_prod_rnk = kw_prod_rnk;
    }
}
