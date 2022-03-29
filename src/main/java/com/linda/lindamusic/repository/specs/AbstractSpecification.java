package com.linda.lindamusic.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Nonnull;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 抽象规范
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public abstract class AbstractSpecification<T> implements Specification<T> {
    private final List<SearchCriteria> list;

    public AbstractSpecification() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria searchCriteria) {
        list.add(searchCriteria);
    }

    /**
     * 断言
     *
     * @param root    根
     * @param query   查询
     * @param builder 建设者
     * @return {@link Predicate}
     */
    @Override
    public Predicate toPredicate(@Nonnull Root<T> root, @Nonnull CriteriaQuery<?> query, @Nonnull CriteriaBuilder builder) {
        var predicates = new ArrayList<Predicate>();
        for (SearchCriteria criteria : list) {
            // Todo: 重构
            switch (criteria.getOperation()) {
                case IN -> predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
                case EQUAL -> predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
                case MATCH -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
                case NOT_IN -> predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
                case LESS_THAN -> predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                case MATCH_END -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%"));
                case NOT_EQUAL -> predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
                case MATCH_START -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase()));
                case GREATER_THAN -> predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                case LESS_THAN_EQUAL -> predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
                case GREATER_THAN_EQUAL -> predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}