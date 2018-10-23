package org.study.lambda.sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class ProductPackage {

    private final Long productid;

    private final Long star_score;

    private final Long comment_count;
}
