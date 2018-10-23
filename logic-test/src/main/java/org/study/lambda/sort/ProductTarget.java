package org.study.lambda.sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class ProductTarget {
    private final Long kws_rank;

    private final Long productid;

    private final Long kw_prod_rnk;

    private final Long star_score;

    private final Long comment_count;
}
